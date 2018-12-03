package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtils {
	static final String DRIVERCLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	
	static {
		// 块编辑 alt+shift +a
		// 变大写 ctrl+shift+x
		// 变小写 ctrl+shift+y
		// 向下复制一行   alt+ctrl+↓
		// 向下添加一个空行 shift + enter
		// 向上添加一个空行 ctrl+shift + enter
		// 删除一行 选中行  ctrl+d
		// 注释或者去掉注释 ctrl+/
		// 向下移动一行 alt + ↓
		
		
		// 获取ResourceBundle ctrl+2 l
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		
		// 获取指定的内容
		DRIVERCLASS = bundle.getString("driverClass");
		URL = bundle.getString("url");
		USER = bundle.getString("user");
		PASSWORD = bundle.getString("password");
	}
	
	static {
		// 注册驱动 ctrl+shift+f格式化代码
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	// 获取连接
	public static Connection getConnection() throws SQLException {
		// 获取连接 ctrl+o 整理包
		return  DriverManager.getConnection(URL, USER, PASSWORD);
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            连接
	 * @param st
	 *            语句执行者
	 * @param rs
	 *            结果集
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}

	/**
	 * 释放连接
	 * 
	 * @param conn
	 *            连接
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	/**
	 * 释放语句执行者
	 * 
	 * @param st
	 *            语句执行者
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}

	}

	/**
	 * 释放结果集
	 * 
	 * @param rs
	 *            结果集
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

	}
}
