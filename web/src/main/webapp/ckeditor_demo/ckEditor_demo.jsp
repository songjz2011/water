<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="../static/components/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../static/test/ckeditor_config.js"></script>
</head>
<body>
<form action="ckEditor.do" method="post">
	<textarea name="textarea1">
	<%=request.getAttribute("value") %>
	</textarea>
	<input type="button" value="查看数据" onclick="viewData();">
	<br>
	
	<input type="submit" value="提交">
</form>
<script type="text/javascript" src="./ckEditor_demo.js"></script>
</body>
</html>