package com.myself.testconfigclient;

import com.myself.springboot.SpringbootApplication;
import com.myself.springboot.rabbitmq.RabbitMQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Test
    public void contextLoads() {
        rabbitMQSender.send("hello","121222");

    }

}
