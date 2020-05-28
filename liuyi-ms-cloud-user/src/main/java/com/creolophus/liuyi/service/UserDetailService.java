package com.creolophus.liuyi.service;

import com.creolophus.liuyi.common.security.UserSecurity;
import com.creolophus.liuyi.feign.AuthFeign;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author magicnana
 * @date 2019/7/2 上午9:19
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Resource
    private AuthFeign authFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSecurity userSecurity = authFeign.verify(username);
        if(userSecurity == null) {
            return null;
        }

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Arrays.asList(
                        new SimpleGrantedAuthority(UserSecurity.Role.valueOf(userSecurity.getTitle()).getRole()),
                        new SimpleGrantedAuthority(UserSecurity.Role.USER.getRole()));
            }

            @Override
            public String getPassword() {
                return "";
            }

            @Override
            public String getUsername() {
                return userSecurity.getUserId() + "";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
