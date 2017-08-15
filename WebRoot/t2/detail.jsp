<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册完成后的用户信息</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	//获取多个重名参数时候使用的方法，返回一个数组
	String[] loves =  request.getParameterValues("loves");
	Map<String,String> loveMap = new HashMap<String,String>();
	loveMap.put("1", "篮球");
	loveMap.put("2", "足球");
	
%>
<ul>
		<li>用户名：<%=name%></li>
		<li> 密码：<%=pwd %></li>
		<li>
			爱好：
			<%
				if(null!=loves){
					for(int i=0;i<loves.length;i++){%>
						<%=loveMap.get(loves[i])%>
				<%}
				}
			%>
		</li>
		<li>
		爱好2:
		<%
			if(null!=loves){
				for(int i=0;i<loves.length;i++){
					if("1".equals(loves[i])){%>
						篮球
					<%}else{%>
						足球
					<%}
				}
			}
			%>
		</li>
	</ul>
	
</body>
</html>