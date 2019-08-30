package com.rabbit.config;/**
 * @Author ke
 * @create 2019/8/30 10:41
 * @version 1.0.0
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/30 10:41
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
