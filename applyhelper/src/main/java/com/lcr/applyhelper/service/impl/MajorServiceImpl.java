package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.MajorMapper;
import com.lcr.applyhelper.entity.Major;
import com.lcr.applyhelper.entity.MajorKey;
import com.lcr.applyhelper.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;
    @Override
    public int deleteByPrimaryKey(MajorKey key) {
        return majorMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(Major record) {
        return majorMapper.insert(record);
    }

    @Override
    public int insertSelective(Major record) {
        return majorMapper.insertSelective(record);
    }

    @Override
    public Major selectByPrimaryKey(MajorKey key) {
        return majorMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<Major> selectByUniID(Integer uniID) {
        return majorMapper.selectByUniID(uniID);
    }

    @Override
    public int updateByPrimaryKeySelective(Major record) {
        return majorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Major record) {
        return majorMapper.updateByPrimaryKey(record);
    }
}
