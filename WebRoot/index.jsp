<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<%@include file="/view/common/checkLogin.jsp" %>
<%
	//UserInfo loginUser = (UserInfo)session.getAttribute("user");
%>
<body>
	欢迎<%=user.getName() %>来到我们游戏中心<br/>
	<a href="<%=path%>/do/user/doLogout.jsp">退出</a>
	<ul>
		<li><a href="<%=path%>/do/user/doShowList.jsp">用户管理</a></li>
	</ul>
</body>
</html>