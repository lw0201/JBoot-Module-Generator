package com.frame.business.builder;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 定义获取和关闭数据源的方法
 * 
 * @author liwen
 */
public class DataSourceUtil {

	/**
	 * 注册数据库驱动
	 */
	static {
		try {
			Class.forName(Constant.driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据源
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * 关闭数据源
	 * 
	 * @throws SQLException
	 */
	public static void closeConnection(Connection conn) throws SQLException {
		if (null != conn) {
			conn.close();
		}
	}

	public static List<TableInfo> getTables() throws SQLException {
		List<TableInfo> tableInfos = new ArrayList<TableInfo>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
			DatabaseMetaData metaData = connection.getMetaData();
			ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" });
			while (tables.next()) {
				TableInfo tableInfo = new TableInfo();
				String table_name = tables.getString("TABLE_NAME");
				String remarkes = tables.getString("REMARKS");
				tableInfo.setTableName(table_name);
				tableInfo.setEntityName(table_name);
				tableInfo.setPackageName("");
				tableInfo.setComments(remarkes);
				ResultSet columns = metaData.getColumns(null, null, table_name, "%");
				List<FieldInfo> fieldInfos = new ArrayList<FieldInfo>();
				while (columns.next()) {
					String column_name = columns.getString("COLUMN_NAME");
					String type_name = columns.getString("TYPE_NAME");
					String comments = columns.getString("REMARKS");
					String sqlType = columns.getString("DATA_TYPE");
					FieldInfo fieldInfo = new FieldInfo();
					fieldInfo.setFieldName(column_name);
					fieldInfo.setAttrName(column_name);
					fieldInfo.setFieldType(type_name);
					fieldInfo.setComments(comments);
					fieldInfos.add(fieldInfo);
				}
				tableInfo.setFields(fieldInfos);
				tableInfos.add(tableInfo);
			}
		} finally {
			closeConnection(connection);
		}

		return tableInfos;

	}
	
	public static void main(String[] args) {
		try {
			List<TableInfo> tables = DataSourceUtil.getTables();
			System.err.println(JSON.toJSONString(tables));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
