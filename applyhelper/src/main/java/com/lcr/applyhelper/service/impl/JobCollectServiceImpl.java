package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.JobCollectMapper;
import com.lcr.applyhelper.entity.JobCollectKey;
import com.lcr.applyhelper.service.JobCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCollectServiceImpl implements JobCollectService {
    @Autowired
    private JobCollectMapper jobCollectDao;
    @Override
    public int insert(JobCollectKey record) {
        return jobCollectDao.insert(record);
    }

    @Override
    public List<JobCollectKey> findByUserId(String userID) {
        return jobCollectDao.findByUserId(userID);
    }
}
