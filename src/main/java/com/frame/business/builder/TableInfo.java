package com.frame.business.builder;

import java.util.List;

/**
 * 表信息
 */
public class TableInfo {

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 表描述
	 */
	private String comments;

	/**
	 * 实体名称
	 */
	private String entityName;

	/**
	 * 包名称
	 */
	private String packageName;
	
	/**
	 * 表所有的字段信息
	 */
	private List<FieldInfo> fields;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<FieldInfo> getFields() {
		return fields;
	}

	public void setFields(List<FieldInfo> fields) {
		this.fields = fields;
	}
	
}
