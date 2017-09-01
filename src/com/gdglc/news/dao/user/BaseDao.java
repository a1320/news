package com.gdglc.news.dao.user;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class BaseDao {
	static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/myDb");
		} catch (NamingException e) {
			e.printStackTrace();
		}	
	}
	
	public BaseDao() {
		
	}
	
	public Connection getConnection(){
		try {
			if(null!=dataSource){
				Connection connection = dataSource.getConnection();
				System.out.println(connection);
				System.out.println(dataSource);
				BasicDataSource ds = (BasicDataSource)dataSource;
				System.out.println("当前活动的连接:"+ds.getNumActive());
				System.out.println("当前空闲的连接:"+ds.getNumIdle());
				return connection;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
