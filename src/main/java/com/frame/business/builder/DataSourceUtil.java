package com.frame.business.builder;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 定义获取和关闭数据源的方法
 * 
 * @author liwen
 */
public class DataSourceUtil {

	private final static Logger logger = LoggerFactory.getLogger(FreemarkerUtil.class);

	/**
	 * 注册数据库驱动
	 */
	static {
		try {
			Class.forName(Constant.driverClassName);
		} catch (ClassNotFoundException e) {
			logger.error("Load drive failure:", e);
		}
	}

	/**
	 * 获取数据源
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection(String url, String user, String password) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			logger.error("Load drive failure:", e);
		}
		return conn;
	}

	/**
	 * 关闭数据源
	 * 
	 * @throws SQLException
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("close db conn error:", e);
		}
	}

	public static List<TableInfo> getTables() {
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
				tableInfo.setEntityName(StringUtils.toUpperCaseFirst(StringUtils.underlineToCamel(table_name)));
				tableInfo.setPackageName("");
				tableInfo.setComments(remarkes);
				ResultSet columns = metaData.getColumns(null, null, table_name, "%");
				List<FieldInfo> fieldInfos = new ArrayList<FieldInfo>();
				while (columns.next()) {
					String colName = columns.getString("COLUMN_NAME");
					String comments = columns.getString("REMARKS");
					int dataType = columns.getInt("DATA_TYPE");
					EntityMapping data = EntityMapping.forKey(dataType);
					if (null == tableInfo.getImportPackages()) {
						tableInfo.setImportPackages(new HashSet<String>());
					}
					tableInfo.setPackageName(Constant.packageName);
					tableInfo.getImportPackages().add(data.getJavaType());
					FieldInfo fieldInfo = new FieldInfo();
					fieldInfo.setFieldName(colName);
					fieldInfo.setAttrName(StringUtils.underlineToCamel(colName));
					fieldInfo.setEm(data);
					fieldInfo.setComments(comments);
					fieldInfos.add(fieldInfo);
				}
				tableInfo.setFields(fieldInfos);
				tableInfos.add(tableInfo);
			}
		} catch (SQLException e) {
			System.err.println(e);
			logger.error("db error:", e);
		} finally {
			closeConnection(connection);
		}
		return tableInfos;

	}

	public static void main(String[] args) {
		List<TableInfo> tables = DataSourceUtil.getTables();
		System.err.println(JSON.toJSONString(tables));
	}

}
