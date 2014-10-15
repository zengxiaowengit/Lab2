
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>详细信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	登录用户:
	${usernameMsg }
	<br>


	<div align="center">
		<h1>欢迎来到我的图书馆!</h1>
		<s:form>
			<table border="1">
				<tr>
					<th colspan="7">详细信息<br>
					</th>
				</tr>
				<tr>
					<th width="300">书名</th>
					<th width="100">ISBN<br>
					</th>
					<th width="200">作者ID</th>
					<th width="200">出版日期</th>
					<th width="200">出版社</th>
					<th width="100">价格</th>
					<th width="200">操作</th>
				</tr>
				<c:forEach items="${requestScope.titleQuery}" var="listAll">
					<tr>
						<td align="center">${listAll.title }</td>
						<td align="center">${listAll.isbn }</td>
						<td align="center">${listAll.authorID }</td>
						<td align="center">${listAll.publishDate }</td>
						<td align="center">${listAll.publisher }</td>
						<td align="center">${listAll.price }</td>
						<td><a href="delete!delete.action?title=${listAll.title}">删除</a>
						<font color="red">${deleteMsg}</font>
						</td>
					</tr>
				</c:forEach>
			</table>
		</s:form>
	</div>
</body>
</html>
