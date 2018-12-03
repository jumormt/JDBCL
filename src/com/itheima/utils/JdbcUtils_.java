package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils_ {
    // 获取连接
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 注册驱动   ctrl+shift+f格式化代码
        Class.forName("com.mysql.jdbc.Driver");

        // 获取连接 ctrl+o 整理包
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day07?serverTimezone=UTC", "root", "1234");
        return conn;
    }

    /**
     * 释放资源
     *
     * @param conn 连接
     * @param st   语句执行者
     * @param rs   结果集
     */
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConn(conn);
    }

    /**
     * 释放连接
     *
     * @param conn 连接
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
     * @param st 语句执行者
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
     * @param rs 结果集
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
