<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>使用作用域存储值</h2>
<%
	request.setAttribute("name", "request");
	pageContext.setAttribute("name","pageContext");
	session.setAttribute("name", "session");
	application.setAttribute("name", "application");
	
%>

<h1>使用作用域取出值</h1>
<%=request.getAttribute("name") %>
<%=pageContext.getAttribute("name") %>
<%=session.getAttribute("name") %>
<%=application.getAttribute("name") %><br>
<%
	response.setContentType("text/html;charset=UTF-8");
	out.write("sfdsf夏双武");
%>

</body>
</html>