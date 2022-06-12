package com.example.vblogservice.controller;

import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {

    final
    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("article/id/{id}")
    public Article getArticleById(@PathVariable int id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("article/title/{title}")
    public List<Article> getArticleByTitle(@PathVariable String title) {
        return articleService.getArticleByTitle(title);
    }

    @PostMapping("article")
    public Map<String, Integer> insertArticle(@RequestBody Article article) {
        articleService.insertArticle(article);
        return Map.of("id", article.getId()); // return id of the record created(JSON).
    }

    @DeleteMapping("article/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleService.deleteArticleById(id);
    }

    @PutMapping("article")
    public void updateArticle(@RequestBody Article article) {
        articleService.updateById(article);
    }
}
