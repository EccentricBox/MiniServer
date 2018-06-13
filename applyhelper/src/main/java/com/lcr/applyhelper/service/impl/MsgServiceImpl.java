package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.MsgMapper;
import com.lcr.applyhelper.entity.Msg;
import com.lcr.applyhelper.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgMapper msgMapper;

    @Override
    public int deleteByPrimaryKey(Integer msgID) {
        return msgMapper.deleteByPrimaryKey(msgID);
    }

    @Override
    public int insert(Msg record) {
        return msgMapper.insert(record);
    }

    @Override
    public int insertSelective(Msg record) {
        return msgMapper.insertSelective(record);
    }

    @Override
    public Msg selectByPrimaryKey(Integer msgID) {
        return msgMapper.selectByPrimaryKey(msgID);
    }

    @Override
    public List<Msg> findAll(String fID) {
        return msgMapper.findAll(fID);
    }

    @Override
    public int updateByPrimaryKeySelective(Msg record) {
        return msgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Msg record) {
        return msgMapper.updateByPrimaryKey(record);
    }
}
