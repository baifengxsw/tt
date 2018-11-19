<%@page import="cn.itcast01_ceshi.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

<c:set var="name" value="xiashuangwu"></c:set>  //默认存储在pageContent
${name }

<h3>选择其它域进行存储</h3><br>
<c:set var="name" value="xiashuangwu" scope="session"></c:set> 
<br> ${sessionScope.name }
<br> ____________________________<br>
进行判断<br>
<c:set var="age" value="18"></c:set><br>
<c:if test="${age>16 }"><h3 ><font color="red">对不起,你大于16,禁止参加本场考试 </font></h3></c:if>


<%
	List list = new ArrayList();
	list.add(new User("xia",15));
	list.add(new User("wang",15));
	list.add(new User("wu",15));
	list.add(new User("shui",15));
	pageContext.setAttribute("listl",list);
	



%>
<c:forEach var="user" items="${listl }">
${ user.name} -------${user.age}
</c:forEach>
	
</body>
</html>