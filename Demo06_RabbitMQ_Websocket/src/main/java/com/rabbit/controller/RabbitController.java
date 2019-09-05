package com.rabbit.controller;

import com.rabbit.direct.DirectConsumer;
import com.rabbit.direct.DirectProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/9/5 10:45
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {
    @Autowired
    private DirectProducer directProducer;
    @RequestMapping("/hello")
    public void testDirect() {
        directProducer.send("测试helloQueue");
    }
}
