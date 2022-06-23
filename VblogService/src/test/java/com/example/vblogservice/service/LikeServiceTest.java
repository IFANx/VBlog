package com.example.vblogservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LikeServiceTest {

    @Autowired
    LikeService likeService;

    @Test
    void countLikeByUserId() {
        System.out.println(likeService.countLikeByUserId(1));
    }

    @Test
    void getLikeListByUserId() {
        System.out.println(likeService.getLikeListByUserId(1));
    }

    @Test
    void getUserListByArticleId() {
        System.out.println(likeService.getUserListByArticleId(1));
    }

    @Test
    void addLikeRelation() {
    }

    @Test
    void deleteLikeRelation() {
    }
}
