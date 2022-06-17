package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.User;
import com.example.vblogservice.entity.domian.UserExample;
import com.example.vblogservice.mapper.UserMapper;
import com.example.vblogservice.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer MaxID() {
        Integer MaxID = userMapper.selectMaxID();
        return MaxID;
    }

    @Override
    public boolean register(String account, String password) {
        User user = new User();
        user.setAccount(account);
        user.setBirthday(new Date());
        user.setDescription("test");
        user.setEmail("test@email.com");
        user.setGender("male");
        user.setName("test");
        MD5 md5=new MD5();
        user.setPassword(md5.getCiphertext(password));
        user.setId(userMapper.selectMaxID()+1);
        userMapper.insert(user);
        return true;
    }

    @Override
    public boolean login(String account, String password) {
        MD5 md5=new MD5();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null) {
            return false;
        } else if (md5.verify(password,users.get(0).getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean judgeExist(String account) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        if(userMapper.selectByExample(userExample)!=null)
        return false;
        return true;
    }

    public User getSingleUser(String account) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        return userMapper.selectByExample(userExample).get(0);
    }


}
