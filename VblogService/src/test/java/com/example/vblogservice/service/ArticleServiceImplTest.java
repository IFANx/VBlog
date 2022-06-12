package com.example.vblogservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    ArticleService articleService;

    @Test
    void getArticleById() {
        System.out.println(articleService.getArticleById(1));
    }

    @Test
    void getArticleByTitle() {
        System.out.println(articleService.getArticleByTitle("test article"));
    }
}
