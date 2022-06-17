package com.example.vblogservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisServiceTest {
    @Resource
    RedisService redisService;

    @Test
    void setTokenStore() {
        redisService.setTokenStore("bob@test.com");
    }

    @Test
    void getToken() {
        String token = redisService.getToken("bob@test.com");
        System.out.println(token);
    }
}