<%@page import="com.gdglc.news.dao.user.impl.UserDaoImpl"%>
<%@page import="com.gdglc.news.dao.user.IUserDao"%>
<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
//设置编码格式，解决post的乱码问题
request.setCharacterEncoding("utf-8");
//获取请求参数
String name = request.getParameter("name");
String idStr = request.getParameter("id");
//封装业务方法参数
UserInfo info = new UserInfo();
info.setName(name);
Integer id = Integer.parseInt(idStr);
info.setId(id);
//调用业务方法，获取结果
IUserDao dao = new UserDaoImpl();
try{
	dao.update(info);
}catch(Exception e){
	e.printStackTrace();
	//根据业务需要进行页面跳转，并return该页面
	return;
}
//跟进跳转方式及业务需要，把业务方法的返回结果设置到某个作用域
//跳转页面（一般情况查询使用转发，其他操作使用重定向）
//根据调用结果确定跳转页面（页面的地址＋跳转的方式）
response.sendRedirect(path+"/do/user/doShowList.jsp");
//request.getRequestDispatcher("/do/user/doShowList.jsp").forward(request, response);
%>