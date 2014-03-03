<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<%@include file="./rich_client.jsp" %>
</head>
<body>
<form action="ckEditor.do" method="post">
	<textarea name="textarea1">
	<%=request.getAttribute("value") %>
	</textarea>
	
	<input type="submit" value="提交">
</form>
<script type="text/javascript" src="./index.js"></script>
</body>
</html>