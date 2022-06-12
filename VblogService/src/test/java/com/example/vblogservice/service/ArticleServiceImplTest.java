package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.ArticleExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    ArticleService articleService;

    @Test
    void testGetArticleById() {
        System.out.println(articleService.getArticleById(1));
    }

    @Test
    void getArticleCountsByExample() {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo("test article");

        System.out.println(articleService.getArticleCountsByExample(example));
    }

    @Test
    void getArticleByExample() {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo("test article");

        System.out.println(articleService.getArticleByExample(example));
    }

    @Test
    void getArticlesByExamplePaged() {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo("test article");

        System.out.println(articleService.getArticlesByExamplePaged(example, 1, 5));
    }

    @Test
    void insertArticle() {
        Article article = new Article();
        article.setId(null);
        article.setUserId(1);
        article.setContent("unit test add");
        article.setCommentCount(0);
        article.setLikeCount(0);
        article.setReadCount(0);
        article.setTitle("test");
        article.setTag("test");
        article.setPublishTime(null);
        article.setSubscribeCount(0);

        System.out.println(articleService.insertArticle(article));
    }

    @Test
    void deleteArticleById() {
        System.out.println(articleService.deleteArticleById(13));
    }

    @Test
    void updateById() {
        Article article = new Article();
        article.setId(13);
        article.setTag("test");

        System.out.println(articleService.updateById(article));
    }
}
