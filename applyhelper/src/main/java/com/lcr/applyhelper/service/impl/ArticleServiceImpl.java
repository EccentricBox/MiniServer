package com.lcr.applyhelper.service.impl;

import com.lcr.applyhelper.dao.ArticleMapper;
import com.lcr.applyhelper.entity.Article;
import com.lcr.applyhelper.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article findById(Integer articleID) {
        return articleMapper.selectByPrimaryKey(articleID);
    }

    @Override
    public List<Article> findByType(Integer type) {
        return articleMapper.findByType(type);
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Article record) {
        return articleMapper.updateByPrimaryKey(record);
    }
}
