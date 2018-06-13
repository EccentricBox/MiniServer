package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.Recommend;

import java.util.List;

public interface RecommendService {
    Recommend selectByPrimaryKey(Integer uniID);

    List<Recommend> findAll();
}
