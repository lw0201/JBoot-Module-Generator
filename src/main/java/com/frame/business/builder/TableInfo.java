package com.frame.business.builder;

import java.util.List;
import java.util.Set;

/**
 * 表信息
 */
public class TableInfo {

	public static final String suffix = "";

	public static final String prefix = "";

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
	 * 需要生产的实体对象包路径
	 */
	private String packageName;

	/**
	 * 表所有的字段信息
	 */
	private List<FieldInfo> fields;

	/**
	 * 需要导入的包
	 */
	private Set<String> importPackages;

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

	public Set<String> getImportPackages() {
		return importPackages;
	}

	public void setImportPackages(Set<String> importPackages) {
		this.importPackages = importPackages;
	}

}
