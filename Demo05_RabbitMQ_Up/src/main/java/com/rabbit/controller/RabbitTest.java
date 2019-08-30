package com.rabbit.controller;/**
 * @Author ke
 * @create 2019/8/27 16:15
 * @version 1.0.0
 */

import com.rabbit.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 16:15
 */
@RestController
@RequestMapping(value = "/rabbit")
public class RabbitTest {
    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;
    @Autowired
    private UserSender userSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private CallBackSender callBackSender;

    @GetMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

    /**
     * 单生产者-多消费者
     */
    @GetMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("hellomsg:" + i);
        }
    }

    /**
     * 多生产者-多消费者
     */
    @PostMapping("/manyToMany")
    public void manyToMany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("hellomsg:" + i);
            helloSender2.send("hellomsg:" + i);
        }
    }

    /**
     * 实体类传输测试
     */
    @GetMapping("/userTest")
    public void userTest() {
        userSender.send();
    }
    /**
     * topic exchange类型rabbitmq测试
     */
    @GetMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }
    /**
     * fanout exchange类型rabbitmq测试
     */
    @GetMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }

    /**
     * 测试带返回值ack的topic消息队列
     */
    @GetMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }
}
