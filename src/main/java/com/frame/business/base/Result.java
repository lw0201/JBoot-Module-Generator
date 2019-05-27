package com.frame.business.base;

import java.io.Serializable;

/**
 * 统一返回值处理
 * 
 * @author liwen
 *
 */
public class Result<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	private T data;

	public void success() {
		this.code = 200;
		this.message = "Success!";
	}
	
	public void fail() {
		this.code = 500;
		this.message = "Fail!";
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
