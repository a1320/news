<%@page import="com.gdglc.news.domain.user.UserInfo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<a href="${path}/view/user/add.jsp">新增</a>
<table border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pageInfo.list}" var="info" varStatus="vs">
			<%-- <c:if test="${vs.index%2==0}">
				<tr>
			</c:if>
			<c:if test="${vs.index%2!=0}">
				<tr style="background-color: red">
			</c:if> --%>
			<%-- <c:choose>
				<c:when test="${vs.index%2==0}"><tr></c:when>
				<c:otherwise><tr style="background-color: red"></c:otherwise>
			</c:choose> --%>
			<tr
				<c:if test="${vs.index%2==0}">
					style="background-color: red"
				</c:if>
			>
				<td>${vs.index+1}</td>
				<td><c:out value="${info.name}" escapeXml="true"/></td>
				<td>
					<a href="${path}/do/user/doDel.jsp?id=${info.id}">删除</a>
					<a href="${path}/do/user/doShowInfo.jsp?id=${info.id}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
当前页【${pageInfo.currentPage}/${pageInfo.totalPage}】
<c:choose>
	<c:when test="${pageInfo.currentPage==1}">
	首页
    上一页 
	</c:when>
	<c:otherwise>
		<a href="${path}/do/user/doShowList?currentPage=1">首页</a> 
		<a href="${path}/do/user/doShowList?currentPage=${pageInfo.currentPage-1}">上一页 </a>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${pageInfo.currentPage==pageInfo.totalPage}">
		下一页
		末页
	</c:when>
	<c:otherwise>
		<a href="${path}/do/user/doShowList?currentPage=${pageInfo.currentPage+1}">下一页 </a>
		<a href="${path}/do/user/doShowList?currentPage=${pageInfo.totalPage}">末页</a>
	</c:otherwise>
</c:choose>
<%-- <c:if test="${pageInfo.currentPage==1}">
	首页
    上一页 
</c:if>
<c:if test="${pageInfo.currentPage!=1}">
	<a href="${path}/do/user/doShowList?currentPage=1">首页</a> 
	<a href="${path}/do/user/doShowList?currentPage=${pageInfo.currentPage-1}">上一页 </a>
</c:if> --%>
<%-- <c:if test="${pageInfo.currentPage==pageInfo.totalPage}">
	下一页
	末页
</c:if>
<c:if test="${pageInfo.currentPage!=pageInfo.totalPage}">
	<a href="${path}/do/user/doShowList?currentPage=${pageInfo.currentPage+1}">下一页 </a>
	<a href="${path}/do/user/doShowList?currentPage=${pageInfo.totalPage}">末页</a>
</c:if> --%>

</body>
</html>