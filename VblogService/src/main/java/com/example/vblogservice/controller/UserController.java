package com.example.vblogservice.controller;

import com.example.vblogservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpSession session, ModelMap modelMap, String account,
                        String password) {
        boolean flag = userService.login(account, password);
        if (flag==true) {
            modelMap.addAttribute("message", "登录成功");
//            session.setAttribute("UserPhoneNumber",user_phone_number);
            return "login success";
        } else {
            modelMap.addAttribute("message", "登录失败");
            return "login fail";
        }
    }
}
