package com.myself.apigateway.service;

import com.myself.common.ResponseOb;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public ResponseOb helloService(){
        return restTemplate.getForEntity("http://springboot/study/getString",ResponseOb.class).getBody();
    }

    public ResponseOb helloFallback(){
        ResponseOb responseOb=new ResponseOb();
        responseOb.setCode(500);
        responseOb.setMessage("当前应用无法访问");
        return responseOb;
    }
}
