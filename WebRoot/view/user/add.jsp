<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加页面</title>
</head>
<%
	String path = request.getContextPath();
	String error = (String)session.getAttribute("error");
	UserInfo info = (UserInfo)session.getAttribute("info");
	if(null==info){
		info = new UserInfo();
		info.setName("");
	}
%>
<body>
	<%
		if(null!=error){%>
			<%=error%>
		<%}
	%>
	<form action="<%=path%>/do/user/doAdd.jsp" method="post">
		<label>用户名：</label>
		<input type="text" name="name" value="<%=info.getName()%>"/>
		<br/>
		<input type="submit" value="提交">
	</form>
	<%
		session.removeAttribute("error");
		session.removeAttribute("info");
	%>
</body>
</html>