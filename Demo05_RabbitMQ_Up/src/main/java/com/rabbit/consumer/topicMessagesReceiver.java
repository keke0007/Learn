package com.rabbit.consumer;/**
 * @Author ke
 * @create 2019/8/27 17:22
 * @version 1.0.0
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 17:22
 */
@Component
@RabbitListener(queues = "topic.messages")
public class topicMessagesReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessagesReceiver  : " +msg);
    }
}
