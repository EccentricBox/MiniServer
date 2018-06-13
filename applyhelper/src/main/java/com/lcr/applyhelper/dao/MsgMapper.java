package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.Msg;

import java.util.List;

public interface MsgMapper {
    int deleteByPrimaryKey(Integer msgID);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(Integer msgID);

    List<Msg> findAll(String fID);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);
}