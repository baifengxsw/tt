<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src ="js/jquery-1.11.3.min.js"></script>
<title>注册页面</title>
<script type="text/javascript">
	function showTips(){
		$("#span01").html("<font color = 'blue' size = '1px'>字母开头，允许4-16字节，只能包括数字字符和下划线</font>");
	}

	function checkUserName(){
		//获取输入框的值
		var sname =$("#name").val();
		var nameregx = /^[a-zA-Z][a-zA-Z0-9_]{3,15}$/
		//发送post请求
		if(nameregx.test(sname)){
			//如果输入的用户名符合正则表达式 
	
		 var result = false;
		    $.ajax({
		        url :"CheckUserNameServlet",
		        type : "post",
		        data : {name:sname},
		        async : false,
		        success : function(data) {
		        	var ret = data;
					if(ret!=0){
						$("#span01").html("<font color='red'>用户已经存在</font>");
						result =  false;
					}else{
						$("#span01").html("<font color='green'>用户可以注册</font>");
						result =  true;
						
					}
		        }
		    });
		    return result;

		}else {
			//输入的用户名不符合正则表达式
			$("#span01").html("<font color = 'red' size = '1px'>用户名要求字母开头，允许4-16字节，只能包括数字和下划线</font>");
			return false;
		}
		
		}
	function showTipl(){
		$("#span02").html("<font color = 'blue' size = '1px'>以字母开头，长度在6~18之间，只能包含字母、数字和下划线</font>");
	}

	function checkPassWord(){
		//获取输入框的值
		var spass =$("#pass").val();
		var nameregx = /^[a-zA-Z]\w{5,17}$/
		//发送post请求
		if(nameregx.test(spass)){
			//如果输入的用户名符合正则表达式 
		
			$("#span02").html("<font color = 'green' size = '1px'>密码可以使用</font>");
			return true;
		}else {
			//输入的用户名不符合正则表达式
			$("#span02").html("<font color = 'red' size = '1px'>以字母开头，长度在6~18之间，只能包含字母、数字和下划线</font>");
			return false;
		}
		}
	function showTip2(){
		$("#span03").html("<font color = 'blue' size = '1px'>以字母开头，长度在6~18之间，只能包含字母、数字和下划线</font>");
	}

	function checkPassWord1(){
		//获取输入框的值
		var spass =$("#pass").val();
		var spass1 = $("#pass1").val();

		
		
		//发送post请求
		if(spass!=spass1){
			//如果输入的密码不等
		
			$("#span03").html("<font color = 'red' size = '1px'>两次输入的密码不相等</font>");
			return false;

		}else{
			$("#span03").html("<font color = 'green' size = '1px'>校验成功</font>");
			return true;
		}
	}
	function checkForm(){
		var flag = checkUserName() && checkPassWord() && checkPassWord1();

		return flag;
	}
	
</script>
</head>
<body>
	<h2 align="center" ><font color ="red"> 管理员注册</font></h2> 
	<form action="/stu/USerRegistServlet" onsubmit="return checkForm()" method="post">
	  <table  width="600px" align="center">
  <tr>
	<td align = "right">用户名</td>
	<td><input type="text" name="name" id = "name" onfocus = "showTips()" onblur="checkUserName() " onkeyup="checkUserName()"> <span id = "span01"></span> </td>
  </tr>
  
  <tr>
	<td align = "right">密码</td>	
	<td><input type="password" name="pass" id = "pass" onfocus = "showTipl()" onblur="checkPassWord()" onkeyup="checkPassWord()"><span id = "span02"></span></td>
  </tr>
  <tr>
	<td align = "right">确认密码</td>	
	<td><input type="password" name="pass1" id = "pass1" onfocus = "showTip2()" onblur="checkPassWord1()" ><span id = "span03"></span></td>
  </tr>

  <tr>
	<td  align ="center" colspan ="2"><input type="submit" value="注册"></td>

  </tr>
  </table>
</form>
</body>
</html>