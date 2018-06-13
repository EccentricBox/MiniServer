package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.Recommend;

import java.util.List;

public interface RecommendMapper {

    Recommend selectByPrimaryKey(Integer uniID);

    List<Recommend> findAll();

}