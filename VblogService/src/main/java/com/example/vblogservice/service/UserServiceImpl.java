package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.User;
import com.example.vblogservice.entity.domian.UserExample;
import com.example.vblogservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(String account, String password) {
        return false;
    }

    @Override
    public boolean login(String account, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null) {
            return false;
        } else if (users.get(0).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


}
