package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    UserService userservice;

    @Test
    void getSingleUser() {
        User user = userservice.getSingleUser("bob@test.com");
        System.out.println(user.getAccount());
    }
}