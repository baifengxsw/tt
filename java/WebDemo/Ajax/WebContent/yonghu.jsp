<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function ajaxFunction(){
	   var xmlHttp;
	   try{ // Firefox, Opera 8.0+, Safari
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{// Internet Explorer
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }

		return xmlHttp;
	 }
	function checkUserName(){
		//获取输入框的值
		var name =document.getElementById("name").value;
		//1创建对象 
		
		var request = ajaxFunction();
		//2 发送请求  提交的是全路径
		request.open("POST","CheckUsernameServlet",true);
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		request.send("name="+name);
		//获取服务器传送过来的数据
		request.onreadystatechange = function(){
			if(request.readyState == 4 && request.status == 200){
				var ret = request.responseText;
				if(ret == 0){
					document.getElementById("span01").innerHTML = "<font color ='green'> 用户名允许注册</font>";
				}else{
					document.getElementById("span01").innerHTML = "<font color ='red'> 用户名已经存在</font>";
					
				}
			}
		}
	}
	
</script>
</head>
<body>
  <table border="1px" width="250px" align="center">
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