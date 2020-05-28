package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.api.ApiError;
import com.creolophus.liuyi.common.api.ApiResult;
import com.creolophus.liuyi.common.base.AbstractController;
import com.creolophus.liuyi.common.exception.ApiException;
import com.creolophus.liuyi.common.exception.BrokenException;
import com.creolophus.liuyi.common.exception.ErrorCodeException;
import com.creolophus.liuyi.common.exception.HttpStatusException;
import com.creolophus.liuyi.common.id.UserIdService;
import com.creolophus.liuyi.common.security.UserSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Email;

/**
 * @author magicnana
 * @date 2018/12/27 上午11:08
 */

@Validated
@RestController
@RequestMapping(value = "/liuyi/auth/error", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private UserIdService userIdService;

    @RequestMapping(value = "/foo1", method = RequestMethod.GET)
    public ApiResult foo1(
            @RequestParam("parameter1") String parameter1,
            @Email @RequestParam("parameter2") String parameter2) {
        return new ApiResult(parameter1 +" "+parameter2);
    }

    @RequestMapping(value = "/runtime", method = RequestMethod.GET)
    public ApiResult foo2(
            @RequestParam("parameter1") String parameter1,
            @RequestParam("parameter2") String parameter2) {
        throw new RuntimeException("return "+ ApiError.E_ERROR.getMessage());
    }


    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public ApiResult foo3(
            @RequestParam("parameter1") String parameter1,
            @RequestParam("parameter2") String parameter2) {
        throw new ApiException("这将返回一个自定义消息");
    }

    @RequestMapping(value = "/http_status", method = RequestMethod.GET)
    public ApiResult foo4(
            @RequestParam("parameter1") String parameter1,
            @RequestParam("parameter2") String parameter2) {
        throw new HttpStatusException(HttpStatus.NOT_EXTENDED);
    }

    @RequestMapping(value = "/error_code", method = RequestMethod.GET)
    public ApiResult foo5(
            @RequestParam("parameter1") String parameter1,
            @RequestParam("parameter2") String parameter2) {
        throw new ErrorCodeException(ApiError.E_ERROR_BUILD_ERROR);
    }

    @RequestMapping(value = "/broken", method = RequestMethod.GET)
    public ApiResult foo6(
            @RequestParam("parameter1") String parameter1,
            @RequestParam("parameter2") String parameter2) {
        throw new BrokenException("broken");
    }

}
