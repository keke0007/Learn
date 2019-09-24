package com.redis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author aswl.com
 * @version 1.0.0
 * @create 2019/9/24 14:53
 */
@Component
public class CmdInit implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Redis序列化>>>>>>>>>");
        System.out.println("CommanderLineRunner学习链接>>>>https://blog.csdn.net/catoop/article/details/50501710");
        System.out.println("RedisTemplate用法详解>>>>>>https://blog.csdn.net/weixin_40461281/article/details/82011670");
        System.out.println("Redis API 必杀解读:引入RedisTemplate>>>https://blog.csdn.net/wd2014610/article/details/77371601");
    }
}
