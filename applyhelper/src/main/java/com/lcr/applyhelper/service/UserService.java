package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User queryUserById(String wechatId);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int userId);

}
