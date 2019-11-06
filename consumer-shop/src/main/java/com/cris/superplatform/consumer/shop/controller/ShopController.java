package com.cris.superplatform.consumer.shop.controller;

import com.cris.superplatform.consumer.shop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShopController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.userServiceUrl.findById}")
    private String userServiceUrl;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(userServiceUrl + id, User.class);
    }
}