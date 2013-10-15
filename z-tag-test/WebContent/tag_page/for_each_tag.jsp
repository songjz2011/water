<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.web.things.tag.test.entity.*"%>
<%@ taglib uri="http://www.webthing.com.cn/taglib" prefix="webthings"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Company comp = new Company();
	comp.setName("huayuan");

	Contact contact1 = new Contact();
	contact1.setName("bar ,foo");
	contact1.setEmail("dd@tsinghua.eud.cn");
	contact1.setPhone("2975349875");
	contact1.setComment("java programe");

	Contact contact2 = new Contact();
	contact2.setName("bar ,foo");
	contact2.setEmail("dd@tsinghua.eud.cn");
	contact2.setPhone("2975349875");
	contact2.setComment("java programe");

	Contact contact3 = new Contact();
	contact3.setName("bar ,foodf");
	contact3.setEmail("dd@tsinghua.euddfdf.cn");
	contact3.setPhone("2975349875dd");
	contact3.setComment("java progrdfame");

	comp.addContact(contact1);
	comp.addContact(contact2);
	comp.addContact(contact3);
	request.setAttribute("company", comp);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="company" scope="request"
		type="com.web.things.tag.test.entity.Company" />
	<font size=+2>我的一些和<b> <jsp:getProperty name="company"
				property="name" /> 公司联系
	</b>
	</font>

	<table border=1>
		<tr>
			<td>姓名</td>
			<td>电话</td>
			<td>email</td>
			<td>备注</td>
		</tr>
		<webthings:foreach name="contact"
			type="com.web.things.tag.test.entity.Company"
			collection="<%=company.getContactList()%>">
			<tr>
				<td>
					<jsp:getProperty name="contact" property="name"/>
				</td>
				<td>
					<jsp:getProperty name="contact" property="phone"/>
				</td>
				<td>
					<jsp:getProperty name="contact" property="email"/>
				<td>
					<jsp:getProperty name="contact" property="comment"/>
				</td>
			</tr>
		</webthings:foreach>
	</table>
	<hr>
</body>
</html>