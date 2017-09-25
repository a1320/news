<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	session.setAttribute("user", "accp");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax测试</title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		//alert(1);
	});
	function myAjax(){
		//请求地址
		var url = "${path}/ajax";
		//请求参数
		var params = $('#ajaxForm').serialize();
		console.info(params)
		$.post(url,params,function($data){
			//执行成功返回的回调函数
			//alert("响应成功")
			console.info($data);
			$('#info').html($data);
		},"html")
	}
</script>
</head>
<body>
	<form action="" id="ajaxForm">
		<input type="text" name="name" />
		<input type="text" name="age"/>
	</form>
	<input type="button" value="加载" onclick="myAjax();"/>
	<div id="info">
		
	</div>
</body>
</html>