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
<h1>struts2的OGNL 的入门</h1>
<h3>调用对象的方法</h3>
<s:property value="'struts2'.length()"/>
<h3>调用对象的静态方法</h3>
<s:property value="@java.lang.Math@random()"/>
<h3>调用对象的相关对象</h3>
</body>
</html>
