package com.creolophus.liuyi.common.security;

import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

/**
 * @author magicnana
 * @date 2020/5/26 下午4:21
 */
public class UserSecurityTest {


    @Test
    public void string2RoleTest(){
        String title2 = "MANAGER";

        UserSecurity.Role role2 = UserSecurity.Role.valueOf(title2);
        Assert.isTrue(role2.equals(UserSecurity.Role.MANAGER),"大写字母不能 valueOf 成枚举" );
        Assert.isTrue(role2.name().equals(title2),"枚举的 name 不是枚举的字面值?");

    }

}