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
	String path = request.getContextPath();
	List<UserInfo> userList = (List<UserInfo>)request.getAttribute("userList");
	System.out.println(userList);
%>
<%=userList.size() %>
<a href="<%=path%>/view/user/add.jsp">新增</a>
<table border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<%
			if(null!=userList){
				int i = 0;
				for(UserInfo info:userList){%>
					<tr>
						<td><%=i+1 %></td>
						<td><%=info.getName() %></td>
						<td>
							<a href="<%=path%>/do/user/doDel.jsp?id=<%=info.getId()%>">删除</a>
							<a href="<%=path%>/do/user/doShowInfo.jsp?id=<%=info.getId()%>">修改</a>
						</td>
					</tr>
				<%i++;
			}
			
			}
		%>
		
	</tbody>
</table>

</body>
</html>