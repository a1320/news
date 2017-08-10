<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	//该页面称为控制器，他负责空能如下：
	//1、接受请求参数
	//设置post的请求参数编码，一般都写在当前页面的第一句
	request.setCharacterEncoding("utf-8");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	//获取多个重名参数时候使用的方法，返回一个数组
	String[] loves =  request.getParameterValues("loves");
	//2、规则检查
	if(null!=name&&name.equals("sa")){
		//不让注册
		request.getRequestDispatcher("/t2/error.jsp").forward(request, response);
	}
	//3、封装业务参数，调用业务方法，完成业务操作
	System.out.println("业务操作完成");
	//决定显示页面及显示方式（转发和重定向,转发只应该使用在查询功能，重定向在数据持久化（增，删，改）时使用）
	//request.getRequestDispatcher("/t2/detail.jsp").forward(request, response);
	
	response.sendRedirect(path+"/t2/detail.jsp?name="+name+"&pwd="+pwd+"&loves=1&loves=2");
%>
	
	