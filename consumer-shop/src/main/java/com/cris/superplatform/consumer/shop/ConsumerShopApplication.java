package com.cris.superplatform.consumer.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ConsumerShopApplication
 *
 * @author cris.zhu
 * @date 2019/11/18
 */

@SpringBootApplication
@EnableFeignClients
public class ConsumerShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerShopApplication.class, args);
    }
}
