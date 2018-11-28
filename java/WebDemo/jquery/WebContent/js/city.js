$(function(){
	//1.当多选框选中的时候 ,找到省份的元素
	$("#province").change(function(){
		var id = $("#province").val();
		$.post("CitySevlet",{id:id},function(data,status){
			//进行遍历
			$("#city").html("<option value="+">"+"-请选择-");
			$(data).find("city").each(function(){
				var id = $(this).children("id").text();
				var cname = $(this).children("cname").text();
				
				$("#city").append("<option value="+id+">"+cname);
			})
		})
	})
	
	//2.一旦发生改变 便去请求servlet
});