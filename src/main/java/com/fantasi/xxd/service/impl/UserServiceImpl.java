package com.fantasi.xxd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fantasi.xxd.dao.UserDao;
import com.fantasi.xxd.entity.LoginUser;
import com.fantasi.xxd.entity.User;
import com.fantasi.xxd.exception.MyException;
import com.fantasi.xxd.service.UserService;
import com.fantasi.xxd.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxd
 * @date 2020/3/2 11:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public LoginUser login(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_phone", user.getUserPhone());
        map.put("user_password", user.getUserPassword());
        //throw  new MyException("我的模拟业务代码的异常!");
        User user1 = null;
        try {
            user1 = userDao.selectByMap(map).get(0);
        } catch (Exception e) {
            throw new MyException("该用户名或者密码错误,请检查后再登录!");
        }
        LoginUser loginUser=new LoginUser();
        loginUser.setUser(user1);
        //根据电话号码和密码加密生成token
        String token = JwtUtil.sign(user1.getUserPhone(), user1.getUserPassword());
        loginUser.setToken(token);
        return loginUser;
    }

    /**
     * 通过用户(电话号码)查询用户
     * 原则不允许重复注册,只有测试阶段才会出现,上线时不允许的
     *
     * @param userPhone
     * @return
     */
    @Override
    public User findByUserName(String userPhone) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_phone", userPhone);
        return userDao.selectByMap(map).get(0);
    }
}
