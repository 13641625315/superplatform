package com.cris.superplatform.provider.user.controller;

import com.cris.superplatform.provider.user.dao.UserRepository;
import com.cris.superplatform.provider.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * UserController
 *
 * @author cris.zhu
 * @date 2019/11/18
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for (GrantedAuthority c : collection) {
                UserController.LOGGER.info("Current User is {},Role is {}", user.getUsername(), c.getAuthority());
            }
        } else {
            //do other things
        }
        return this.userRepository.findById(id).orElse(null);
    }
}
