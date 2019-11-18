package com.cris.superplatform.consumer.shop.feign.client;

import com.cris.superplatform.consumer.shop.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * UserFeignClient
 *
 * @author cris.zhu
 * @date 2019/11/18
 */
@FeignClient(name = "${user.userService.instance}")
public interface UserFeignClient {

    /**
     * findUserById
     *
     * @param id
     * @return User
     */
    @RequestMapping(value = "/findUserById/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Long id);

}
