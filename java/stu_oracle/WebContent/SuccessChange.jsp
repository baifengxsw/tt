<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		onload=function(){
			setInterval(go, 1000);
		};
		var x=3; //利用了全局变量来执行
		function go(){
		x--;
			if(x>0){
			document.getElementById("sp").innerHTML=x;  //每次设置的x的值都不一样了。
			}else{
			location.href='index.jsp';
			}
		}
	</script>

<title>Insert title here</title>
</head>
<body>
<h4 align="center">注册成功 ！将在3秒后跳转到登录界面</h4><br>
<table  width="300px" align="center">
  <tr>
	
	<td align="center"><font color = "blue" size = '6px' id = "sp"></font> </td>
  </tr>
  </table>

</body>
</html>