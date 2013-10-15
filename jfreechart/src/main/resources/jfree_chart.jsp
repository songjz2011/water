<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.tsingsoft.com.cn/taglib" prefix="ts"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>电网多选demo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<ts:root/>/css/table.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<ts:root/>/js/jquery.min.js"></script>
  </head>
  <body>
  	<table width="98%" align="center" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td height="25" class="biaodan-q" align="left">&nbsp;&nbsp;
				当前位置 : 电网多选demo
			</td>
		</tr>
	</table>
	
	<table width="98%" align="center" border="0" cellspacing="0"
			cellpadding="2" class="input_outtable">
		<tr>
			<td width="25%">
				<table width="100%" border="0" cellspacing="0" cellpadding="2" class="input_innertable">
					<tr>
						<td width="10%"  height="25" class="biaodan-top">曲线：</td>
						<td width="16%" height="25" class="biaodan-q" style="padding: 20px;">
							<ts:chart chartPara="${lineChartPara}"/>
						</td>
					</tr>
					<tr>
						<td width="10%"  height="25" class="biaodan-top">柱状图：</td>
						<td width="16%" height="25" class="biaodan-q" style="padding: 20px;">
							<ts:chart chartPara="${barChartPara}"/>
						</td>
					</tr>
					
					
					<tr>
						<td colspan="2" align="center">
							<input id="set_butt" name="set_butt" type="button" class="butt" 
								value="设 置" onclick="javascript:alert('设置成功');"/>
							<input type="button" class="butt" 
								value="返 回" onclick="goBack();"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
  </body>
  <script type="text/javascript">
 	function goBack() {
 		history.back();
 	}
  </script>
</html>
