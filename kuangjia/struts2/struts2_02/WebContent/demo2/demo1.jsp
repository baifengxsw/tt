<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts</title>
</head>
<body>
<h1>struts2的数据封装</h1>
<h3>方式一，提供set方法的方式</h3>
<form action="${pageContext.request.contextPath}/userAction1.action" method="post">
	用户名:<input type="text" name ="username"/><br>
	密 码:<input type="password" name ="password"/><br>
	年 龄:<input type="text" name ="age"/><br>
	生 日:<input type="text" name ="birthday"/><br>
	工 资:<input type="text" name ="salary"/><br>
	<input type="submit" value="提交">
</form>
<h1>方式二 ，在页面上提供一种特殊的表达式</h1>
<form action="${pageContext.request.contextPath}/userAction2.action" method="post">
	用户名:<input type="text" name ="user.username"/><br>
	密 码:<input type="password" name ="user.password"/><br>
	年 龄:<input type="text" name ="user.age"/><br>
	生 日:<input type="text" name ="user.birthday"/><br>
	工 资:<input type="text" name ="user.salary"/><br>
	<input type="submit" value="提交">
</form>
<h3>方式3，提供模型驱动的方式</h3>
<s:fielderror></s:fielderror>
<form action="${pageContext.request.contextPath}/userAction3.action" method="post">
	用户名:<input type="text" name ="username"/><br>
	密 码:<input type="password" name ="password"/><br>
	年 龄:<input type="text" name ="age"/><br>
	生 日:<input type="text" name ="birthday"/><br>
	工 资:<input type="text" name ="salary"/><br>
	<input type="submit" value="提交">
</form>

</body>
</html>
