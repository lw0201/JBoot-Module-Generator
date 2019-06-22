package org.jboot.generator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具类
 * 
 * @author liwen
 */
public class ValidatorUtils {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    /**
     * 校验src是否为指定的手机号格式
     * 
     * @param phone
     *            需要校验的手机号
     * @return 是指定的手机号返回true,否则false
     */
    public static boolean isMobile(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(phone);
        return m.matches();
    }

    public static boolean isValidUUID(String uuid) {
        String regex = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
        if (uuid.matches(regex)) {
            return true;
        }
        return false;
    }
}
