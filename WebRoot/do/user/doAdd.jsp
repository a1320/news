<%@page import="java.net.URLEncoder"%>
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
//服务器端验证请求参数合法性
if(null==name){
	System.out.println("用户名为null");
	//直接重定向到某个错误页面
	return;
}
//字符串要进行去前后空格操作
name = name.trim();
if("".equals(name)){
	System.out.println("用户名为空字符串");
	//如果前端已经使用了javascript来进行了提交参数的检查，则跳转到错误页面或者直接return
	return;
}
//封装业务方法参数
UserInfo info = new UserInfo();
info.setName(name);
//调用业务方法，获取结果
IUserDao dao = new UserDaoImpl();
try{
	dao.add(info);
}catch(Exception e){
	//记录日志
	e.printStackTrace();
	String errorMessage = e.getMessage();
	session.setAttribute("error", errorMessage);
	session.setAttribute("info", info);
	//根据业务需要进行页面跳转，并return该页面
	response.sendRedirect(path+"/view/user/add.jsp");
	return;
}
//跟进跳转方式及业务需要，把业务方法的返回结果设置到某个作用域
//跳转页面（一般情况查询使用转发，其他操作使用重定向）
//根据调用结果确定跳转页面（页面的地址＋跳转的方式）
response.sendRedirect(path+"/do/user/doShowList");
//request.getRequestDispatcher("/do/user/doShowList.jsp").forward(request, response);
%>