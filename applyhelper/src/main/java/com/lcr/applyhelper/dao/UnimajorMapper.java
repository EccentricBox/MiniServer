package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.UnimajorKey;

import java.util.List;

public interface UnimajorMapper {

    List<Integer> findUni(Integer majorID);
}