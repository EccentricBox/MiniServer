package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.Order;
import com.lcr.applyhelper.entity.OrderKey;

import java.util.List;

public interface OrderService {
    int deleteByPrimaryKey(OrderKey key);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(OrderKey key);

    List<Order> findByUserId(Integer userId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
