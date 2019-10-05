package com.myself.service.impl;

import com.myself.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getString() {
        return "hello world!";
    }

    @Override
    public String testRedis() {
        stringRedisTemplate.opsForValue().set("aaa","aaa");
        return stringRedisTemplate.opsForValue().get("aaa");
    }
}
