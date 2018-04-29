package com.lcr.applyhelper.web;

import com.lcr.applyhelper.entity.User;
import com.lcr.applyhelper.service.UserService;
import com.lcr.applyhelper.utils.HashUtil;
import com.lcr.applyhelper.utils.WXAppletUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    private Map<String,Object> findAll(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<User> list=userService.findAll();
        modelMap.put("Alluser",list);
        return modelMap;
    }
    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    private Map<String,Object> queryUserById(String wecahtId){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("user",userService.queryUserById(wecahtId));
        return modelMap;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    private Map<String,Object> addUser(@RequestParam(value = "code") String code) throws UnsupportedEncodingException {
        Map<String,Object> modelMap = new HashMap<>();
        User users=new User();
        com.alibaba.fastjson.JSONObject so=WXAppletUserInfo.getSessionKeyOropenid(code);
        if(so.containsKey("openid")){
            System.out.println(so.toString());
        }else {
            modelMap.put("fail",-1);
            System.out.println("获取openid失败\n");
            return modelMap;
        }

        String openid=so.getString("openid");
        try {
            MessageDigest messageDigest;
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(openid.getBytes("UTF-8"));
            users.setWechatID(HashUtil.bytesToHex(hash));
            users.setUserCountry("");
            System.out.println(users.getWechatID());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (userService.insertUser(users)){
            User model=userService.queryUserById(users.getWechatID());
            modelMap.put("success",model.getWechatID());
        }else {
            modelMap.put("fail",-1);
            System.out.println("注册失败\n");
            return modelMap;
        }

        return modelMap;
    }

    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody User user) {
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success", userService.updateUser(user));
        return modelMap;
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    private Map<String,Object> deleteArea(Integer userId) {
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",userService.deleteUser(userId));
        return modelMap;
    }
}
