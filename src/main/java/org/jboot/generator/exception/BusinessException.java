package org.jboot.generator.exception;

import org.jboot.generator.constants.Constants;

/**
 * ApplicationException 自定义异常处理类
 * 
 * @author liwen
 *
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -8535710000964127898L;

    /**
     * code 异常码
     */
    private int code;

    /**
     * message 异常消息描述
     */
    private String message;

    public BusinessException() {
        super();
        this.code = 500;
        this.message = Constants.FAIL;
    }

    public BusinessException(String message) {
        super(message);
        this.code = 500;
        this.message = message;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
