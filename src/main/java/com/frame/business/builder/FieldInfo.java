package com.frame.business.builder;

/**
 * 字段信息
 * 
 * @author liwen
 *
 */
public class FieldInfo {

	/**
	 * 字段名称
	 */
	private String fieldName;

	/**
	 * 属性名称
	 */
	private String attrName;

	/**
	 * 字段备注描述信息
	 */
	private String comments;

	/**
	 * 字段类型
	 */
	private String fieldType;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

}
