package com.example.vblogservice.service;

import com.example.vblogservice.util.RedisUtils;
import io.jsonwebtoken.JwtException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class RedisService {

    @Resource
    RedisUtils redisUtils;
    @Resource
    WebTokenService tokenService;
    @Resource
    RedisTemplate<String, String> redisTemplate;

    private static ReentrantLock lock = new ReentrantLock();

    public void setTokenStore(String account) {
        String token = tokenService.createToken(account);
        lock.lock();
        redisUtils.getAndSet(account,token);
        redisTemplate.expire(account, 1860, TimeUnit.SECONDS);
        if (lock.isHeldByCurrentThread()) lock.unlock();
    }

    public String getToken(String account) {
        try{
            if (redisTemplate.getExpire(account) == -1) {
                return "";
            }
            String token = redisUtils.get(account);
            if(token != null && !tokenService.isExpiration(token)) {
                return token;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return "";
    }
}
