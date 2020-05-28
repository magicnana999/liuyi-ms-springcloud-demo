package com.creolophus.liuyi.feign;

import com.creolophus.liuyi.common.security.UserSecurity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author magicnana
 * @date 2018/12/20 下午4:00
 */
@FeignClient(value = "liuyi-ms-cloud-auth", fallback = AuthFeignHystrix.class)
public interface AuthFeign {

    @RequestMapping(value = "/liuyi/auth/verify", method = RequestMethod.GET)
    UserSecurity verify(@RequestParam("token") String token);

}
