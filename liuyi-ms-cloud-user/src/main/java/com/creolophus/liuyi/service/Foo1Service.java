package com.creolophus.liuyi.service;

import com.creolophus.liuyi.common.base.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author magicnana
 * @date 2019/12/24 下午4:29
 */
@Service
public class Foo1Service extends AbstractService {
    Logger logger = LoggerFactory.getLogger(Foo1Service.class);

    public void foo1() {
        logger.info("ee s`Sdf ");
    }
}
