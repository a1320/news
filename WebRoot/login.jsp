<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
<%
	String path = request.getContextPath();
	System.out.println("进入登陆页面");
%>
	<form action="${path}/do/user/doLogin" method="post">
		<label for="name">用户名：</label>
		<input id="name" type="text" name="name"/>
		<label for="pwd">密码：</label>
		<input id="pwd" type="text" name="pwd"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>