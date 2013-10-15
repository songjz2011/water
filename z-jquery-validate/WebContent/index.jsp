<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="./js/validate.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="./js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="./js/jquery.form.js"></script>
	<script type="text/javascript" src="./js/jquery.validate.js"></script>
</head>
<body>
	<form id="set_form" action="">
		用户名：
		<input type="text" name="userName">
		<br>
		隐藏域：
		<input type="hidden" name="userHidden">
		<br>
		选择select：
		<select name="userSelect" size="3">
			<option>1111</option>
			<option>2222</option>
			<option>3333</option>
			<option>4444</option>
		</select>
		<br>
		checkbox选项：
		<input type="checkbox" name="userCheckbox">check_1
		<input type="checkbox" name="userCheckbox">check_2
		<input type="checkbox" name="userCheckbox">check_3
		
		<br><br>
		<input type="submit" value="提交">
	</form>
</body>
<script type="text/javascript">
$(document).ready(function() {
	$("#set_form").validate({
		rules: {
			userName: {
				required: true,
				maxlength: 20
			},
			userSelect: {
				required: true
			},
			userCheckbox: "required"
		},
		messages: {
			userName: {
				required: "不能为空",
				maxlength: "不能超过20个字符"
			},
			userSelect: "不能为空",
			userCheckbox: "不能为空"
		}
	});
});
</script>
</html>