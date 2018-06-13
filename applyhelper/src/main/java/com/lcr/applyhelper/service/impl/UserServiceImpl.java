package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.UserMapper;
import com.lcr.applyhelper.entity.User;
import com.lcr.applyhelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public int deleteByPrimaryKey(String wechatID) {
        try {
            int effectedNum = userDao.deleteByPrimaryKey(wechatID);
            if (effectedNum > 0) {
                return effectedNum;
            } else {
                throw new RuntimeException("删除用户信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除用户信息失败" + e.getMessage());
        }
    }

    @Transactional
    @Override
    public boolean insert(User record) {
        if(record.getWechatID()!=null){
            try{
                int eftnum=userDao.insert(record);
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
    public int insertSelective(User record) {
        return userDao.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String wechatID) {
        return userDao.selectByPrimaryKey(wechatID);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        if (record.getWechatID() != null ) {
            try {
                int effectedNum = userDao.updateByPrimaryKey(record);
                if (effectedNum > 0) {
                    return effectedNum;
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
}
