package com.cris.superplatform.consumer.my.experiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ConsumerMyExperimentApplication
 *
 * @author cris.zhu
 * @date 2019/12/9
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class ConsumerMyExperimentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMyExperimentApplication.class, args);
    }

}

