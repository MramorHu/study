package com.myself.testconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TestConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestConfigClientApplication.class, args);
    }

}
