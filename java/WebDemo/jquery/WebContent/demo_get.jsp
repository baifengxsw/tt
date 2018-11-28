<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src = "js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function get(){
		$.get("/JqueryDemo/DemoServlet",function(data,status){
			//$("#div01").val(data); 用于设置标签里面有value的值 
			//$("#id") 等于从document.getElementById("div01");
			$("#div01").html(data);
		})
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<input type="button" onclick = "get()" value="使用Jquery演示get方法">
	<div id = "div01" style="width:100px ; height:100px;border : 1px solid red;">
	
	</div>
</body>
</html>