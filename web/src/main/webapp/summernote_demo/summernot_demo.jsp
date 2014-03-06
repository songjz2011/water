<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
 
<link type="text/css" rel="stylesheet" href="../static/components/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<!-- 
<link type="text/css" rel="stylesheet" href="../static/components/font_awesome/css/font-awesome.css" />
-->
<script type="text/javascript" src="../static/components/jquery/jquery-1.11.0.js"></script>
<script type="text/javascript" src="../static/components/bootstrap/js/bootstrap.min.js"></script>

<!-- 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
<script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
-->

<link type="text/css" rel="stylesheet" href="../static/components/summernote/css/summernote.css" />
<script type="text/javascript" src="../static/components/summernote/summernote.js"></script>
<script type="text/javascript" src="../static/components/summernote/lang/summernote-zh-CN.js"></script>
</head>
<body>
<form action="ckEditor.do" method="post">
	<textarea id="textarea1" name="textarea1"></textarea>
	
	<input type="submit" value="提交">
</form>
<script type="text/javascript">
$(document).ready(function() {
    $('#textarea1').summernote({
      height: 200,
      lang: 'zh-CN'
    });
    
    var data = "<p><strong>asdfsdfsdxcv</strong>,</p>";
    data += "<table border='1' cellpadding='1' cellspacing='1' style='width:500px'>"+
			"<tbody>"+
			"<tr>"+
			"	<td>asdf</td>"+
			"	<td>asd</td>"+
			"</tr>"+
			"<tr>"+
			"	<td>&nbsp;</td>"+
			"	<td>&nbsp;</td>"+
			"</tr>"+
			"<tr>"+
			"	<td>&nbsp;</td>"+
			"	<td>&nbsp;</td>"+
			"</tr>"+
		"</tbody>"+
		"</table>";
	$('#textarea1').code(data);
  });
</script>
</body>
</html>
