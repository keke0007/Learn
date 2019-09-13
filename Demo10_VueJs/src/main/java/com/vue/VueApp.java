package com.vue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author：ke
 * @ Date： 2019/9/13 15:17
 * @ Version 1.0
 */
@SpringBootApplication
@MapperScan("com.vue.mapper")
public class VueApp {
    public static void main(String[] args) {
        SpringApplication.run(VueApp.class, args);
    }
}
