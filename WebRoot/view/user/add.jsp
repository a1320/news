<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加页面</title>
</head>
<body>
	${error}
	<form action="${path}/do/user/doAdd.jsp" method="post">
		<label>用户名：</label>
		<input type="text" name="name" value="${info.name}"/>
		<br/>
		<input type="submit" value="提交">
	</form>
	<c:remove var="error" scope="session"/>
	<c:remove var="info" scope="session"/>
</body>
</html>