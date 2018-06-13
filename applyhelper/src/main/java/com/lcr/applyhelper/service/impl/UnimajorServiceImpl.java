package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.UnimajorMapper;
import com.lcr.applyhelper.service.UnimajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnimajorServiceImpl implements UnimajorService {

    @Autowired
    private UnimajorMapper unimajorMapper;

    @Override
    public List<Integer> findUni(Integer majorID) {
        return unimajorMapper.findUni(majorID);
    }
}
