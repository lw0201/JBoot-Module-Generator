package com.frame.business.builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * char字符串工具类操作
 * 
 * @author liwen
 *
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * <li>删除字符串后缀
     * 
     * @param str
     *            :字符操作对象
     * @param suffix
     *            :字符操作对象
     * @return 截取后的字符对象
     */
    public static String rmSuffix(String str, String suffix) {
        if (str.toLowerCase().endsWith(suffix.toLowerCase())) {
            return str.substring(0, str.length() - suffix.length());
        }
        return str;
    }

    /**
     * <li>删除字符串前缀
     * 
     * @param str
     *            :字符操作对象
     * @return 截取后的字符对象
     */
    public static String rmPrefix(String str, String prefix) {
        if (str.toLowerCase().startsWith(prefix.toLowerCase())) {
            return str.substring(str.length() - prefix.length() + 1, str.length());
        }
        return str;
    }

    public static final char UNDERLINE = '_';

    /**
     * <li>驼峰格式字符串转换为下划线格式字符串
     * 
     * @param param
     *            :要处理的字符串参数
     * @return 下划线格式字符串
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * <li>下划线格式字符串转换为驼峰格式字符串
     * 
     * @param param
     *            : 要处理的字符串参数
     * @return 驼峰字符串
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);
        Matcher mc = Pattern.compile("_").matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }

    /**
     * <li>字符串首字母转小写
     * 
     * @param s
     *            :需要转换的字符串
     * @return 字符串F
     */
    public static String toLowerCaseFirst(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();

        }
    }

    /**
     * <li>首字母转大写
     * 
     * @param s
     *            :需要转换的字符串
     * @return 字符串F
     */
    public static String toUpperCaseFirst(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}
