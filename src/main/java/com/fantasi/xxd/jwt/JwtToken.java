package com.fantasi.xxd.jwt;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * JwtToken:实现shiro的AuthenticationToken接口的类JwtToken
 * @author xxd
 * @date 2020/3/2 10:20
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
