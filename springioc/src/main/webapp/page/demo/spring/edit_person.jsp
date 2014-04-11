<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object obj = request.getAttribute("errors");
	System.out.println("obj = " + obj);
%>
<form action="${_ctx}/spring-demo/validator" method="post">
	姓名：<input name="name" type="text">
	<br>
	年龄：<input type="text" name="age">
	<br>
	公司：<input type="text" name="company">
	<br>
	角色：<input type="text" name="role">
	<br>
	创建时间：<input type="text" name="createTime">
	<br>
	更新时间：<input type="text" name="updateTime">
	<br>
	<input type="submit" value="提交">
</form>
</body>
</html>