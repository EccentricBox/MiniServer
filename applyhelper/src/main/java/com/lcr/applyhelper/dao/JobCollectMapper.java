package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.JobCollectKey;

import java.util.List;

public interface JobCollectMapper {
    int deleteByPrimaryKey(JobCollectKey key);

    int insert(JobCollectKey record);

    int insertSelective(JobCollectKey record);

    List<JobCollectKey> findByUserId(String userID);

}