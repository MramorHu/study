package com.myself.apigateway.controller;

import com.myself.common.ResponseOb;
import com.myself.apigateway.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/springboot")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HelloService helloService;

    @GetMapping(value = "/study/getString")
    public String getString(){
        return restTemplate.getForEntity("http://springboot/study/getString",String.class).getBody();
    }

    @GetMapping(value = "/study/getString2")
    public ResponseOb getString2(){
        return helloService.helloService();
    }

    @GetMapping(value = "/study/getString1")
    public String getString1(String name){
//        return restTemplate.getForEntity("http://springboot/study/getString1?name={1}",String.class,"woshishui","1234124").getBody();
        Map map=new HashMap();
        map.put("name","dada");
        return restTemplate.getForObject("http://springboot/study/getString1",String.class,map);
    }

}
