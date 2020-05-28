package com.creolophus.liuyi.common.api;

/**
 * @author magicnana
 * @date 2019/12/20 下午2:37
 */
public class ApiErrorCode extends ApiError{

    private static int start = 1000;
    public static final ApiError C_APP_KEY_IS_NULL = new ApiError(start++, "AppKey not found");
    public static final ApiError C_DEVICE_ID_IS_NULL = new ApiError(start++, "DeviceID not found");
    public static final ApiError C_PLATFORM_KEY_IS_NULL = new ApiError(start++, "PlatformKey not found");

    public ApiErrorCode(int code, String message) {
        super(code, message);
    }
}
