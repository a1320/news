<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细信息</title>
</head>
<%


%>
<body>
	<form action="${path}/do/user/doUpdate.jsp" method="post">
		<input type="hidden" name="id" value="${info.id}">
		<label>用户名：</label>
		<input type="text" name="name" value="<c:out value="${info.name}"/>"/>
		<br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>