package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.JobMapper;
import com.lcr.applyhelper.entity.Job;
import com.lcr.applyhelper.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobDao;

    @Override
    public Job selectByPrimaryKey(Integer jobID) {
        return jobDao.selectByPrimaryKey(jobID);
    }

    @Override
    public List<Job> findAll(String city) {
        return jobDao.findAll(city);
    }
}
