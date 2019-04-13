<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD id=Head1>
<TITLE>模板</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="css/Style.css" type=text/css rel=stylesheet>
<LINK href="css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<h1>UI标签</h1>
<h3>传统表单</h3>
<form action="" method="post">
	用户名 <input type="text" name = "username"/>
	密码 <input type="password" name="password"/>
	性别<input type="radio" name="sex" value="男">男
		<input type="radio" name="sex" value="女">女
		
	籍贯：<select name="city">
		<option value="">-请选择-<option>
		<option value="北京">北京<option>
		<option value="上海">上海<option>
		<option value="南京">南京<option>
		<option value="深圳">深圳<option>
		</select>
		<br>
	爱好<input type="checkbox" name="hobby" value="basketball" />篮球
	<input type="checkbox" name="hobby" value="pingpang" />乒乓球
	<input type="checkbox" name="hobby" value="football" />足球
		
	</form>
	
<h3>struts2的表单</h3>

<s:form action="" method="post" >
	<s:textfield name="username" label="用户名"></s:textfield>
	<s:password name="password" label="密码"></s:password>
	<s:radio list="{'男','女'}" name="sex" label="性别"></s:radio>
	<s:select list="{'北京','上海','长沙','南京'}" name="city" label="籍贯" headerKey="" headerValue="-请选择-"></s:select>
	<s:checkboxlist list="#{'football':'足球','pingpang':'乒乓球','basketball':'篮球' }" name="hobby" label="爱好"></s:checkboxlist>
</s:form>


</BODY>
</HTML>
