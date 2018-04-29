package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.UserDao;
import com.lcr.applyhelper.entity.User;
import com.lcr.applyhelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User queryUserById(String wechatId) {
        return userDao.queryUserById(wechatId);
    }

    @Transactional
    @Override
    public boolean insertUser(User user) {
        if(user.getWechatID()!=null){
            try{
                int eftnum=userDao.insertUser(user);
                if (eftnum>0){
                    return true;
                }else {
                    throw new RuntimeException("注册用户失败");
                }
            }catch (Exception e){
                throw new RuntimeException("注册用户失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("用户信息不能为空");
        }

    }

    @Override
    public boolean updateUser(User user) {
        if (user.getWechatID() != null ) {
            try {
                int effectedNum = userDao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新用户信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户信息失败" + e.getMessage());
            }
        }else {
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        if (userId > 0) {
            try {
                int effectedNum = userDao.deleteUser(userId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除用户信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户ID不能为空！");
        }
    }
}
