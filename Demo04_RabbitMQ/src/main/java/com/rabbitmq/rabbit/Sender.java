package com.rabbitmq.rabbit;/**
 * @Author ke
 * @create 2019/8/27 14:42
 * @version 1.0.0
 */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 14:42
 */
@Component
public class Sender {
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

   /* @Autowired
   private AmqpTemplate amqpTemplate;*/

    public void send() {
        String context = "Hello------------" + LocalDate.now();
        System.out.println("Sender:" + context);
        this.rabbitMessagingTemplate.convertAndSend("hello",context);
    }
}
