package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.Major;
import com.lcr.applyhelper.entity.MajorKey;

import java.util.List;

public interface MajorService {
    int deleteByPrimaryKey(MajorKey key);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(MajorKey key);

    List<Major> selectByUniID(Integer uniID);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}
