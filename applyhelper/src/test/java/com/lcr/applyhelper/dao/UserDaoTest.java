package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Ignore
    public void findAll() {
        Assert.assertNotNull(userDao);
        List<User> userList= userDao.findAll();
        assertEquals(7,userList.size());
    }

    @Test
    @Ignore
    public void queryUserById() {
        User user=userDao.queryUserById("");
        assertEquals("ofXhr5S9rsgRhRqX-HUTFRuymGD4",user.getWechatID());
    }

    @Test
    @Ignore
    public void insertUser() {
        User user=new User();
        user.setWechatID("1231323");
        user.setUserCountry("China");
        int effectedNum = userDao.insertUser(user);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void updateUser() {
        User user=new User();
        user.setUsersID(8);
        user.setWechatID("123456789");
        user.setUserCountry("China");
        int effectedNum = userDao.updateUser(user);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void deleteUser() {
        int effectedNum = userDao.deleteUser(9);
        assertEquals(1,effectedNum);
    }
}