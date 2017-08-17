<%@page import="java.net.URLEncoder"%>
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
	if(null==name){
		return;
	}
	//根据用户名和密码查看是否存在该用户
	if(!"".equals(name)){
		//如果存在，把用户信息存放到session
		UserInfo user = new UserInfo();
		user.setName(name);
		session.setAttribute("user", user);
		//添加cookie到客户端 [id:10,name:30]
		Cookie userCookie = new Cookie("userName",URLEncoder.encode(name));
		userCookie.setMaxAge(600);
		//设置只支持http，防止页面使用js读取或修改该cookie
		userCookie.setHttpOnly(true);
		//设置有效路径 /
		userCookie.setPath(path);
		//userCookie.setDomain(pattern);
		System.out.println(userCookie.getPath()); 
		response.addCookie(userCookie);
		//session.setMaxInactiveInterval(10);
		//重定向到指定页面（跳转到首页）
		response.sendRedirect(path+"/index.jsp");
		return;
	}
	response.sendRedirect(path+"/login.jsp");
	return;
%>