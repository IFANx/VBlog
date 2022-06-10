package com.example.vblogservice.service;

public interface UserService {
    boolean register(String account, String password);

    boolean login(String account, String password);
}
