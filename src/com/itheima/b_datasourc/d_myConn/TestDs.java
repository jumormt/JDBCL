package com.itheima.b_datasourc.d_myConn;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDs {

	public static void main(String[] args) throws SQLException {
		//创建连接池
		MyDataSource ds = new MyDataSource();
		
		//获取连接
		Connection conn=ds.getConnection();
		System.out.println(conn);
		
		//归还连接
		conn.close();
	}

}
