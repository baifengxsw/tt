$(function(){
	//加载表格数据
	$('#grid').datagrid({
		url: 'storedetail_listByPage',
		columns:[[
  		    {field:'uuid',title:'编号',width:100},
  		    {field:'storeName',title:'仓库',width:100},
  		    {field:'goodName',title:'商品',width:100},
  		    {field:'num',title:'数量',width:100},

			{field:'-',title:'操作',width:200,formatter: function(value,row,index){
				var oper = "<a href=\"javascript:void(0)\" onclick=\"edit(" + row.uuid + ')">修改</a>';
				oper += ' <a href="javascript:void(0)" onclick="del(' + row.uuid + ')">删除</a>';
				return oper;
			}}
			]],
		singleSelect: true,
		pagination: true,
		toolbar: [{
			text: '新增',
			iconCls: 'icon-add',
			handler: function(){
				//设置保存按钮提交的方法为add
				method = "add";
				//关闭编辑窗口
				$('#editForm').form('clear');
				$('#editDlg').dialog('open');
			}
		}]
	});
	//点击查询按钮
	$('#btnSearch').bind('click',function(){
		//把表单数据转换成json对象
		var formData = $('#searchForm').serializeJSON();
		$('#grid').datagrid('load',formData);
	});
})