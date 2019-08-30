package com.rabbit.config;/**
 * @Author ke
 * @create 2019/8/30 10:43
 * @version 1.0.0
 */

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/30 10:43
 */
@Configuration
public class RabbitTopic {

        final static String message = "closedPlace";
        final static String messages = "topic.messages";

        @Value("${spring.rabbitmq.host}")
        private String addresses;

        @Value("${spring.rabbitmq.port}")
        private String port;

        @Value("${spring.rabbitmq.username}")
        private String username;

        @Value("${spring.rabbitmq.password}")
        private String password;

        @Value("${spring.rabbitmq.virtual-host}")
        private String virtualHost;

        @Value("${spring.rabbitmq.publisher-confirms}")
        private boolean publisherConfirms;
        @Bean
        public ConnectionFactory connectionFactory() {

                CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
                connectionFactory.setAddresses(addresses+":"+port);
                connectionFactory.setUsername(username);
                connectionFactory.setPassword(password);
                connectionFactory.setVirtualHost(virtualHost);
                /** 如果要进行消息回调，则这里必须要设置为true */
                connectionFactory.setPublisherConfirms(publisherConfirms);
                return connectionFactory;
        }
        //创建队列
        @Bean
        public Queue queueMessage() {
            return new Queue(RabbitTopic.message);
        }

        //创建队列
        @Bean
        public Queue queueMessages() {
            return new Queue(RabbitTopic.messages);
        }

        //创建交换器
        @Bean
        TopicExchange exchange() {
            return new TopicExchange("topicExchange");
        }

        //对列绑定并关联到ROUTINGKEY
        @Bean
        Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
            return BindingBuilder.bind(queueMessage).to(exchange).with(RabbitTopic.message);
        }

        //对列绑定并关联到ROUTINGKEY
        @Bean
        Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
            return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
        }

}
