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
<h1>struts2后台校验</h1>
<form action="${pageContext.request.contextPath }/loginAction1.action" method="post">

		用户名:<input type="text" name = "username"><br/>
		密    码:<input type="password" name="password"><br/>
		<input type="submit" value="提交">
		</form>

<s:fielderror></s:fielderror>

</body>
</html>
