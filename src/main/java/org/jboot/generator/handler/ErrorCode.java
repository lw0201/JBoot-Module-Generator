package org.jboot.generator.handler;

/**
 * 全局性系统异常处理,http状态不等于200的错误信息
 * 
 * @author liwen
 */
public class ErrorCode {

    /** 参数验证异常处理 */
    public static final int VALID_ERROR = 400;

    /** 未知异常 */
    public final static int OTHER = 10000;

    /** 服务异常 */
    public static final int INTERNAL_SERVER_ERROR = 500;

    /** 不支持当前媒体类型 */
    public static final int UNSUPPORTED_MEDIA_TYPE = 501;

    /** 不支持当前请求方法 */
    public static final int METHOD_NOT_ALLOWED = 502;

    /** Not Found */
    public static final int NOT_FOUND = 503;

    /** 参数验证绑定异常 */
    public static final int BAD_REQUEST = 504;

    /** 空指针异常 */
    public static final int NULL_POINTER = 505;

    /** 类型转换错误 */
    public static final int CLASS_CAST = 506;

    /** 数组索引越界 */
    public static final int INDEX_OUTOF = 507;

    /** 找不到对应的文件 */
    public static final int FILE_NOT_FOUND = 507;

    /** 数字转换异常 */
    public static final int NUMBER_FORMAT = 509;

    /** SQL发生异常 */
    public static final int SQL_ERROR = 510;

    /** IO发生异常 */
    public static final int IO_ERROR = 511;

    /** 方法未找到 */
    public static final int NO_SUCH_METHOD = 512;

    /** 系统内存溢出 */
    public static final int OUTOF_MEMORY_ERROR = 513;

    /** 堆栈内存异常 */
    public static final int STACK_OVER_FLOW_ERROR = 514;

    /** 系统找不到对应的类 */
    public static final int CLASS_NOT_FOUND = 515;

    /** 违反了数据库约束 */
    public static final int DUPLICATE_KEY = 516;

    /** 运行时异常 */
    public static final int RUNTIME = 517;

    /** 参数绑定异常处理 */
    public static final int BIND_ERROR = 518;

}
