package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.api.ApiResult;
import com.creolophus.liuyi.common.base.AbstractController;
import com.creolophus.liuyi.common.entity.User;
import com.creolophus.liuyi.common.id.UserIdService;
import com.creolophus.liuyi.service.Foo1Service;
import com.creolophus.liuyi.service.Foo2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author magicnana
 * @date 2018/12/27 上午11:08
 */

@Validated
@RestController
@RequestMapping(value = "/liuyi/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserIdService userIdService;

    @Resource
    private Foo1Service foo1Service;


    @Resource
    private Foo2Service foo2Service;

    @RequestMapping(value = "/foo1", method = RequestMethod.GET)
    public ApiResult foo1() {

        List<User> list = new ArrayList();
        for(int i=0;i<10;i++){

            User user = new User();
            user.setId(userIdService.nexId());
            user.setNickName("你好");
            user.setPhone("13810117901");
            list.add(user);
        }


        logger.info("hello world");


        foo1Service.foo1();

        return new ApiResult(list);
    }

    @RequestMapping(value = "/foo2", method = RequestMethod.GET)
    public ApiResult foo2() {
        logger.info("hello world");
        foo2Service.foo2();
        return new ApiResult("Hello World foo2 ");
    }


}
