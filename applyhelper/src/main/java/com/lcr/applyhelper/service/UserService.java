package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(String wechatID);

    boolean insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String wechatID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
