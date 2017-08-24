<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
	.ulone li{font-size: 22px}
</style>
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
	<a href="<%=path%>/jstl-1.2.jar">jstl1.2</a>
	
	${1+1 }
	<%
		request.setAttribute("path1", "requestPath");
		pageContext.setAttribute("path1", "pagePath");
		session.setAttribute("path", "sessionPath");
		Object test = request.getAttribute("test");
		UserInfo info = new UserInfo();
		info.setId(2);
		info.setName("accp");
		info.setCreateDate(new Date());
		request.setAttribute("user", info);
		request.setAttribute("user.name", "t06");
		List<UserInfo> userList = new ArrayList<UserInfo>();
		userList.add(info);
		request.setAttribute("userList", userList);
		Map<String,String> map = new HashMap<String,String>();
		map.put("one", "1");
		map.put("two", "2");
		session.setAttribute("map", map);
	%>
	<ul class="ulone">
		<li><%=test %></li>
		<li>自动从page－》request－》session－－》application 作用域名查找"\${path}"：${path}</li>
		<li>指定获取request作用域\${requestScope.path}：${requestScope.path}</li>
		<li>指定获取session作用域\${sessionScope.path}：${sessionScope.path}</li>
		<li>指定获取application作用域\${applicationScope.path}：${applicationScope.path}</li>
		<li>获取某个对象的属性\${user.id}:${user.id}</li>
		<li>${user.createDate}</li>
		<li>获取某个对象对应的get＊＊＊方法\${user.test}：${user.test}</li>
		<li>获取键包含.或者－的值必须使用[ ]方式\${requestScope['user.name']}：${requestScope['user.name']}</li>
		<li>获取List集合的方式\${userList[0].name }：${userList[0].name }</li>
		<li>获取map集合的方式\${map["one"] }\${map.two}：${map["one"] }${map.two}</li>
		<li>${user.name!="accp"}</li>
		<li>${map.one<map.two }</li>
		<li>${user.name=="accp"||map.one!=1 }</li>
		<li>${empty user}</li>
		<li>${param.name}</li>
		<li>${paramValues.love[1]}</li>
		<li>${pageContext.request.method}</li>
	</ul>
	<c:forEach  items="${userLists}" var="info" step="2" varStatus="vs">
		${vs.index}:${info.name}
	</c:forEach>
	<c:forEach items="${map}" var="info">
		${info.key}:${info.value}
	</c:forEach>
	<br/>
	<c:if test="${user.name!='accp'}">
		hello
	</c:if>
	<c:choose>
		<c:when test="${user.name!='accp'}">${user.name!='accp'}</c:when>
		<c:when test="${map.one==1 }">\${map.one!=1 }</c:when>
		<c:otherwise>默认</c:otherwise>
	</c:choose>
	<%
		for(int i=1;i<=10;i=i+2){
			
		}
	
		if(true){
			
		}
	%>
</body>
</html>