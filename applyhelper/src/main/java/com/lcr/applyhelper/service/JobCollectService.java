package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.JobCollectKey;

import java.util.List;

public interface JobCollectService {
    int insert(JobCollectKey record);

    List<JobCollectKey> findByUserId(String userID);
}
