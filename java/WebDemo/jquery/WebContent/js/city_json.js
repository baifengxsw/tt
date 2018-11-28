$(function() {
	//1。找到省份的元素
	$("#province").change(function() {
		//2. 一旦里面的值发生了改变，那么就去请求该省份的城市数据
		//$("#province").varl();
		var pid = $(this).val();
		
		/*[
		    {
		        "cname": "深圳",
		        "id": 1,
		        "pid": 1
		    },
		    {
		        "cname": "东莞",
		        "id": 2,
		        "pid": 1
		    }
		    ...
		]*/
		$.post( "CityServlet22",{id:pid} ,function(data,status){
			
			//先清空
			$("#city").html("<option value='' >-请选择-");
			//再遍历，追加
			$(data).each(function(index , c) {
				$("#city").append("<option value='"+c.id+"' >"+c.cname)
			});
		},"json" );
		
	});
});