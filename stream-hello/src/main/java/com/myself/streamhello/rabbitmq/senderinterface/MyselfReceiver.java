package com.myself.streamhello.rabbitmq.senderinterface;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyselfReceiver {

    String s1="test1";
    String s2="test2";
    String s3="test3";
    String s4="test4";
    String s5="test5";
    String s6="test6";

    @Input(s1)
    SubscribableChannel input1();
//    @Output(s1)
    MessageChannel output1();
    @Input(s2)
    SubscribableChannel input2();
    @Input(s3)
    SubscribableChannel input3();
    @Input(s4)
    SubscribableChannel input4();
    @Input(s5)
    SubscribableChannel input5();
    @Output(s6)
    MessageChannel output6();

}
