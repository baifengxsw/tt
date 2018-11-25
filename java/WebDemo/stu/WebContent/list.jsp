<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>相关信息列表</title>
<script type="text/javascript">
	function doDelete(sid){
		var flag = confirm("是否确定删除");
		if(flag){
			//确定 ,访问servlet
			window.location.href="DeleteServlet?sid="+sid;
		}
	}
</script>
</head>
<body>
<form action="FindServlet" method="post">
<h2 align="center">用户信息展示</h2>
<table border="1px" align="center">
	<tr >
		<td colspan="8">
			按姓名查询 <input type="text" name="sname">
			按性别查询 <select name="sgender">
						<option value="">--请选择--
						<option value="男">男
						<option value="女">女
 					 </select>
 					 &nbsp; 
 					 <input type="submit" value ="查询">
 					  &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;
			<a href= "addList.jsp">添加记录</a>
		</td>
	</tr>
  <tr>
	<td>编号</td>
	<td>姓名</td>
	<td>性别</td>
	<td>电话</td>
	<td>生日</td>
	<td>爱好</td>
	<td>简介</td>
	<td>操作</td>
  </tr>
  <!-- 这里使用了JSTL -->
  <c:forEach items="${list}" var ="stu">
	  <tr>
		<td>${stu.sid}</td>
		<td>${stu.sname}</td>
		<td>${stu.gender}</td>
		<td>${stu.phone}</td>
		<td>${stu.birthday}</td>
		<td>${stu.hobby}</td>
		<td>${stu.info}</td>
		<td><a href="EditServlet?sid=${stu.sid }">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
	  </tr>
  </c:forEach>
  </table>
  </form>

</body>
</html>