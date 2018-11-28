<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	function get(){
		//1;创建对象 
		var request = ajaxFunction();
		//2; 发送请求
		// 1 请求方式 2  请求的url 相对地址 ,是否异步
		request.open("GET","DemoServlet",true);
		//request.open("GET","DemoServlet?name='xia'&pass='123'",true);
		// post 方式
		//request.open("POST","DemoServlet",true);
		//request.send("name='xia'&age='16'")
		request.onreadystatechange = function(){
			//前半段表示能够正常处理 ,再对状态码进行判断是否200
			if(request.readyState == 4 && request.status==200){
				//弹出响应的信息
				alert(request.responseText);
			
			}
		}
		request.send();
		
	}

</script>
<title>Insert title here</title>
</head>
<body>


<h3><a href="#" onclick="get()">使用Ajax方式发送请求</a></h3>

</body>
</html>