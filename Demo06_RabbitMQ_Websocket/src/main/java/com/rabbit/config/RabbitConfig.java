package com.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/9/5 9:52
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue", true);
    }

    @Bean
    public Queue userQueue() {
        return new Queue("userQueue", true);
    }
}
