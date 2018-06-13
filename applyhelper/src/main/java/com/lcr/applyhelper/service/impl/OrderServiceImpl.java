package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.OrderMapper;
import com.lcr.applyhelper.entity.Order;
import com.lcr.applyhelper.entity.OrderKey;
import com.lcr.applyhelper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderDao;

    @Override
    public int deleteByPrimaryKey(OrderKey key) {
        return orderDao.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(Order record) {
        return orderDao.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderDao.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(OrderKey key) {
        return orderDao.selectByPrimaryKey(key);
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderDao.findByUserId(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderDao.updateByPrimaryKey(record);
    }
}
