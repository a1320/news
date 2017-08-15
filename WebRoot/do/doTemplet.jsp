<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
//设置编码格式，解决post的乱码问题
request.setCharacterEncoding("utf-8");
//获取请求参数
//封装业务方法参数
//调用业务方法，获取结果
//跟进跳转方式及业务需要，把业务方法的返回结果设置到某个作用域
//跳转页面（一般情况查询使用转发，其他操作使用重定向）
//根据调用结果确定跳转页面（页面的地址＋跳转的方式）

%>

String path = request.getContextPath();<br/>
//设置编码格式，解决post的乱码问题<br/>
request.setCharacterEncoding("utf-8");<br/>
//获取请求参数<br/>
//封装业务方法参数<br/>
//调用业务方法，获取结果<br/>
//跟进跳转方式及业务需要，把业务方法的返回结果设置到某个作用域<br/>
//跳转页面（一般情况查询使用转发，其他操作使用重定向）<br/>
//根据调用结果确定跳转页面（页面的地址＋跳转的方式）<br/>
<h1>http://192.168.99.118:8888/news/do/doTemplet.jsp</h1>
