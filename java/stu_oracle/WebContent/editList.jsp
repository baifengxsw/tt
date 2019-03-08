<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- 包含 -->
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src ="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

function checkName(){
	//获取输入框的值
	var sname =$("#name").val();
	var nameregx = /[\u4E00-\u9FA5]+/;
	if(nameregx.test(sname)){
		//如果输入的手机号码符合正则表达式 
	
		$("#span01").html("<font color = 'green' size = '1px'>校验名字正确</font>");
		return true;
	}else {
		//输入的用户名不符合正则表达式
		$("#span01").html("<font color = 'red' size = '1px'>错误，名字必须是汉字</font>");
		return false;
	}
	}
	function checkPhone(){
		//获取输入框的值
		var sphone =$("#phone").val();
		var phoneregx = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/
		//发送post请求

		if(phoneregx.test(sphone)){
			//如果输入的手机号码符合正则表达式 
		
			$("#span02").html("<font color = 'green' size = '1px'>校验号码正确</font>");
			return true;
		}else {
			//输入的用户名不符合正则表达式
			$("#span02").html("<font color = 'red' size = '1px'>错误，请重新输入手机号</font>");
			return false;
		}
		}
	
	function checkDate(){
		//获取输入框的值
		var sdate =$("#date").val();
		var dateregx = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
		if(dateregx.test(sdate)){
			//如果输入的手机号码符合正则表达式 
		
			$("#span03").html("<font color = 'green' size = '1px'>校验生日正确</font>");
			return true;
		}else {
			//输入的用户名不符合正则表达式
			$("#span03").html("<font color = 'red' size = '1px'>错误,正确格式为XXXX-XX-XX</font>");
			return false;
		}
		}
	function checkAll(){
		var flag = checkName()&&checkPhone()&&checkDate();
		return flag;
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新用户界面</title>
</head>
<body>
<h3 align="center">更新用户</h3>
<form action="/stu/UpdateServlet" method="post" onsubmit = " return checkAll()">
<input type="hidden" name= "sid" value = ${stu.sid }>
  <table border="1px" align="center">
  <tr>
	<td>姓名</td>
	<td><input type="text" name="sname" value=${stu.sname } id = "name" onblur ="checkName()"><span id ="span01"></span></td>
  </tr>
  <tr>
  
	<td>性别</td>
	<td><input type="radio" name="gender" value="男" <c:if test="${stu.gender =='男' }">checked</c:if>>男  
	
	<input type="radio" name="gender" value="女" <c:if test="${stu.gender =='女' }">checked</c:if>>女 </td>
  </tr>
  <tr>
	<td>手机号</td>
	<td><input type = "text" name="phone" id = "phone" value = ${stu.phone } onblur="checkPhone()"> <span id = "span02"></span></td>
  </tr>
  <tr>
	<td>生日</td>
	<td><input type = "text" name="birthday" value = ${stu.birthday } id ="date" onblur="checkDate()"> <span id = "span03"></span></td>
  </tr>
  <tr>
	<td>爱好</td>
	<td>
		<input type ="checkbox" name ="hobby" value="游泳" <c:if test="${fn:contains(stu.hobby,'游泳') }">checked</c:if>>游泳
		<input type ="checkbox" name ="hobby" value="篮球" <c:if test="${fn:contains(stu.hobby,'篮球') }">checked</c:if>>篮球
		<input type ="checkbox" name ="hobby" value = "足球" <c:if test="${fn:contains(stu.hobby,'足球') }">checked</c:if>>足球
		<input type ="checkbox" name ="hobby" value="看书" <c:if test="${fn:contains(stu.hobby,'看书' )}">checked</c:if>>看书
		<input type ="checkbox" name ="hobby" value = "吸猫" <c:if test="${fn:contains(stu.hobby,'吸猫') }">checked</c:if>>吸猫
	</td>
  </tr>
  <tr>
	<td>简介</td>
	<td>
		<textarea rows="3" cols="32" name="info"  >${stu.info }</textarea>
	</td>
  </tr>
  <tr>
	<td colspan="2"><input type="submit" value="更新"></td>
  </tr>
  </table>
  </form>
</body>
</html>