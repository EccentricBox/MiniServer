package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User queryUserById(String wechatId);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int userId);
}
