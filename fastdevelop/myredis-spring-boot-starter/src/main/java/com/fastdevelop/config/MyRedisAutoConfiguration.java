package com.fastdevelop.config;

import com.fastdevelop.util.MyRedisUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyRedisAutoConfiguration implements EnvironmentAware {


    private Environment environment;

    @Bean
    @ConditionalOnProperty(name = "MyRedisUtil.enabld",havingValue = "true")
    public MyRedisUtil myRedisUtil() {
        String host = this.environment.getProperty("MyRedisUtil.host");
        String passwd = this.environment.getProperty("MyRedisUtil.passwd");
        String port = this.environment.getProperty("MyRedisUtil.port");
        MyRedisUtil myRedisUtil = new MyRedisUtil(host,passwd,port);
        return myRedisUtil;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
