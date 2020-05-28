package com.creolophus.liuyi.common.swagger;

import com.creolophus.liuyi.common.api.GlobalSetting;
import com.creolophus.liuyi.common.api.LiuYiSetting;
import springfox.documentation.service.Parameter;

/**
 * @author magicnana
 * @date 2019/12/20 下午1:48
 */
public class LiuYiDocket extends SwaggerDocket {

    public static Parameter appKey() {
        return header(LiuYiSetting.HEADER_APP_KEY, true, "be7fcee88904a31d40064240ac13d931");
    }

    public static Parameter deviceId() {
        return header(LiuYiSetting.HEADER_DEVICE_ID, true, "110860220");
    }

    public static Parameter platformKey() {
        return header(LiuYiSetting.HEADER_PLATFORM_KEY, true, "7.0");
    }

    public static Parameter token() {
        return header(GlobalSetting.HEADER_TOKEN_KEY, false, GlobalSetting.HEADER_TOKEN_PRE + " ");
    }
}
