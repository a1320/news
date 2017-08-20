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
	//application.setAttribute("count", 1);
	Integer count =(Integer)application.getAttribute("count");
	//如果是项目启动以后第一个人第一次访问，count为null
	if(null==count){
		count = 1;
		application.setAttribute("count", count);
	}else{
		count = count+1;
		application.setAttribute("count", count);
	}
	
	//application.removeAttribute("count");
%>
<body>
	访问：<%=count%> 次
	欢迎<%=user.getName() %>来到我们游戏中心<br/>
	<a href="<%=path%>/do/user/doLogout.jsp">退出</a>
	<ul>
		<li><a href="<%=path%>/do/user/doShowList.jsp">用户管理</a></li>
	</ul>
	<a href="<%=path%>/news.zip">代码下载</a>
	<a href="<%=path%>/DB.zip">练习数据库</a>
	<a href="<%=path%>/new.sql.zip">练习数据库脚本</a>
</body>
</html>