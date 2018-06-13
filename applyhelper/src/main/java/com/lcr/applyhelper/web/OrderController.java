package com.lcr.applyhelper.web;

import com.lcr.applyhelper.dao.OrderMapper;
import com.lcr.applyhelper.dao.UserMapper;
import com.lcr.applyhelper.entity.Order;
import com.lcr.applyhelper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/addorder",method = RequestMethod.POST)
    private Map<String,Object> addorder(@RequestParam(value = "userId")String userId,
                                        @RequestParam(value = "helperId")String helperId){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        User user=userMapper.selectByPrimaryKey(userId);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Order order=new Order();
        order.setUserID(userId);
        order.setHelperID(helperId);
        order.setOrderstatus(1);
        order.setMoney(user.getFee());
        order.setPayTime(df.format(day));
        int effect=orderMapper.insert(order);

        if(effect>0){
            modelMap.put("addorder","success");
        }else{
            modelMap.put("addorder","fail");
        }
        return modelMap;
    }

    @RequestMapping(value = "/findorder",method = RequestMethod.POST)
    private Map<String,Object> findOrder(@RequestParam(value = "userId")Integer userId){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Order> list=orderMapper.findByUserId(userId);
        modelMap.put("findorder",list);
        return modelMap;
    }

    @RequestMapping(value = "/endorder",method = RequestMethod.POST)
    private Map<String,Object> endOrder(@RequestParam(value = "userId")String userId,
                                        @RequestParam(value = "helperId")String helperId,
                                        @RequestParam(value = "monry")String money){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Order order=new Order();
        order.setUserID(userId);;
        order.setHelperID(helperId);
        order.setOrderstatus(2);
        order.setMoney(money);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setPayTime(df.format(df));
        int effect=orderMapper.updateByPrimaryKeySelective(order);
        if(effect>0){
            modelMap.put("result","succrss");
        }else {
            modelMap.put("result","fail");
        }
        return modelMap;
    }

}
