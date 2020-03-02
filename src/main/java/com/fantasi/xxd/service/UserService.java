package com.fantasi.xxd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasi.xxd.entity.LoginUser;
import com.fantasi.xxd.entity.User;

/**
 * 客户端用户表 服务类
 * @author xxd
 * @date 2020/3/2 11:00
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param user
     * @return
     */
    LoginUser login(User user);

    /**
     * 通过用户(电话号码)查询用户
     * 原则不允许重复注册,只有测试阶段才会出现,上线时不允许的
     * @param userPhone
     * @return
     */
    User findByUserName(String userPhone);
}
