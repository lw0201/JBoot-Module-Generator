package com.frame.business.builder;

/**
 * 字段信息
 * 
 * @author liwen
 *
 */
public class FieldInfo {

	public static final String suffix = "";

	public static final String prefix = "";

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
	private EntityMapping em;

	/**
	 * 字段类型
	 */
	private FieldType fieldType;

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

	public EntityMapping getEm() {
		return em;
	}

	public void setEm(EntityMapping em) {
		this.em = em;
	}

	public static String getSuffix() {
		return suffix;
	}

	public static String getPrefix() {
		return prefix;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

}
