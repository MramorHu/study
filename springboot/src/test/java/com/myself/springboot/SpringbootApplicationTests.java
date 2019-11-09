package com.myself.springboot;

import com.alibaba.fastjson.JSONObject;
import com.myself.springboot.rabbitmq.RabbitMQSender;
import com.myself.springboot.rabbitmq.stream.MyselfSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests {

    @Autowired
    private RabbitMQSender rabbitMQSender;
    @Autowired
    private MyselfSender myselfSender;

    @Test
    public void contextLoads() {
        rabbitMQSender.send("hello","121222");
    }

    @Test
    public void testStream(){
        myselfSender.output1().send(MessageBuilder.withPayload(new JSONObject(){{put("1",1);}}.toString()).build());
//        myselfSender.output2().send(MessageBuilder.withPayload(new JSONObject(){{put("1",1);}}.toString()).build());
    }

}
