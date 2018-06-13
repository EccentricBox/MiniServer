package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.JobApply;
import com.lcr.applyhelper.entity.JobapplyKey;

public interface JobapplyService {
    int insert(JobApply record);

    JobApply findById(JobapplyKey jobapplyKey);

    int updateByPrimaryKey(JobApply record);
}
