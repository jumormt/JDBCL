package com.itheima.b_datasourc.b_myds;

import java.sql.Connection;

public class TestDs {

	public static void main(String[] args) {
		//创建连接池
		MyDataSource ds = new MyDataSource();
		
		//获取连接
		Connection conn=ds.getConnection();
		System.out.println(conn);
		
		//归还连接
		ds.addBack(conn);
	}

}
