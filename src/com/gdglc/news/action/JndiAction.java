package com.gdglc.news.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdglc.news.dao.user.BaseDao;

public class JndiAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BaseDao dao = new BaseDao();
		Connection connection = dao.getConnection();
		if(null!=connection){
			try {
				connection.close();
			} catch (SQLException e) {
				// todo Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// todo Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	public void init() throws ServletException {
		try {
			//获取jndi上下文
			Context context = new InitialContext();
			//根据名称获取资源
			Integer age = (Integer)context.lookup("java:comp/env/age");
			System.out.println("age:"+age);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
}
