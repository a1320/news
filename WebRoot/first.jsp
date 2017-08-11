<%@page import="com.gdglc.news.MyAdd"%>
<%@page import="java.util.ArrayList,java.util.Date"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp页面</title>
</head>
<body>
首页
<!-- 客户端可以看到 -->
<%--客户端看不到 --%>
<%!
	static{
		System.out.println("first");
	}
	int y = 10;
	int add(int x,int y){
		return x+y;
	}
%>
<%
	request.setAttribute("path", request.getContextPath());
%>
<%--@include 是指令，使用它做页面引用时，
容器会把2个jsp页面合成一个java类，
如被引用页面改变，
那么引用它的全部页面都要
从新进行翻译＋编译的过程 --%>
<%-- <%@include file="/t3/checkLogin.jsp" %> --%>
<%--jsp:include jsp的include动作，使用该方式不会合并为一个java文件，采用的是把目标文件内容加入到该页面的out流中输出，只能引用内部资源 --%>
<jsp:include page="/t3/checkLogin.jsp"></jsp:include>
<%
	//小脚本，可以写任意java代码，一切在java类里面可以写的东西，在这里都可以写
	int a = 1+2;
	Date date = new Date();
	ArrayList list = new ArrayList();
	MyAdd add = new MyAdd();
	int result = add.add(7, 9);
%>
<%=a %>
<%=date %>
<%=add.add(7, 9) %>
<%=result %>
<br/>
y:<%=y %>
<br/>
add(3,5):<%=add(3,5) %>
</body>

</html>