package com.rabbitmq.rabbit;/**
 * @Author ke
 * @create 2019/8/27 14:38
 * @version 1.0.0
 */

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 14:38
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
