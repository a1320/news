<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//获取登录用户信息
	UserInfo user = (UserInfo)session.getAttribute("user");
	//如果不存在用户信息，跳转到登录页面
	if(null == user){
		//获取cookie
		Cookie[] cookies =  request.getCookies();
		if(null!=cookies){
			for(Cookie cookie:cookies){
				if("userName".equals(cookie.getName())){
					//进行登录验证
					response.sendRedirect(path+"/do/user/doLogin.jsp?name="+cookie.getValue());
					return;
				}
			}
		}
		response.sendRedirect(path+"/login.jsp");
		return;
	}
%>