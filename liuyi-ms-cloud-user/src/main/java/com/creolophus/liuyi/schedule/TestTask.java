package com.creolophus.liuyi.schedule;

import com.creolophus.liuyi.common.logger.Entry;
import com.creolophus.liuyi.service.Foo1Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author magicnana
 * @date 2019/12/24 下午4:31
 */
@Service
public class TestTask {

    Logger logger = LoggerFactory.getLogger(TestTask.class);

    @Resource
    private Foo1Service foo1Service;

    @Entry
    @Scheduled(cron = "0 0/1 * * * ?")
    public void smsBeat() {
        foo1Service.foo1();
    }
}
