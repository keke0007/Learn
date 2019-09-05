package com.rabbit.direct;

import com.rabbit.websocket.MyWebSocket;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/9/5 10:42
 */
@Component
@RabbitListener(queues = "helloQueue")
public class DirectConsumer {
    @RabbitHandler
    public void handler(String msg) throws InterruptedException {
        System.out.println("收到消息>>>>>>>>>>" + msg);
        Thread.sleep(500);
        //调用websocket向页面推送消息
        for (MyWebSocket webSocket : MyWebSocket.webSocketSet) {
            try {
                webSocket.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
