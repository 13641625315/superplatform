package com.cris.superplatform.consumer.shop.controller;

import com.cris.superplatform.consumer.shop.feign.client.UserFeignClient;
import com.cris.superplatform.consumer.shop.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ShopController
 *
 * @author cris.zhu
 * @date 2019/11/18
 */
@RestController
public class ShopController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private UserFeignClient userFeignClient;
    @Value("${user.userService.instance}")
    private String userServiceInstance;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findUserById(id);
    }

}
