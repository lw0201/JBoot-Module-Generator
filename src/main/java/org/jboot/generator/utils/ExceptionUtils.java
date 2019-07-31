package org.jboot.generator.utils;

import org.jboot.generator.exception.ApplicationException;
import org.jboot.generator.exception.BusinessException;

/**
 * 异常辅助工具类
 *
 * @author liwen
 */
public final class ExceptionUtils {

    private ExceptionUtils() {}

    /**
     * 业务异常统一处理工具
     * 
     * @param code
     *            异常编码
     * @param message
     *            异常消息
     * @return BusinessException 业务异常
     */
    public static void application(int code, String message) {
        throw new ApplicationException(code, message);
    }

    /**
     * 返回一个新的异常，统一构建，方便统一处理
     *
     * @param msg
     *            消息
     * @param t
     *            异常信息
     * @return 返回异常
     */
    public static void application(int code, String msg, Throwable cause, Object... params) {
        throw new ApplicationException(StringUtils.format(msg, params), cause);
    }

    /**
     * 重载的方法
     *
     * @param msg
     *            消息
     * @return 返回异常
     */
    public static void application(int code, String msg, Object... params) {
        throw new ApplicationException(code, StringUtils.format(msg, params));
    }

    /**
     * 重载的方法
     *
     * @param t
     *            异常
     * @return 返回异常
     */
    public static void application(Throwable cause) {
        throw new ApplicationException(cause);
    }

    /**
     * 返回一个新的异常，统一构建，方便统一处理 ExceptionUtils
     * 
     * @param msg
     *            消息
     * @param t
     *            异常信息
     * @return 返回异常
     */
    public static void business(String msg, Throwable cause, Object... params) {
        throw new BusinessException(StringUtils.format(msg, params), cause);
    }

    /**
     * 重载的方法
     *
     * @param msg
     *            消息
     * @return 返回异常
     */
    public static void business(String msg, Object... params) {
        throw new BusinessException(StringUtils.format(msg, params));
    }

    /**
     * 重载的方法
     * 
     * @param code
     *            编码
     * @param msg
     *            消息
     * @return 返回异常
     */
    public static void business(int code, String msg, Object... params) {
        throw new BusinessException(code, StringUtils.format(msg, params));
    }

    /**
     * 重载的方法
     *
     * @param t
     *            异常
     * @return 返回异常
     */
    public static void business(Throwable cause) {
        throw new BusinessException(cause);
    }

}
