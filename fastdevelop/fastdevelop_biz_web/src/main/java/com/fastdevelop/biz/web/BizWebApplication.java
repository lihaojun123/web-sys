package com.fastdevelop.biz.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.fastdevelop.db.mapper")
@ComponentScan("com.fastdevelop")
public class BizWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BizWebApplication.class,args);
    }
}
