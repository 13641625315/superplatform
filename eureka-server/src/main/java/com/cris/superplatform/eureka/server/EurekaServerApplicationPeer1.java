package com.cris.superplatform.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplicationPeer1 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplicationPeer1.class, args);
    }
}
