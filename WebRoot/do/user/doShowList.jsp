<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@page import="java.util.*"%>
<%@page import="com.gdglc.news.dao.user.impl.UserDaoImpl"%>
<%@page import="com.gdglc.news.dao.user.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//设置编码格式，解决post的乱码问题
	request.setCharacterEncoding("utf-8");
	//获取请求参数
	//封装业务方法参数
	//调用业务方法，获取结果
	IUserDao dao = new UserDaoImpl();
	List<UserInfo> userList = dao.findList();
	//把userList添加到了request作用域，也可以理解为在request对象中添加了额外属性
	request.setAttribute("userList", userList);
	//List<UserInfo> userList = dao.findList();
	//根据调用结果确定跳转页面（页面的地址＋跳转的方式）
	request.getRequestDispatcher("/view/user/list.jsp").forward(request, response);
%>