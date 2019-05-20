package com.frame.business.exception;

import com.frame.business.constant.CommonConstant;

/**
 * 自定义异常处理类
 * 
 * @author liwen
 *
 */
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -8535710000964127898L;

	/**
	 * 异常码
	 */
	private int code;

	/**
	 * 异常消息描述
	 */
	private String message;

	public ApplicationException() {
		super();
		this.code = 500;
		this.message = CommonConstant.FAIL;
	}

	public ApplicationException(String message) {
		super(message);
		this.code = 500;
		this.message = message;
	}

	public ApplicationException(int code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(Throwable cause) {
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
