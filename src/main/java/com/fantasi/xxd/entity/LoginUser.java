package com.fantasi.xxd.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * LoginUser:登录注册LoginUser传参实体(带验证码)
 * @author xxd
 * @date 2020/3/2 11:01
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class LoginUser {

    /**
     * 验证码
     */
    private String phoneCode;
    /**
     * 用户
     */
    private User user;

    /**
     * 用户token验证(header的键名)
     */
    private String token;
}
