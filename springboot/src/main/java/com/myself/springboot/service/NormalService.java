package com.myself.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NormalService {

    private static Logger logger= LoggerFactory.getLogger(NormalService.class);

    @Async
    public void task1() throws InterruptedException {
        Thread.sleep(3000);
        logger.debug("task1执行了");
    }

    @Async
    public void task2() throws InterruptedException {
        Thread.sleep(3000);
        logger.debug("task2执行了");
    }

    @Async
    public void task3() throws InterruptedException {
        Thread.sleep(3000);
        logger.debug("task3执行了");
    }
}
