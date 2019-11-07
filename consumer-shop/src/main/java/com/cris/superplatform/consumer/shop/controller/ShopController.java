package com.cris.superplatform.consumer.shop.controller;

import com.cris.superplatform.consumer.shop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class ShopController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${user.userService.instance}")
    private String userServiceInstance;
    @Value("${user.userService.url.findById}")
    private String userServiceUrl;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        URI userServiceUrl2 = this.discoveryClient.getInstances(userServiceInstance).get(0).getUri();
        return this.restTemplate.getForObject(userServiceUrl + id, User.class);
    }

    @GetMapping
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances(userServiceInstance);
    }
}
