package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.Msg;

import javax.validation.constraints.Null;
import java.util.List;

public interface MsgService {

    int deleteByPrimaryKey(Integer msgID);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(Integer msgID);

    List<Msg> findAll(String fID);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);


}
