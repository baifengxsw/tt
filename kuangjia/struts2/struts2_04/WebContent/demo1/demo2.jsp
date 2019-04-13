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
<s:debug></s:debug>
<s:property value="user.username"/>
<s:property value="user.password"/>

<s:property value="map['one'].username"/>
<s:property value="map['one'].password"/>
<s:property value="map['two'].username"/>
<s:property value="map['two'].password"/>

<s:iterator var="i" value="{'aa','bb','cc'}">

	<s:property value="i"/>------<s:property value="#i"/>
</s:iterator>
</body>
</html>
