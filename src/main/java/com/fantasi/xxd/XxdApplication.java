package com.fantasi.xxd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fantasi.xxd.dao")
public class XxdApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxdApplication.class, args);
    }

}
