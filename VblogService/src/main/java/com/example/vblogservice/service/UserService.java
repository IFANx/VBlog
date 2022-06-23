package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.User;
import com.example.vblogservice.entity.domian.UserWithBLOBs;

public interface UserService {
    int register(String account, String password);

    User login(String account, String password);

    boolean judgeExist(String account);

    User user(String account);

    Integer MaxID();

    int delete(UserWithBLOBs userWithBLOBs);

    int update(UserWithBLOBs userWithBLOBs);

    User getSingleUser(String account);
}
