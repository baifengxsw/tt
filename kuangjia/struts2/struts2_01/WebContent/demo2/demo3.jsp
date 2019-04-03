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
<a href="${pageContext.request.contextPath}/customer!find.action">查询客户</a><br>
<a href="${pageContext.request.contextPath}/customer!update.action"">修改客户</a><br>
<a href="${pageContext.request.contextPath}/customer!delete.action"">删除客户</a><br>
<a href="${pageContext.request.contextPath}/customer!save.action"">添加客户</a><br>
</body>
</html>
