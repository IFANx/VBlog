package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.User;

public interface UserService {
    int register(String account, String password);

    User login(String account, String password);

    boolean judgeExist(String account);

    User user(String account);

    Integer MaxID();

    int delete(User user);

//    int update(User user);

    User getSingleUser(String account);
}
