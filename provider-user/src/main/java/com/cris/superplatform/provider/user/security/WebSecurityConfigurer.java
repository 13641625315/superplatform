package com.cris.superplatform.provider.user.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * WebSecurityConfigurer
 *
 * @author cris.zhu
 * @date 2019/11/18
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

    @Component
    class CustomUserDetailsServiceImpl implements UserDetailsService {
        private final String ADMIN_USERNAME = "admin";
        private final String ADMIN_PASSWORD = "admin";
        private final String ADMIN_ROLE = "admin";

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            if (ADMIN_USERNAME.equals(username)) {
                return new SecurityUser(ADMIN_USERNAME, PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(ADMIN_PASSWORD), ADMIN_ROLE);
            } else {
                return null;
            }
        }
    }

    class SecurityUser implements UserDetails {
        private static final long serialVersionUID = 1L;

        private long id;
        private String username;
        private String password;
        private String role;
        private boolean isAccountNonExpired;
        private boolean isAccountNonLocked;
        private boolean isCredentialsNonExpired;
        private boolean isEnabled;


        public SecurityUser(String username, String password, String role) {
            super();
            this.username = username;
            this.password = password;
            this.role = role;
            this.isAccountNonExpired = true;
            this.isAccountNonLocked = true;
            this.isCredentialsNonExpired = true;
            this.isEnabled = true;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role);
            authorities.add(authority);
            return authorities;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @Override
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public boolean isAccountNonExpired() {
            return isAccountNonExpired;
        }

        public void setAccountNonExpired(boolean accountNonExpired) {
            isAccountNonExpired = accountNonExpired;
        }

        @Override
        public boolean isAccountNonLocked() {
            return isAccountNonLocked;
        }

        public void setAccountNonLocked(boolean accountNonLocked) {
            isAccountNonLocked = accountNonLocked;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return isCredentialsNonExpired;
        }

        public void setCredentialsNonExpired(boolean credentialsNonExpired) {
            isCredentialsNonExpired = credentialsNonExpired;
        }

        @Override
        public boolean isEnabled() {
            return isEnabled;
        }

        public void setEnabled(boolean enabled) {
            isEnabled = enabled;
        }
    }

}
