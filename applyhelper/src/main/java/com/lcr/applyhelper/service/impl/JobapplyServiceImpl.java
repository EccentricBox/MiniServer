package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.JobapplyMapper;
import com.lcr.applyhelper.entity.JobApply;
import com.lcr.applyhelper.entity.JobapplyKey;
import com.lcr.applyhelper.service.JobapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobapplyServiceImpl implements JobapplyService {

    @Autowired
    private JobapplyMapper jobapplyMapper;

    @Override
    public int insert(JobApply record) {
        return jobapplyMapper.insert(record);
    }

    @Override
    public JobApply findById(JobapplyKey jobapplyKey) {
        return jobapplyMapper.selectByPrimaryKey(jobapplyKey);
    }

    @Override
    public int updateByPrimaryKey(JobApply record) {
        return jobapplyMapper.updateByPrimaryKey(record);
    }
}
