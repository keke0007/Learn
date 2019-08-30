package com.rabbit.producer;/**
 * @Author ke
 * @create 2019/8/27 17:10
 * @version 1.0.0
 */

import com.rabbit.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 17:10
 */
@Component
public class UserSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        User user=new User();
        user.setName("hzb");
        user.setPass("123456789");
        user.setAge(18);
        user.setSex(true);
        System.out.println("user send : " + user.getName()+"/"+user.getPass());
        this.rabbitTemplate.convertAndSend("userQueue", user);
    }
}
