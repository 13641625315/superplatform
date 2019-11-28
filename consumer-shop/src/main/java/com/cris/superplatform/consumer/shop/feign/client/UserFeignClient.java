package com.cris.superplatform.consumer.shop.feign.client;

import com.cris.superplatform.consumer.shop.pojo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * UserFeignClient
 *
 * @author cris.zhu
 * @date 2019/11/18
 */
@FeignClient(value = "${user.userService.instance}", fallbackFactory = UserFeignClient.FeignClientFallbackFactory.class)
public interface UserFeignClient {

    /**
     * findUserById
     *
     * @param id
     * @return User
     */
    @RequestMapping(value = "/findUserById/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Long id);

    @Component
    class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
        public static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

        @Override
        public UserFeignClient create(Throwable cause) {
            return new UserFeignClient() {
                @Override
                public User findUserById(Long id) {
                    FeignClientFallbackFactory.LOGGER.info("fallback;reason was:", cause);
                    User user = new User();
                    user.setId(-1L);
                    user.setUsername("Default");
                    return user;
                }
            };
        }
    }
}
