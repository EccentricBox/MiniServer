package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.RemajorMapper;
import com.lcr.applyhelper.entity.Remajor;
import com.lcr.applyhelper.service.RemajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemajorServiceImpl implements RemajorService {

    @Autowired
    private RemajorMapper mapper;

    @Override
    public List<Remajor> findAll() {
        return mapper.findAll();
    }
}
