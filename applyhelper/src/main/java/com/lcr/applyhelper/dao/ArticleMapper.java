package com.lcr.applyhelper.dao;

import com.lcr.applyhelper.entity.Article;

import java.util.List;

public interface ArticleMapper {
    Article selectByPrimaryKey(Integer articleID);

    List<Article> findByType(Integer type);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}