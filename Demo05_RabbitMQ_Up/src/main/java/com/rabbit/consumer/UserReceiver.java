package com.rabbit.consumer;/**
 * @Author ke
 * @create 2019/8/27 17:11
 * @version 1.0.0
 */

import com.rabbit.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 17:11
 */
@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {
    @RabbitHandler
    public void process(User user) {
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }
}
