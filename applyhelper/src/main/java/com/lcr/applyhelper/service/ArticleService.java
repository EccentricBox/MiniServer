package com.lcr.applyhelper.service;

import com.lcr.applyhelper.entity.Article;

import java.util.List;

public interface ArticleService {
    Article findById(Integer articleID);

    List<Article> findByType(Integer type);

    int updateByPrimaryKeySelective(Article record);

    int updateById(Article record);
}
