package com.myself.apigateway.controller;

import com.myself.apigateway.service.SpringbootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootController {

    @Autowired
    SpringbootService springbootService;

    @RequestMapping(value = "/getString",method = RequestMethod.GET)
    public String getString(){
        return springbootService.getString();
    }
}
