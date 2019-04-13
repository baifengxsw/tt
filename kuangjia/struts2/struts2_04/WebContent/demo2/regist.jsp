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
<h1>struts2后台 注册的校验</h1>
<form action="${pageContext.request.contextPath }/registAction.action" method = "post">
	用户名:<input type="text" name="username" /><br>
	密码:<input type="password" name="password" /><br>
	确认密码:<input type="password" name="repassword" /><br>
	年龄:<input type="text" name="age" /><br>
	电话:<input type="text" name="phone" /><br>
	生日:<input type="text" name="birthday" /><br>
	<input type="submit" value="提交"><br>

	<s:fielderror></s:fielderror>
</form>

</body>
</html>
