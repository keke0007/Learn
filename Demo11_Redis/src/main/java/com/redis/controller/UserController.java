package com.redis.controller;

import com.redis.entity.User;
import com.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author aswl.com
 * @version 1.0.0
 * @create 2019/9/24 15:16
 */
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    @GetMapping(value = "redis")
    public void testRedisSerializable() {
        List<User> list = userService.list();
        redisTemplate.opsForValue().set("user:list",list,100, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("user:listAll",list,100, TimeUnit.MINUTES);
    }
}
