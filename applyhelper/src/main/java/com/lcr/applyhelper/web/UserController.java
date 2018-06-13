package com.lcr.applyhelper.web;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lcr.applyhelper.entity.Msg;
import com.lcr.applyhelper.entity.User;
import com.lcr.applyhelper.service.MsgService;
import com.lcr.applyhelper.service.UserService;
import com.lcr.applyhelper.utils.*;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.lcr.applyhelper.utils.Template.sendTemplateMsg;
import static org.bouncycastle.asn1.isismtt.ocsp.RequestedCertificate.certificate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MsgService msgService;

    @RequestMapping(value = "/queryUserById", method = RequestMethod.POST)
    private Map<String, Object> queryUserById(@RequestParam(value = "wechatID") String wechatID) {
        Map<String, Object> modelMap = new HashMap<>();
        System.out.println("ID:" + wechatID);
        modelMap.put("user", userService.selectByPrimaryKey(wechatID));
        return modelMap;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private Map<String, Object> addUser(@RequestParam(value = "code") String code,
                                        @RequestParam(value = "country") String couuntry,
                                        @RequestParam(value = "userhead")String userhead) throws UnsupportedEncodingException {
        Map<String, Object> modelMap = new HashMap<>();
        if (code == null) {
            modelMap.put("fail", -1);
            System.out.println("code为空\n");
            return modelMap;
        }
        User users = new User();
        com.alibaba.fastjson.JSONObject so = WXAppletUserInfo.getSessionKeyOropenid(code);
        if (so.containsKey("openid")) {
            System.out.println(so.toString());
        } else {
            modelMap.put("fail", -1);
            System.out.println("获取openid失败\n");
            return modelMap;
        }

        String openid = so.getString("openid");
        users.setUserID(openid);
        try {
            MessageDigest messageDigest;
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(openid.getBytes("UTF-8"));
            users.setWechatID(HashUtil.bytesToHex(hash));
            users.setUserCountry(couuntry);
            System.out.println(users.getWechatID());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        users.setUserhead(userhead);
        if (userService.selectByPrimaryKey(users.getWechatID()) != null) {
            modelMap.put("fail", "已注册");
            System.out.println("已注册");
        } else {
            if (userService.insert(users)) {
                User model = userService.selectByPrimaryKey(users.getWechatID());
                modelMap.put("success", model.getWechatID());
            } else {
                modelMap.put("fail", -1);
                System.out.println("注册失败\n");
            }
        }

        return modelMap;
    }

    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestParam(value = "userinfo") String userinfo) {
        Map<String, Object> modelMap = new HashMap<>();
        JSONObject jsonuser = JSONObject.parseObject(userinfo);
        User user = new User();
        user.setWechatID(jsonuser.getString("wechatID"));
        user.setUserCountry(jsonuser.getString("userCountry"));
        user.setUniversity(jsonuser.getString("university"));
        user.setRealName(jsonuser.getString("realName"));
        user.setMajor(jsonuser.getString("major"));
        user.setStuType(jsonuser.getString("stuType"));
        user.setGrade(jsonuser.getString("grade"));
        user.setSex(jsonuser.getString("sex"));
        user.setAge(jsonuser.getString("age"));

        System.out.println("修改个人信息：" + user.toString());
        modelMap.put("success", userService.updateByPrimaryKeySelective(user));
        return modelMap;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    private Map<String, Object> deleteArea(String wechatId) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", userService.deleteByPrimaryKey(wechatId));
        return modelMap;
    }

    @RequestMapping(value = "/usercer", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file")MultipartFile[] files,
                         @RequestParam(value = "code") String code,
                         @RequestParam(value = "wechatID") String wechatID,
                         @RequestParam(value = "formID") String formID,
                         @RequestParam(value = "certificate")String cer){

        System.out.println("上传认证："+files);
        String path = "src\\main"+"\\userCer"+"\\"+wechatID + "\\";
        System.out.println(path);
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        System.out.println("path=" + path);
        //多文件上传
        if(files!=null && files.length>=1) {
            BufferedOutputStream bw = null;
            try {
                String fileName = files[0].getOriginalFilename();
                if(fileName!=null) {
                    //创建输出文件对象
                    File outFile = new File(path + UUID.randomUUID().toString() + fileName);
                    //拷贝文件到输出文件对象
                    FileUtils.copyInputStreamToFile(files[0].getInputStream(), outFile);
                }
                //更新certificate字段
                User user = new User();
                user.setWechatID(wechatID);
                user.setCertificate(cer);
                int effect = userService.updateByPrimaryKeySelective(user);
                if (effect<1){
                    return "fail";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(bw!=null) {bw.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(addCerSuccessMsg(wechatID)<1){
                return "fail";
            }
            sendModuleMsg(code,wechatID,formID);
            return "success";
        }else {
            return "fail";
        }
    }

    private void sendModuleMsg(String code,String wechatID,String formid){
        System.out.println("code："+code);
        com.alibaba.fastjson.JSONObject so = WXAppletUserInfo.getSessionKeyOropenid(code);
        String openid = so.getString("openid");
        System.out.println("openid："+openid);
        String url="https://api.weixin.qq.com/cgi-bin/token?";
        String pa="grant_type=client_credential&appid=wxd2d49aca40112e3c&secret=9b51ec0def5d513e0a743947856ea2b2";
        String token=UrlUtil.sendGet(url,pa);
        net.sf.json.JSONObject jsonObject=net.sf.json.JSONObject.fromObject(token);
        token=jsonObject.getString("access_token");
        System.out.println("token:"+token);

        Template tem=new Template();
        tem.setTemplateId("f3jQxQrnUkwsN5DdcH8xW-vFtRltuakgFetYFZ51_is");
        tem.setForm_id(formid);
        tem.setTopColor("#00DD00");
        tem.setToUser(openid);
        tem.setUrl("");

        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("Name",userService.selectByPrimaryKey(wechatID).getRealName(),"#FF3333"));
        paras.add(new TemplateParam("CertifateType","System","#FF3333"));
        paras.add(new TemplateParam("Content","Please login our miniprogram to do the next step","#0044BB"));
        paras.add(new TemplateParam("CertifateStatus","PASS","#0044BB"));
        paras.add(new TemplateParam("Time",df.format(day),"#AAAAAA"));

        tem.setTemplateParamList(paras);

        boolean result=sendTemplateMsg(token,tem);
        System.out.println("模板：" +result);
    }

    private int addCerSuccessMsg(String wechatID){

        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Msg msg=new Msg();
        msg.setType("certifatesuccess");
        msg.setTitle("Certifacation Pass");
        msg.setTime(df.format(day));
        msg.setSender("System");
        msg.setContent("Please finish the last step");
        msg.setfID(wechatID);

        int effect=msgService.insertSelective(msg);
        System.out.println("addCerSuccessMsg");
        return effect;
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    private void test(String wechatId) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("test");
        String temp="liuchenrui";
        byte[] hash = temp.getBytes();
        String a=HashUtil.bytesToHexString(hash);
        System.out.println("hash:"+a);
        byte[] rehash = HashUtil.hexStringToBytes(a);
        String re= String.valueOf(rehash);
        System.out.println("re:"+re);
        return;
    }

}
