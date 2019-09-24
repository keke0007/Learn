package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author aswl.com
 * @version 1.0.0
 * @create 2019/9/24 14:51
 */
@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class}*/)
public class RedisApp {
    public static void main(String[] args) {
        SpringApplication.run(RedisApp.class);
    }
}
