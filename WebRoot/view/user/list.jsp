<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<%
	List<UserInfo> userList = (List<UserInfo>)request.getAttribute("userList");
%>
<%=userList.size() %>
<table border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>序号</th>
			<th>用户名</th>
		</tr>
	</thead>
	<tbody>
		<%
			for(int i=0;i<userList.size();i++){
				UserInfo info = userList.get(i);%>
				<tr>
					<td><%=i+1 %></td>
					<td><%=info.getName()%></td>
				</tr>
			<%}
		%>
	</tbody>
</table>
</body>
</html>