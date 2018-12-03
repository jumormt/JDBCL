package com.itheima.c_dbuits.g_curd;

import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.itheima.utils.DataSourceUtils;

public class CURDDemo {
	@Test
	public void insert() throws SQLException{
		//1.创建queryrunner类
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		//2.编写sql
		String sql="insert into category values(?,?)";
		
		
		//3.执行sql
		qr.update(sql, "c201","厨房电器");
		
	}
	
	@Test
	public void update() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="update category set cname = ? where cid = ?";
		
		qr.update(sql, "达电器","c000");
	}
}
