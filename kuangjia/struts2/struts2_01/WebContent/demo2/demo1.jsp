<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
<h1>Action的访问 通过method的方式</h1>
<a href="${pageContext.request.contextPath}/userFind.action">查询用户</a><br>
<a href="${pageContext.request.contextPath}/userUpdate.action"">修改用户</a><br>
<a href="${pageContext.request.contextPath}/userDelete.action"">删除用户</a><br>
<a href="${pageContext.request.contextPath}/userSave.action"">添加用户</a><br>
</body>
</html>
