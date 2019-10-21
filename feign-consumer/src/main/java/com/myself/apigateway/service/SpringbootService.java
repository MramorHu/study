package com.myself.apigateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient("springboot")
public interface SpringbootService {

    @RequestMapping("/study/getString")
    String getString();
}
