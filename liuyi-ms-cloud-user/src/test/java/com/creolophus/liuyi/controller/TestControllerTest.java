package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.util.OkHttp3Util;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author magicnana
 * @date 2020/5/26 下午4:32
 */
public class TestControllerTest {

    private  static final Map<String,String> headers = new HashMap(3);


    static{
        headers.put("X-Liuyi-App-Key", "this_is_app_key");
        headers.put("X-Liuyi-Platform-key", "this_is_platform_key");
    }


//    @Test
//    public void apiDocs() {
//        OkHttp3Util.Resp ret = OkHttp3Util.get("http://127.0.0.1:31011/v2/api-docs");
//        System.out.println(ret.getBody());
//        Assert.isTrue(ret.isSuccessful(), "expect 200");
//    }
//
//    @Test
//    public void swaggerUi() {
//        OkHttp3Util.Resp ret = OkHttp3Util.get("http://127.0.0.1:31011/swagger-ui.html");
//        System.out.println(ret.getBody());
//        Assert.isTrue(ret.isSuccessful(), "expect 200");
//    }
//
//    @Test
//    public void health() {
//        OkHttp3Util.Resp ret = OkHttp3Util.get("http://127.0.0.1:31011/actuator/health");
//        System.out.println(ret.getBody());
//        Assert.isTrue(ret.isSuccessful(), "expect 200");
//    }
//
//    @Test
//    public void free() {
//        OkHttp3Util.Resp ret = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/free",null,headers);
//        System.out.println(ret.getBody());
//        Assert.isTrue(ret.isSuccessful(), "expect 200");
//    }
//
//    @Test
//    public void limit() {
//        headers.put("Authorization", "Bearer MANAGER");
//        OkHttp3Util.Resp ret3 = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/limit",null,headers);
//        System.out.println(ret3.getBody());
//        Assert.isTrue(ret3.isSuccessful(), "expect 200");
//
//        headers.put("Authorization", "Bearer PROFESSOR");
//        OkHttp3Util.Resp ret2 = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/limit",null,headers);
//        System.out.println(ret2.getBody());
//        Assert.isTrue(ret2.isSuccessful(), "expect 200");
//
//        headers.put("Authorization", "Bearer USER");
//        OkHttp3Util.Resp ret = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/limit",null,headers);
//        System.out.println(ret.getBody());
//        Assert.isTrue(ret.isSuccessful(), "expect 200");
//    }
//
//    @Test
//    public void manager() {
//
//        OkHttp3Util.Resp ret4 = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/manager",null,headers);
//        System.out.println(ret4.getBody());
//        Assert.isTrue(!ret4.isSuccessful(), "expect 401");
//        Assert.isTrue(ret4.getCode()==HttpStatus.UNAUTHORIZED.value(), "401?");
//
//
//
//        headers.put("Authorization", "Bearer MANAGER");
//        OkHttp3Util.Resp ret3 = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/manager",null,headers);
//        System.out.println(ret3.getBody());
//        Assert.isTrue(ret3.isSuccessful(), "expect 200");
//
//        headers.put("Authorization", "Bearer PROFESSOR");
//        OkHttp3Util.Resp ret2 = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/manager",null,headers);
//        System.out.println(ret2.getBody());
//        Assert.isTrue(!ret2.isSuccessful(), "expect 403");
//        Assert.isTrue(ret2.getCode()==HttpStatus.FORBIDDEN.value(), "403?");
//
//        headers.put("Authorization", "Bearer USER");
//        OkHttp3Util.Resp ret = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/manager",null,headers);
//        System.out.println(ret.getBody());
//        Assert.isTrue(!ret2.isSuccessful(), "expect 401");
//        Assert.isTrue(ret2.getCode()==HttpStatus.FORBIDDEN.value(), "403?");
//    }
//
//    @Test
//    public void corsApiDocs() {
//        headers.put("Origin", "127.0.0.1");
//        OkHttp3Util.Resp ret4 = OkHttp3Util.get("http://127.0.0.1:31011/v2/api-docs", null, headers);
//        System.out.println(ret4.getBody());
//        System.out.println(ret4.getHeaders());
//        Assert.isTrue(ret4.isSuccessful(), "200");
//    }
//
//    @Test
//    public void corsSwaggerUI() {
//        headers.put("Origin", "127.0.0.1");
//        OkHttp3Util.Resp ret4 = OkHttp3Util.get("http://127.0.0.1:31011/swagger-ui.html", null, headers);
//        System.out.println(ret4.getHeaders());
//        Assert.isTrue(ret4.isSuccessful(), "200");
//    }
//
//    @Test
//    public void corsActuator() {
//        headers.put("Origin", "127.0.0.1");
//        OkHttp3Util.Resp ret4 = OkHttp3Util.get("http://127.0.0.1:31011/actuator/health", null, headers);
//        System.out.println(ret4.getHeaders());
//        Assert.isTrue(ret4.isSuccessful(), "200");
//    }
//
//    @Test
//    public void corsFree() {
//        headers.put("Origin", "127.0.0.1");
//        OkHttp3Util.Resp ret4 = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/free", null, headers);
//        System.out.println(ret4.getHeaders());
//        Assert.isTrue(ret4.isSuccessful(), "200");
//    }
//
//    @Test
//    public void corsLimit() {
//        headers.put("Origin", "127.0.0.1");
//        headers.put("Authorization", "Bearer MANAGER");
//        OkHttp3Util.Resp ret4 = OkHttp3Util.get("http://127.0.0.1:31011/liuyi/user/test/limit", null, headers);
//        System.out.println(ret4.getBody());
//        System.out.println(ret4.getHeaders());
//        Assert.isTrue(ret4.isSuccessful(), "200");
//    }

}