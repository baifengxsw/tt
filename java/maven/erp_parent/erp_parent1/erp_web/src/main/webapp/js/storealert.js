$(function(){
	//加载表格数据
	$('#grid').datagrid({
		url: 'storedetail_storealertList',
		columns:[[
  		    {field:'uuid',title:'商品编号',width:100},
  		    {field:'name',title:'商品名称',width:100},
  		    {field:'storenum',title:'库存',width:100},
  		    {field:'outnum',title:'待发货',width:100},
			]],
		singleSelect: true,
		toolbar: [{
			text: '发送预警邮件',
			iconCls: 'icon-add',
			handler: function(){
				//调用服务端发送预警邮件
				$.ajax({
					url:'storedetail_sendStorealertMail',
					dataType:'json',
					type:'post',
					success:function(rtn){
						$.messager.alert("提示",rtn.message,"info");
					}
				})
			}
		}]
	});
})