<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript">
	function fun(){
		window.location.href="regist.jsp";
		
	}
</script>
<title>登录界面</title>
</head>
<body>
<h1 align="center"> <font color="red">管理员登录界面</font></h1>
<form action="LoginServlet" method="post">
<table  width = "400px" align = "center"> 
<tr>
	<td align= "right">账号</td>
	<td> <input type="text" name="username"></td>
</tr>
<tr>
	<td align = "right">密码</td>
	<td> <input type ="password" name="password"></td>
</tr>
<tr>
	<td></td>
	<td align= "center"><input type = "checkbox" name = "auto_login">自动登录  </td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" value="登录"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type= "button"  onclick = "fun()" value = "注册">	</td>
</tr>
</table>

</form>
</body>
</html>