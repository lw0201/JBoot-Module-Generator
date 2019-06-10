package org.jboot.generator.constants;

/**
 * 常量类
 * 
 * @author liwen
 */
public class Constants {

    /** 数据库驱动 */
    public static final String driverClassName = "com.mysql.cj.jdbc.Driver";

    /** 数据库连接池 */
    public static final String type = "com.alibaba.druid.pool.DruidDataSource";

    /** 数据库URL */
    public static final String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC";

    /** 数据库用户名 */
    public static final String username = "root";

    /** 数据库用户密码 */
    public static final String password = "123456";

    /** 实体路径地址 */
    public static final String packageName = "org.jboot.generator";

    /** 资源java文件地址 */
    public static final String java = "src/main/java";

    /** 资源文件地址 */
    public static final String resources = "src/main/resources";

    /** 成功 */
    public static final String SUCCESS = "Success";

    /** 失敗 */
    public static final String FAIL = "fail";

}
