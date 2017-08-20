package com.gdglc.news.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://192.168.99.132:1433;databaseName=test","sa","laojiehua");
			System.out.println(connection);	
		} catch (Exception e) {
			// todo Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
