<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function post(){
		//$("#test01") --- document.getElementByID load  加载响应的数据放在这里进行显示
		
		$.post("/JqueryDemo/DemoServlet",{name:"xia"},function(data,status){
			//找到这个哥们 给它的值设置为 responseText
			$("#test01").val(data);
		});
	}
</script>
</head>
<body>
<!--  <h3> <a href ="" onclick="load()">使用jquery执行相应的load方法</a></h3>-->
<h3> <input type="button" onclick="post()" value= "使用jquery执行相应的post方法"></h3>

<input type="text" id="test01">

</body>
</html>