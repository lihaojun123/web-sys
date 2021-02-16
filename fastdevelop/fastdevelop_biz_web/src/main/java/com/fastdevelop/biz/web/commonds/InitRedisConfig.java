package com.fastdevelop.biz.web.commonds;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
@Slf4j
public class InitRedisConfig implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        log.info("============>初始化redis数据 开始");




        log.info("============>初始化redis数据 结束");
    }


}
