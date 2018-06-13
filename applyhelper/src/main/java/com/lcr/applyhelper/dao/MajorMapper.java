package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.Major;
import com.lcr.applyhelper.entity.MajorKey;

import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(MajorKey key);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(MajorKey key);

    List<Major> selectByUniID(Integer uniID);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}