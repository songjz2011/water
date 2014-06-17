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
	<br>
	<input type="text" id="minpower3_3.0" value="sss">
	<br>
	<table>
		<thead>
			<th>11</th>
			<th>22</th>
			<th>33</th>
		</thead>
		<tbody id="contentTableBody">
			<tr>
				<td>aa</td>
				<td>bb</td>
				<td>cc</td>
			</tr>
			<tr>
				<td>aa</td>
				<td>bb</td>
				<td>cc</td>
			</tr>
		</tbody>
	</table>
</body>
<script type="text/javascript">
$(document).ready(function() {
	var lengh = $("#minpower3_3\\.0").length;
	
	$("#contentTableBody tr").each(function() {
		$(this).children("td").each(function(i){
			alert(i);
			if(i != 0) {
				$(this).css("text-align", "right");
			}
		});
	});
});
</script>
</html>