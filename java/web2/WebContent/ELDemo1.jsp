<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- 1.0版本不支持EL表达式 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL 表达式 -->
<% 
	pageContext.setAttribute("name","page");
	request.setAttribute("name","request");
	session.setAttribute("name","session");
	application.setAttribute("name","application");
%>
<h3>按普通方式取值</h3><br>
<%=pageContext.getAttribute("name") %><br>
<%=request.getAttribute("name") %><br>
<%=session.getAttribute("name") %><br>
<%=application.getAttribute("name") %><br>
<h3>使用EL表达式去取出值</h3><br>
${  pageScope.name}<br>
${  requestScope.name}<br>
${  sessionScope.name}<br>
${  applicationScope.name}<br>

<h1>--------------------</h1>
<!-- 存取数组对象 -->
<% String [] a = {"aa","bb","cc"}; %>
<% pageContext.setAttribute("array",a); %>
<!-- EL 取出数据 -->
${array[0]},${array[1]},${array[2] }
</body>
</html>