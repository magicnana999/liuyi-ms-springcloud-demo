package com.creolophus.liuyi.feign;

import com.creolophus.liuyi.common.security.UserSecurity;

/**
 * @author magicnana
 * @date 2019/7/2 上午12:46
 */
public class AuthFeignHystrix implements AuthFeign {

    @Override
    public UserSecurity verify(String token) {
        return null;
    }

}
