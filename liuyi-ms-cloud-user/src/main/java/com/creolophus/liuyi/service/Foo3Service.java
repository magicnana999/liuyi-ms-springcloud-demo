package com.creolophus.liuyi.service;

import com.creolophus.liuyi.common.base.AbstractService;
import com.creolophus.liuyi.common.logger.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author magicnana
 * @date 2019/12/24 下午4:29
 */
@Service
public class Foo3Service extends AbstractService implements Runnable{
    Logger logger = LoggerFactory.getLogger(Foo3Service.class);

    @Entry
    public void foo3() {
        logger.info("foo3");
    }

    @Override
    public void run() {
        foo3();
    }
}
