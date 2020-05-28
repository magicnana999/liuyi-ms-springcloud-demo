package com.creolophus.liuyi.common.api;

import com.creolophus.liuyi.common.exception.UnauthorizedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;

/**
 * @author magicnana
 * @date 2019/12/20 下午1:51
 */
public class LiuYiApiContextValidator extends ApiContextValidator {


    public static final String APP_KEY="appKey";
    public static final String DEVICE_ID="deviceId";
    public static final String PLATFORM_KEY = "platformKey";

    @Override
    public String[] ignoringAntMatchers() {
        return new String[]{"/liuyi/user/test/free"};
    }

    private static final Logger logger = LoggerFactory.getLogger(LiuYiApiContextValidator.class);

    public String getAppKey(){
        return ApiContext.getContext().getExt().get(APP_KEY);
    }

    public String getDeviceID(){
        return ApiContext.getContext().getExt().get(DEVICE_ID);
    }

    public String getPlatformKey(){
        return ApiContext.getContext().getExt().get(PLATFORM_KEY);
    }

    public String getExt(){
        String appKey = getAppKey();
        String platformKey = getPlatformKey();

        appKey = StringUtils.isBlank(appKey)?"-":appKey;
        platformKey = StringUtils.isBlank(platformKey)?"-":platformKey;
        return appKey +" "+platformKey;
    }

    public void setAppKey(String appKey) {
        ApiContext.getContext().setExt(APP_KEY, appKey);
        MDC.put(GlobalSetting.MDC_EXT, getExt());
    }

    public void setDeviceId(String deviceId){
        ApiContext.getContext().setExt(DEVICE_ID, deviceId);
        MDC.put(GlobalSetting.MDC_EXT, getExt());
    }


    public void setPlatformKey(String platformKey) {
        ApiContext.getContext().setExt(PLATFORM_KEY, platformKey);
        MDC.put(GlobalSetting.MDC_EXT, getExt());
    }

    public void validateAppKey(HttpServletRequest request) {

        String appKey = request.getHeader(LiuYiSetting.HEADER_APP_KEY);

        if(StringUtils.isBlank(appKey)) {
            throw new UnauthorizedException(ApiErrorCode.C_APP_KEY_IS_NULL.getMessage());
        } else {
            setAppKey(appKey);
        }
    }

    public void validateDeviceId(HttpServletRequest request) {

        String deviceId = request.getHeader(LiuYiSetting.HEADER_DEVICE_ID);

        if(StringUtils.isBlank(deviceId)) {
            throw new UnauthorizedException(ApiErrorCode.C_DEVICE_ID_IS_NULL.getMessage());
        } else {
            setDeviceId(deviceId);
        }
    }

    public void validatePlatformKey(HttpServletRequest request) {

        String platformKey = request.getHeader(LiuYiSetting.HEADER_PLATFORM_KEY);

        if(StringUtils.isBlank(platformKey)) {
            throw new UnauthorizedException(ApiErrorCode.C_PLATFORM_KEY_IS_NULL.getMessage());
        } else {
            setPlatformKey(platformKey);
        }
    }
}
