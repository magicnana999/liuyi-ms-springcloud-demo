package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.api.ApiResult;
import com.creolophus.liuyi.common.base.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author magicnana
 * @date 2018/12/27 上午11:08
 */

@Validated
@RestController
@RequestMapping(value = "/liuyi/user/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/free", method = RequestMethod.GET)
    public ApiResult foo1() {
        return new ApiResult("free resources");
    }

    @RequestMapping(value = "/limit", method = RequestMethod.GET)
    public ApiResult foo2() {
        return new ApiResult("limit resources ");
    }

    @PreAuthorize("hasRole('MANAGER')")
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ApiResult foo3() {
        return new ApiResult("manager resources ");
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @RequestMapping(value = "/professor", method = RequestMethod.GET)
    public ApiResult foo4() {
        return new ApiResult("manager resources ");
    }


}
