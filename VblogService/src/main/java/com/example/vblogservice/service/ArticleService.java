package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.Article;

import java.util.List;

public interface ArticleService {
    Article getArticleById(int id);

    List<Article> getArticleByTitle(String title);

    int insertArticle(Article article);

    int deleteArticleById(int id);

    int updateById(Article article);
}
