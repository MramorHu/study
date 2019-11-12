package com.myself.springboot.service.impl;

import com.myself.springboot.service.StudyService;
import com.myself.springboot.dao.StudyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private StudyMapper studyMapper;

    @Override
    public String getString() {
        return "hello world!";
    }

    @Override
    public String testRedis() {
        stringRedisTemplate.opsForValue().set("aaa","aaa");
        return stringRedisTemplate.opsForValue().get("aaa");
    }

    @Override
    public List<Map> getList() {
        return studyMapper.listAll();
    }
}
