<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src = "js/jquery-1.11.3.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

	function checkUserName(){
		//获取输入框的值
		var sname =$("#name").val();
		//发送post请求
		$.post("CheckServlet",{name:sname},function(data,status){
			var ret = data;
			
			if(ret!=0){
				$("#span01").html("<font color='red'>用户已经存在</font>");
			}else{
				$("#span01").html("<font color='green'>用户可以注册</font>");
				
			}
			})
		}
	
</script>
</head>
<body>
  <table border="1px" width="350px" align="center">
  <tr>
	<td>用户名</td>
	<td><input type="text" name="name" id = "name" onblur="checkUserName()"> <span id = "span01"></span> </td>
  </tr>
  <tr>
	<td>密码</td>	
	<td><input type="password" name=""></td>
  </tr>
  <tr>
	<td>邮箱</td>
	<td><input type="text" name=""></td>
  </tr>
  <tr>
	<td>简介</td>
	<td><input type="text" name=""></td>
  </tr>
  <tr>
	<td colspan ="2"><input type="submit" value="注册"></td>

  </tr>
  </table>

</body>
</html>