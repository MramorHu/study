package com.myself.service.impl;

import com.myself.service.StudyService;
import org.springframework.stereotype.Service;

@Service
public class StudyServiceImpl implements StudyService {
    @Override
    public String getString() {
        return "hello world!";
    }
}
