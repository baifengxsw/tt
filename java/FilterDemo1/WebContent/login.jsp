<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
用户名 <input type = "text" name = "username"><br>
密    码 <input type = "password" name = "password"><br>
	<input type = "checkbox" name = "auto-login">自动登录<br>   
<input type = "submit" value = "提交">
</form>
</body>
</html>