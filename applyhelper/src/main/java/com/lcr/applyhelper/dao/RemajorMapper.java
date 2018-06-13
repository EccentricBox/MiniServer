package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.Remajor;

import java.util.List;

public interface RemajorMapper {
    int deleteByPrimaryKey(Integer majorID);

    int insert(Remajor record);

    int insertSelective(Remajor record);

    Remajor selectByPrimaryKey(Integer majorID);

    List<Remajor> findAll();

    int updateByPrimaryKeySelective(Remajor record);

    int updateByPrimaryKey(Remajor record);
}