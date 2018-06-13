package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.Job;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer jobID);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer jobID);

    List<Job> findAll(String city);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}