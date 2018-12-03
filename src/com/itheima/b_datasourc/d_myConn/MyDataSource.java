package com.itheima.b_datasourc.d_myConn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import com.itheima.utils.JdbcUtils;

/**
 * 升级的连接池
 * @author Administrator
 *
 */
public class MyDataSource {
	static LinkedList<Connection> pool=new LinkedList<>();
	static{
		//初始化的时候 需要放入3个连接
		for (int i = 0; i < 3; i++) {
			try {
				Connection conn = JdbcUtils.getConnection();
				pool.addLast(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//从连接池中获取连接
	public static Connection getConnection(){
		//获取连接的时候需要判断list是否为空
		if(pool.isEmpty()){
			//在添加2个连接进去
			for (int i = 0; i < 3; i++) {
				try {
					Connection conn = JdbcUtils.getConnection();
					pool.addLast(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("从池中获取一个连接");
		 Connection conn = pool.removeFirst();
		 //将conn进行包装 
		 // ConnectionWarp myConn = new ConnectionWarp(conn);
		 ConnectionWarp myConn = new ConnectionWarp(conn,pool);
		return myConn;
	}
	
	//归还连接的方法
	public static void addBack(Connection conn){
		//将conn放入到list的最后面即可
		pool.addLast(conn);
		System.out.println("连接已归还");
	}
}
