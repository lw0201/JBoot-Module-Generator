package com.frame.business.builder;

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
	
}
