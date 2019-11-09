package com.myself.springboot.rabbitmq.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyselfSender {

    String s1="test1";
    String s2="test2";
    String s3="test3";
    String s4="test4";
    String s5="test5";
    String s6="test6";

    @Output(s1)
    MessageChannel output1();
    @Output(s2)
    MessageChannel output2();
    @Output(s3)
    MessageChannel output3();
    @Output(s4)
    MessageChannel output4();
    @Output(s5)
    MessageChannel output5();
    @Output(s6)
    MessageChannel output6();
}
