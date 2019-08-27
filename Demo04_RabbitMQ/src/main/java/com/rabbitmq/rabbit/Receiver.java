package com.rabbitmq.rabbit;/**
 * @Author ke
 * @create 2019/8/27 14:48
 * @version 1.0.0
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 14:48
 */
@RabbitListener(queues = "hello")
@Component
public class Receiver {

    @RabbitHandler
    public void receive(String hello) {
        System.out.println("receiver: " + hello);
    }
}
