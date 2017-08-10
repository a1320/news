<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<%-- <%@include file="/t3/checkLogin.jsp" %> --%>
<jsp:include page="/t3/checkLogin.jsp"></jsp:include>
<body>
	<%
		out.write("abc");
		out.println("accp");
		//获取到当前请求的上下文路径
		String path = request.getContextPath();
	%>
	path:<%=path%>
	<form action="<%=path%>/t2/addInfo.jsp" method="get">
		<label for="name">用户名：</label>
		<input id="name" type="text" name="name"/>
		<label for="pwd">密码：</label>
		<input id="pwd" type="text" name="pwd"/>
		爱好：
		<input type="checkbox" name="loves" value="1"/>篮球
		<input type="checkbox" name="loves" value="2"/>足球
		<br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>