package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.University;

import java.util.List;

public interface UniversityService {

    University selectByID(Integer uniID);

    List<University> findAll();

    List<University> findByProvince(String province);

    List<University> findByRank(Integer start,Integer stop);
}
