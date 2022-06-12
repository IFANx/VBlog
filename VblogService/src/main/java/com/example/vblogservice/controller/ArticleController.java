package com.example.vblogservice.controller;

import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.ArticleExample;
import com.example.vblogservice.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    final
    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("article/{id}")
    public Article getArticleById(@PathVariable int id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("article/counts")
    public long getArticleCounts() {
        ArticleExample example = new ArticleExample(); // no criteria, count all articles.
        return articleService.getArticleCountsByExample(example);
    }

    @GetMapping("articles")
    public List<Article> getAllArticles() {
        ArticleExample example = new ArticleExample();// non criteria, get all articles.
        return articleService.getArticleByExample(example);
    }

    @GetMapping("articles/paged/{startPage}/{pageSize}")
    public PageInfo<Article> getArticlesPaged(@PathVariable int startPage, @PathVariable int pageSize) {
        ArticleExample example = new ArticleExample();// non criteria, get all articles.
        return articleService.getArticlesByExamplePaged(example, startPage, pageSize);
    }

    @GetMapping("article/counts/title/{title}")
    public long getArticleCountsByTitle(@PathVariable String title) {
        // set example, count articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo(title);
        criteria.andTitleIsNotNull();

        return articleService.getArticleCountsByExample(example);
    }

    @GetMapping("articles/title/{title}")
    public List<Article> getArticleByTitle(@PathVariable String title) {
        // set example, search articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo(title);
        criteria.andTitleIsNotNull();

        return articleService.getArticleByExample(example);
    }

    @GetMapping("articles/title/paged/{title}/{startPage}/{pageSize}")
    public PageInfo<Article> getArticlesByTitlePaged(
            @PathVariable String title, @PathVariable int startPage, @PathVariable int pageSize) {
        // set example, page articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo(title);
        criteria.andTitleIsNotNull();

        return articleService.getArticlesByExamplePaged(example, startPage, pageSize);
    }

    @GetMapping("article/counts/tag/{tag}")
    public long getArticleCountsByTag(@PathVariable String tag) {
        // set example, count articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTagEqualTo(tag);
        criteria.andTagIsNotNull();

        return articleService.getArticleCountsByExample(example);
    }

    @GetMapping("articles/tag/{tag}")
    public List<Article> getArticleByTag(@PathVariable String tag) {
        // set example, search articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTagEqualTo(tag);
        criteria.andTagIsNotNull();

        return articleService.getArticleByExample(example);
    }

    @GetMapping("articles/tag/paged/{tag}/{startPage}/{pageSize}")
    public PageInfo<Article> getArticlesByTagPaged(
            @PathVariable String tag, @PathVariable int startPage, @PathVariable int pageSize) {
        // set example, page articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTagEqualTo(tag);
        criteria.andTagIsNotNull();

        return articleService.getArticlesByExamplePaged(example, startPage, pageSize);
    }

    @PostMapping("article")
    public int insertArticle(@RequestBody Article article) {
        articleService.insertArticle(article);
        return article.getId(); // return id of the record created(JSON).
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
