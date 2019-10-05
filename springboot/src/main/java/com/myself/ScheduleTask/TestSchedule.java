package com.myself.ScheduleTask;

import com.myself.service.NormalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSchedule {

    private static Logger logger= LoggerFactory.getLogger(TestSchedule.class);

//    @Scheduled(fixedRate = 10000)
    private void test() throws Exception{
        Long time1=System.currentTimeMillis();
        new NormalService().task1();
        new NormalService().task2();
        new NormalService().task3();
        logger.debug(String.valueOf(System.currentTimeMillis()-time1));
    }
}
