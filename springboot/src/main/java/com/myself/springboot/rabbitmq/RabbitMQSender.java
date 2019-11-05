package com.myself.springboot.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String topic,String message){
        amqpTemplate.convertAndSend(topic,message);
    }

}
