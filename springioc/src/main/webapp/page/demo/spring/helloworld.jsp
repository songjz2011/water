<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring mvc demo</title>
</head>
<body>
	hello啊，
	<c:choose>
		<c:when test="${empty name}">
			没有名字耶
		</c:when>
		<c:otherwise>
			${name}
		</c:otherwise>
	</c:choose>
</body>
<script type="text/javascript">
$(document).ready(function() {
	alert("oy");
});
</script>
</html>