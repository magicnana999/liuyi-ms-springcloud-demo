package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.util.OkHttp3Util;
import com.creolophus.liuyi.test.AbstractTest;
import com.jsoniter.JsonIterator;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;


/**
 * @author magicnana
 * @date 2020/5/26 上午10:03
 */
public class TestControllerTest extends AbstractTest {

    @Test
    public void foo1test() throws Exception {
        MockHttpServletResponse res1 = mvc.perform(post("/liuyi/auth/error/foo1")).andReturn().getResponse();
        shouldBeEquals(res1.getStatus(),HttpStatus.METHOD_NOT_ALLOWED);

        MockHttpServletResponse res2 = mvc.perform(post("/liuyi/auth/error/foo1xxxx")).andReturn().getResponse();
        shouldBeEquals(res2.getStatus(),HttpStatus.NOT_FOUND);

        //miss require parameter
        MockHttpServletResponse res3 = mvc.perform(
                get("/liuyi/auth/error/foo1")
                        .param("parameter1","hello")).andReturn().getResponse();
        shouldBeEquals(res3.getStatus(),HttpStatus.BAD_REQUEST);


        MockHttpServletResponse res5 = mvc.perform(
                get("/liuyi/auth/error/foo1")
                        .param("parameter1","hello")
                        .param("parameter2","xxx@gmail.com")).andReturn().getResponse();
        shouldBeEquals(res5.getStatus(),HttpStatus.OK);

    }

}