package com.fantasi.xxd.controller;

import com.fantasi.xxd.entity.LoginUser;
import com.fantasi.xxd.entity.User;
import com.fantasi.xxd.service.UserService;
import com.fantasi.xxd.util.ResponseDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端用户表 前端控制器
 * @author xxd
 * @date 2020/3/2 11:20
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody User user) {
        log.warn("执行登录操作!");
        //先执行登录验证的过滤操作,才会执行后面这些乱七八糟的异常
        //throw new MyException("测试自定义异常!");
        LoginUser loginUser = userService.login(user);
        if (loginUser != null) {
            return loginUser;
        }
        return ResponseDataUtil.failure("登录失败!");
    }

    @RequestMapping("/test")
    public Object test() {
        log.warn("测试拦截的方法能进来不?");
        return "测试拦截的方法能进来不?";
    }

    @RequestMapping("/swagger/test")
    public Object swagger(@RequestBody User user) {
        log.warn("测试放行的方法能进来不?");
        return "测试放行的方法能进来不?";
    }
}
