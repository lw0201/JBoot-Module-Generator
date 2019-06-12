package org.jboot.generator.base;

import java.io.Serializable;

import lombok.Data;

/**
 * 统一返回值处理
 * 
 * @author liwen
 *
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回编码
     */
    private int code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public Result() {
        super();
    }

    public Result(T data) {
        success();
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * success
     */
    public Result<T> success() {
        this.code = 200;
        this.message = "Success!";
        return new Result<T>(code, message);
    }

    /**
     * success
     */
    public Result<T> success(T data) {
        this.code = 200;
        this.message = "Success!";
        this.data = data;
        return new Result<T>(code, message, data);
    }

    /**
     * success
     */
    public Result<T> fail() {
        this.code = 500;
        this.message = "Fail!";
        return new Result<T>(code, message);
    }

    /**
     * success
     */
    public Result<T> fail(T data) {
        this.code = 500;
        this.message = "Fail!";
        return new Result<T>(code, message, data);
    }

}
