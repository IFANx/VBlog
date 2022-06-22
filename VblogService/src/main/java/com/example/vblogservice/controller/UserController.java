package com.example.vblogservice.controller;

import com.example.vblogservice.entity.Result;
import com.example.vblogservice.entity.domian.User;
import com.example.vblogservice.service.RedisService;
import com.example.vblogservice.service.UserServiceImpl;
import com.example.vblogservice.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    RedisService redisService;

    /**
     * @param param 账户密码k-v
     * @return 操作结果
     */
    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public Result register(@RequestBody Map<String, Object> param){
        String account = (String) param.get("account");
        String password = (String) param.get("password");
        int res = userService.register(account, password);
        if(res == 0x7fffff)return ResultUtils.error("1200","账户已被注册");
        else if(res != 0)return ResultUtils.success();
        else return ResultUtils.error("1100","注册失败");
    }



    /**
     * @param param 账户密码k-v
     * @return 操作结果
     */
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Result login(@RequestBody Map<String, Object> param) {
        String account = (String) param.get("account");
        String password = (String) param.get("password");

        if(redisService.getToken(account) != null) {
            return ResultUtils.error("1001", "账号已登录");
        }
        User user = userService.login(account, password);
        if (user.getAccount() == null) return ResultUtils.error("1000", "账号或密码错误");
        redisService.setTokenStore(account);
        String token = redisService.getToken(account);
        return ResultUtils.success(token, user);
    }


    /**
     * @param user  user实体
     * @return 操作结果
     */
    @PutMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Result update(User user){
        int result = userService.update(user);
        if(result==0) return ResultUtils.error("1300","更改信息失败");
        return ResultUtils.success();
    }

    /**
     * @param user  user实体
     * @return 操作结果
     */
    @DeleteMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Result delete(User user){
        int result = userService.delete(user);
        if(result==0) return ResultUtils.error("1300","删除信息失败");
        return ResultUtils.success();
    }
}
