<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户界面</title>
</head>
<body>
<h3 align="center">添加用户</h3>
<form action="AddServlet" method="post">
  <table border="1px" align="center">
  <tr>
	<td>姓名</td>
	<td><input type="text" name="sname"></td>
  </tr>
  <tr>
	<td>性别</td>
	<td><input type="radio" name="gender" value="男">男  <input type="radio" name="gender" value="女">女 </td>
  </tr>
  <tr>
	<td>电话</td>
	<td><input type = "text" name="phone"></td>
  </tr>
  <tr>
	<td>生日</td>
	<td><input type = "text" name="birthday"></td>
  </tr>
  <tr>
	<td>爱好</td>
	<td>
		<input type ="checkbox" name ="hobby" value="游泳">游泳
		<input type ="checkbox" name ="hobby" value="篮球">篮球
		<input type ="checkbox" name ="hobby" value = "足球">足球
		<input type ="checkbox" name ="hobby" value="看书">看书
		<input type ="checkbox" name ="hobby" value = "吸猫">吸猫
	</td>
  </tr>
  <tr>
	<td>简介</td>
	<td>
		<textarea rows="3" cols="32" name="info"></textarea>
	</td>
  </tr>
  <tr>
	<td colspan="2"><input type="submit" value="添加"></td>
  </tr>
  </table>
  </form>
</body>
</html>