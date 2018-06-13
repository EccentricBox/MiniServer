package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.UniversityMapper;
import com.lcr.applyhelper.entity.University;
import com.lcr.applyhelper.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityMapper universitydao;
    @Override
    public University selectByID(Integer uniID) {
        return universitydao.selectByPrimaryKey(uniID);
    }

    @Override
    public List<University> findAll() {
        return universitydao.findAll();
    }

    @Override
    public List<University> findByProvince(String province) {
        return universitydao.findByProvince(province);
    }

    @Override
    public List<University> findByRank(Integer start, Integer stop) {
        return universitydao.findByRank(start,stop);
    }
}
