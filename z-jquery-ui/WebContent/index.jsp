<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="./component/jquery-ui-progressbar.css" />
<script type="text/javascript" src="./component/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./component/jquery.ui.core.js"></script>
<script type="text/javascript" src="./component/jquery.ui.widget.js"></script>
<script type="text/javascript" src="./component/jquery.ui.progressbar.js"></script>
</head>
<body>
	<div id="progressbar" style="width: 100%; height: 15px;text-align: center;"></div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#progressbar").progressbar({ value: 25 });
		$("#progressbar").progressbar("value", 50);
		//$("#progressbar").progressbar({ disabled: true });
	});
</script>
</body>
</html>