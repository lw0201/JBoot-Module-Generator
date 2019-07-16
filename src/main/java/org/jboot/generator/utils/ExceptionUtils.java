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
    public static ApplicationException app(int code, String message) {
        return new ApplicationException(code, message);
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
    public static ApplicationException app(int code, String msg, Throwable t, Object... params) {
        return new ApplicationException(StringUtils.format(msg, params), t);
    }

    /**
     * 重载的方法
     *
     * @param msg
     *            消息
     * @return 返回异常
     */
    public static ApplicationException app(int code, String msg, Object... params) {
        return new ApplicationException(StringUtils.format(msg, params));
    }

    /**
     * 重载的方法
     *
     * @param t
     *            异常
     * @return 返回异常
     */
    public static ApplicationException app(Throwable t) {
        return new ApplicationException(t);
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
    public static BusinessException busi(String msg, Throwable t, Object... params) {
        return new BusinessException(StringUtils.format(msg, params), t);
    }

    /**
     * 重载的方法
     *
     * @param msg
     *            消息
     * @return 返回异常
     */
    public static BusinessException busi(String msg, Object... params) {
        return new BusinessException(StringUtils.format(msg, params));
    }

    /**
     * 重载的方法
     *
     * @param t
     *            异常
     * @return 返回异常
     */
    public static BusinessException busi(Throwable t) {
        return new BusinessException(t);
    }

}
