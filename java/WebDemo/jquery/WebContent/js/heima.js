//1捕捉到 键盘弹起事件
//在文档准备就绪时候 ,对某个元素进行onkeyup事件监听
 $(function(){
	 $("#word").keyup(function(){
		 //2得到数据框的值
		 var word = $("#word").val();
		 //3进行数据请求
		 $.post("FindWordServlet",{word:word},function(data,status){
			 
			 
			$("#div01").html(data);
		 })
	 })
 })
 