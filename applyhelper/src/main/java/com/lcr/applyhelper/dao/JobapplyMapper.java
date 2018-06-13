package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.JobApply;
import com.lcr.applyhelper.entity.JobapplyKey;

public interface JobapplyMapper {
    int deleteByPrimaryKey(JobapplyKey key);

    int insert(JobApply record);

    int insertSelective(JobApply record);

    JobApply selectByPrimaryKey(JobapplyKey key);

    int updateByPrimaryKeySelective(JobApply record);

    int updateByPrimaryKey(JobApply record);
}