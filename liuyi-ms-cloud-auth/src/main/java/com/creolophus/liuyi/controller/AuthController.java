package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.api.ApiResult;
import com.creolophus.liuyi.common.base.AbstractController;
import com.creolophus.liuyi.common.id.UserIdService;
import com.creolophus.liuyi.common.security.UserSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author magicnana
 * @date 2018/12/27 上午11:08
 */

@Validated
@RestController
@RequestMapping(value = "/liuyi/auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @Resource
    private UserIdService userIdService;

    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public ApiResult verifyToken(
            @RequestParam("token") String token) {
        UserSecurity user = new UserSecurity();
        user.setTimestamp(System.currentTimeMillis());
        user.setToken(token);
        user.setUserId(userIdService.nexId());
        user.setTitle(token);

        logger.info("hello world");

        return new ApiResult(user);
    }


}
