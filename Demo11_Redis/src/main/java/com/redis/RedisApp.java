package com.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author aswl.com
 * @version 1.0.0
 * @create 2019/9/24 14:51
 */
@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class}*/)
@MapperScan("com.redis.mapper")
public class RedisApp {
    public static void main(String[] args) {
        SpringApplication.run(RedisApp.class);
    }
}
