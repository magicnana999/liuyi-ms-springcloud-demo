package com.creolophus.liuyi.test;

import com.creolophus.liuyi.boot.Start;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Start.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public abstract class AbstractTest {

    @Autowired
    protected MockMvc mvc;

    private void intercept(MockHttpServletRequestBuilder requestBuilder){
        requestBuilder
                .header("Authorization","")
                .header("x-liuyi-app-key","be7fcee88904a31d40064240ac13d931")
                .header("x-liuyi-device-id","2q3rwfdfgsd")
                .header("x-liuyi-platform-key","7.0")
                .contentType(MediaType.APPLICATION_JSON_UTF8);
    }

    protected MockHttpServletRequestBuilder get(String url) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
        intercept(requestBuilder);
        return requestBuilder;
    }


    protected MockHttpServletRequestBuilder post(String url) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
        intercept(requestBuilder);
        return requestBuilder;
    }

    public static class MapBuilder{
        private Map<String,String> map;

        public MapBuilder(){
            map = new HashMap();
        }

        public MapBuilder(String key,String value){
            this();
            map.put(key, value);
        }

        public MapBuilder append(String key,String value){
            this.map.put(key, value);
            return this;
        }

        public Map<String,String> map(){
            return map;
        }
    }

    protected void shouldBeEquals(int code, HttpStatus httpStatus){
        Assert.isTrue(code == httpStatus.value(), "expect : "+httpStatus.value()+", actual : "+code);
    }

    protected void shouldContains(String ret, String expect){
        Assert.isTrue(StringUtils.isNotBlank(ret) && ret.contains(expect),"expect : "+expect );
    }
}
