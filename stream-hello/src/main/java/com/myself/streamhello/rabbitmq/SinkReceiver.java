package com.myself.streamhello.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.myself.streamhello.rabbitmq.senderinterface.MyselfReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding({MyselfReceiver.class})
public class SinkReceiver {

    private static Logger logger= LoggerFactory.getLogger(SinkReceiver.class);

    @Autowired
    MyselfReceiver myselfReceiver;

    @StreamListener(MyselfReceiver.s1)
    public void receiver1(Object payload){
        logger.debug("SinkReceiver1-----------:"+payload.toString());
        myselfReceiver.output6().send(MessageBuilder.withPayload(new JSONObject(){{put("1","OK");}}.toString()).build());
    }

    @StreamListener(MyselfReceiver.s2)
    public void receiver2(Object payload){
        logger.debug("SinkReceiver2-----------:"+payload.toString());
    }

    @StreamListener(MyselfReceiver.s6)
    public void receiver6(Object payload){
        logger.debug("SinkReceiver6-----------:"+payload.toString());
    }
}
