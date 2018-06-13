package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.Order;
import com.lcr.applyhelper.entity.OrderKey;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(OrderKey key);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(OrderKey key);

    List<Order> findByUserId(Integer userId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}