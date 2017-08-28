<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
	<form action="${path}/upload" method="post" enctype="multipart/form-data">
		<label>用户名：</label>
		<input type="text" name="name" value="${info.name}"/>
		<input type="text" name="name" value="1234"/>
		<br/>
		<label>附件：</label>
		<input type="file" name="uploadFile"/>
		<input type="file" name="uploadFile"/>
		<br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>