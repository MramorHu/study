package com.myself.testconfigclient.service.impl;

import com.myself.testconfigclient.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;

    @Override
    public String getString() {
        return environment.getProperty("from");
    }

    @Override
    public String testRedis() {
        stringRedisTemplate.opsForValue().set("aaa","aaa");
        return stringRedisTemplate.opsForValue().get("aaa");
    }

}
