package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.User;

public interface UserService {
    boolean register(String account, String password);

    boolean login(String account, String password);

    boolean judgeExist(String account);

    Integer MaxID();

    User getSingleUser(String account);
}
