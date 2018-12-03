package com.itheima.c_dbuits.g_curd;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.itheima.domain.Category;
import com.itheima.utils.DataSourceUtils;

public class ResultHandleDemo {
	@Test
	public void arrayHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from category";
		
		Object[] query = qr.query(sql, new ArrayHandler());
		System.out.println(Arrays.toString(query));
	}
	
	@Test
	public void arrayListHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from category";
		List<Object[]> list = qr.query(sql, new ArrayListHandler());
		for (Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}
	}
	
	
	@Test
	public void beanHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from category";
		
		Category bean = qr.query(sql, new BeanHandler<>(Category.class));
		
		System.out.println(bean);
	}
	
	@Test
	public void beanListHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from category";
		
		List<Category> list = qr.query(sql, new BeanListHandler<>(Category.class));
		
		for (Category bean : list) {
			
			System.out.println(bean);
		}
	}
	
	@Test
	public void mapHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from category";
		
		Map<String, Object> map = qr.query(sql, new MapHandler());
		System.out.println(map);
	}
	
	@Test
	public void mapListHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from category";
		
		List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void scalarHandler() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select count(*) from category";
		
		Object obj = qr.query(sql, new ScalarHandler());
		System.out.println(obj.getClass().getName());
	}
	
}
