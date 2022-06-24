package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.User;
import com.example.vblogservice.entity.domian.UserExample;
import com.example.vblogservice.entity.domian.UserWithBLOBs;
import com.example.vblogservice.mapper.UserMapper;
import com.example.vblogservice.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;



@Service
public class UserServiceImpl implements UserService {
    final private UserMapper userMapper;
    MD5 md5 = new MD5();

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Integer MaxID() {
        Integer MaxID = userMapper.selectMaxID();
        return MaxID;
    }

    @Override
    public int delete(UserWithBLOBs userWithBLOBs) {
        return userMapper.deleteByPrimaryKey(userWithBLOBs.getId());
    }

    @Transactional
    @Override
    public int register(String account, String password){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(userExample);
        if(!users.isEmpty()) return 0x7fffff;
        UserWithBLOBs user = new UserWithBLOBs();
        user.setPassword(md5.getCiphertext(password));
        user.setAccount(account);
        user.setBirthday(new Date());
        user.setDescription("test");
        user.setEmail("test@email.com");
        user.setGender("male");
        user.setName("test");
        user.setPortrait(null);
        return userMapper.insert(user);
    }


    @Transactional
    @Override
    public User login(String account, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(userExample);
        if(!users.isEmpty()){
            User user = users.get(0);
            if(md5.verify(password,user.getPassword())) return user;
            return new User();
        }
        else{
            return new User();
        }
    }

    @Transactional
    @Override
    public int update(UserWithBLOBs userWithBLOBs){
        if(userWithBLOBs.getPassword()!=null)
            userWithBLOBs.setPassword(md5.getCiphertext(userWithBLOBs.getPassword()));
        return userMapper.updateByPrimaryKeySelective(userWithBLOBs);
    }

    @Transactional
    @Override
    public boolean judgeExist(String account) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    @Transactional
    @Override
    public User user(String account) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0);
    }


    public User getSingleUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }


}
