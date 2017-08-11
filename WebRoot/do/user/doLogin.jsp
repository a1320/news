<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	request.setCharacterEncoding("utf-8");
	//获取用户名
	String name = request.getParameter("name");
	//获取密码
	String pwd = request.getParameter("pwd");
	//根据用户名和密码查看是否存在该用户
	if(!"".equals(name)){
		//如果存在，把用户信息存放到session
		UserInfo user = new UserInfo();
		user.setName(name);
		session.setAttribute("user", user);
		//session.setMaxInactiveInterval(10);
		//重定向到指定页面（跳转到首页）
		response.sendRedirect(path+"/index.jsp");
		return;
	}
	response.sendRedirect(path+"/login.jsp");
	return;
%>