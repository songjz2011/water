<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./tag_page/hello_tag.jsp">hello_tag</a>
	<br>
	<br>
	<a href="./tag_page/hello_support_tag.jsp">hello_support_tag</a>
	<br>
	<br>
	<a href="./tag_page/hello_body_tag.jsp">hello_body_tag</a>
	<br>
	<br>
	<a href="./tag_page/if_out_tag.jsp">if_out_tag</a>
	<br>
	<br>
	<a href="./tag_page/for_each_tag.jsp">for_each_tag</a>
	<br>
	<br>
	<a href="./tag_page/hello_simple_support_tag.jsp">hello_simple_support_tag</a>
	<br>
	<br>
	<a href="./tag_page/dynamic_tag.jsp">dynamic_tag</a>

	<br>
	<br>
	<a href="<%=contextPath%>/hello">hello_controller</a>
</body>
</html>