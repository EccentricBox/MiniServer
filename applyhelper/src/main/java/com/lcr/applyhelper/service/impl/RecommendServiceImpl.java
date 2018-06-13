package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.RecommendMapper;
import com.lcr.applyhelper.entity.Recommend;
import com.lcr.applyhelper.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendMapper recommendDao;

    @Override
    public Recommend selectByPrimaryKey(Integer uniID) {
        return recommendDao.selectByPrimaryKey(uniID);
    }

    @Override
    public List<Recommend> findAll() {
        return recommendDao.findAll();
    }
}
