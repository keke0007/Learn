package com.rabbit.consumer;/**
 * @Author ke
 * @create 2019/8/27 16:25
 * @version 1.0.0
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 16:25
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }

}
