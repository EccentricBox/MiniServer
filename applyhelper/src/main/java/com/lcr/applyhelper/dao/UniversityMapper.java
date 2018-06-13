package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.University;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UniversityMapper {
    int deleteByPrimaryKey(Integer uniID);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer uniID);

    List<University> findAll();

    List<University> findByProvince(String province);

    List<University> findByRank(@Param("start")Integer start, @Param("stop")Integer stop);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);
}