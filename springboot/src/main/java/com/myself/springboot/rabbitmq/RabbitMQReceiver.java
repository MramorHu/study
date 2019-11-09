package com.myself.springboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "hello")
public class RabbitMQReceiver {

    @RabbitHandler
    public void precess(String message){
        System.out.println("message------:"+message);
    }

}
