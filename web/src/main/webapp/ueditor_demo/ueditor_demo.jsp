<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="../static/components/jquery/jquery-1.11.0.js"></script>
<script type="text/javascript" charset="utf-8" src="../static/components/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../static/components/ueditor/ueditor.all.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="../static/components/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<script id="noticeContent" name="noticeContent" type="text/plain"></script>
</body>
<script type="text/javascript">
$(document).ready(function() {
	var editor = UE.getEditor("noticeContent");
});
</script>
</html>