package com.example.vblogservice.filter;

import com.example.vblogservice.service.RedisService;
import com.example.vblogservice.service.WebTokenService;
import com.example.vblogservice.util.ResultUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class VerifyInterceptor implements HandlerInterceptor{

    @Resource
    WebTokenService webTokenService;
    @Resource
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        String token = request.getHeader("BEARER");

        if(token == null || token.equals("")) {

            response.getWriter().write(ResultUtils.error("4001","未登录").toString());
            return false;
        }

        String account = request.getHeader("account");
        if (!token.equals(redisService.getToken(account))) {
            response.getWriter().write(ResultUtils.error("4003","token与用户不一致").toString());
            return false;
        }

        Claims claims = webTokenService.parseJwt(token);


        if(redisService.getToken(account) != null) {
            if(webTokenService.isExpiration(token)) {
                redisService.setTokenStore(account);
                response.setHeader("BEARER", redisService.getToken(account));
            }
            return true;
        }


        response.getWriter().write(ResultUtils.error("4002","token过期").toString());

        return false;
    }
}
