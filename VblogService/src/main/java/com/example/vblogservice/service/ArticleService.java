package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.ArticleExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {
    Article getArticleById(int id);

    long getArticleCountsByExample(ArticleExample example);

    List<Article> getArticleByExample(ArticleExample example);

    PageInfo<Article> getArticlesByExamplePaged(ArticleExample example, int startPage, int pageSize);

    int insertArticle(Article article);

    int deleteArticleById(int id);

    int updateById(Article article);
}
