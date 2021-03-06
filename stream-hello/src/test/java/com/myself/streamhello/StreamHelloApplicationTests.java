package com.myself.streamhello;

import com.alibaba.fastjson.JSONObject;
import com.myself.streamhello.rabbitmq.senderinterface.MyselfReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StreamHelloApplication.class)
public class StreamHelloApplicationTests {

    @Autowired
    private MyselfReceiver sinkSender;

//    @Autowired
//    private MessageChannel output;

    @Test
    public void contextLoads() {
        sinkSender.input1().send(MessageBuilder.withPayload(new JSONObject(){{put("1",1);}}.toString()).build());
    }

}
