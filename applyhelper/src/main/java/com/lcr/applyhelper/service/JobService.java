package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.Job;

import java.util.List;

public interface JobService {
    Job selectByPrimaryKey(Integer jobID);

    List<Job> findAll(String city);
}
