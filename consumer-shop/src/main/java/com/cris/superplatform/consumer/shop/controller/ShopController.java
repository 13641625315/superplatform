package com.cris.superplatform.consumer.shop.controller;

import com.cris.superplatform.consumer.shop.feign.client.UserFeignClient;
import com.cris.superplatform.consumer.shop.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * ShopController
 *
 * @author cris.zhu
 * @date 2019/11/18
 */
@Import(FeignClientsConfiguration.class)
@RestController
public class ShopController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "findUserByIdFallback")
    @GetMapping("/user/{id}")
    public User findByIdUser(@PathVariable Long id) {
        return this.userFeignClient.findUserById(id);
    }

    public User findUserByIdFallback(Long id, Throwable throwable) {
        LOGGER.error("enter fall back,ecception:", throwable);
        User user = new User();
        user.setId(-1L);
        user.setName("Default");
        return user;
    }
}
