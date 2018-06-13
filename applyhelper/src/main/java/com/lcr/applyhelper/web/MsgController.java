package com.lcr.applyhelper.web;

import com.lcr.applyhelper.entity.Msg;
import com.lcr.applyhelper.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    private Map<String,Object> findAll(@RequestParam(value = "wechatID")String wechatID){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Msg> list=msgService.findAll(wechatID);
        modelMap.put("AllMsg",list);
        System.out.println("Msg：findAll");
        return modelMap;
    }
}
