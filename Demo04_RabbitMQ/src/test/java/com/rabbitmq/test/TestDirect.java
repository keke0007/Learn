package com.rabbitmq.test;/**
 * @Author ke
 * @create 2019/8/27 14:21
 * @version 1.0.0
 */

import com.rabbitmq.App;
import com.rabbitmq.rabbit.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 14:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class TestDirect {
    @Autowired
    private Sender sender;

    @Test
    public void testDirect() {
        sender.send();
    }
}
