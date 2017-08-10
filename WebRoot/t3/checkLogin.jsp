<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//获取登录用户信息
	String user = (String)session.getAttribute("user");
	//如果不存在用户信息，跳转到登录页面
	if(null == user){
		response.sendRedirect(path+"/login.jsp");
		return;
	}
%>
