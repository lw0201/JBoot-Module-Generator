package com.frame.business.base;

import java.io.Serializable;

/**
 * 统一返回值处理
 * 
 * @author liwen
 *
 */
public class ResultBody implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	private Object data;

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
