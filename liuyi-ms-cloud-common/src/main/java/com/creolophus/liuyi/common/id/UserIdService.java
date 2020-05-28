package com.creolophus.liuyi.common.id;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author magicnana
 * @date 2019/6/13 上午10:25
 */
@Service
public class UserIdService {

    private static SnowflakeID userId;

    @PostConstruct
    public void init() {
        userId = new SnowflakeID(1318936401676L);
    }

    public long nexId() {
        return userId.nextId();
    }
}
