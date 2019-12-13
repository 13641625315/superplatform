package com.cris.superplatform.consumer.shop.feign.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * UserFeignClientConfig
 *
 * @author cris.zhu
 * @date 2019/11/19
 */
@Configuration
public class UserFeignClientConfig {

    @Value("${user.userService.basicAuth.username}")
    private String adminUsername;
    @Value("${user.userService.basicAuth.password}")
    private String adminPassword;

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(adminUsername, adminPassword);
    }
}
