package com.myself.controller;

import com.myself.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyController {

    @Autowired
    StudyService studyService;

    @RequestMapping("/getString")
    public String getString(){
        return studyService.getString();
    }

}
