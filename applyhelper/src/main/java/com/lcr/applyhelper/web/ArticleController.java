package com.lcr.applyhelper.web;

import com.lcr.applyhelper.entity.Article;
import com.lcr.applyhelper.entity.User;
import com.lcr.applyhelper.service.ArticleService;
import com.lcr.applyhelper.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/findbyid",method = RequestMethod.POST)
    private Map<String,Object> findById(@RequestParam(value = "articleid") Integer articleid){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Article article=articleService.findById(articleid);
        modelMap.put("onearticle",article);
        return modelMap;
    }

    @RequestMapping(value = "/findnews",method = RequestMethod.GET)
    private Map<String,Object> findNews(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Article> list=articleService.findByType(1);
        modelMap.put("news",list);
        return modelMap;
    }

    @RequestMapping(value = "/hadread",method = RequestMethod.POST)
    private Map<String,Object> hadRead(@RequestParam(value = "articleId") Integer articleId){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Article article = new Article();
        article.setArticleID(articleId);
        article.setReadNum(article.getReadNum()+1);
        int effect=articleService.updateByPrimaryKeySelective(article);
        if(effect>0){
            modelMap.put("hadread","success");
        }else{
            modelMap.put("hadread","fail");
        }
        return modelMap;
    }
}
