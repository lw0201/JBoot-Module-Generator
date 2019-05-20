package com.frame.business.builder;

/**
 * 字段类型
 * 
 * @author liwen
 *
 */
public enum FieldType {

	/**
	 * 主键
	 */
	PK("pk"),

	/**
	 * 普通键
	 */
	CK("ck");

	private String key;

	FieldType(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
