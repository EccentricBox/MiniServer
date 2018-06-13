package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String wechatID);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String wechatID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}