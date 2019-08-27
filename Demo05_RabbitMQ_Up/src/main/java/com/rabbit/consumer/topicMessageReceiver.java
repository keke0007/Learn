package com.rabbit.consumer;/**
 * @Author ke
 * @create 2019/8/27 17:19
 * @version 1.0.0
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 17:19
 */
@Component
@RabbitListener(queues = "topic.message")
public class topicMessageReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }
}
