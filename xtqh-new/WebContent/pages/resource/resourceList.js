$(document).ready(function() {
	loadResourceList();
});

/**
 * 加载ResourceList
 * 
 * @returns
 */
function loadResourceList() {
	$("#resourceList")
			.jqGrid(
					{
						url : commonContext + 'resourceController/resourceList',
						datatype : "json",
						mtype : 'POST',
						altRows : true,
						rowNum : 2,
						rowList : [ 2, 4, 6 ],
						altclass : 'alteColor',
						postData : getPostData(),
						rownumbers : true,
						colNames : [ '全选', '资源名称', '资源类型', '资源地点', '控制IP地址',
								'主机名', '资源ip', '所属应用系统', '资源状态', '操作' ],
						colModel : [
								{
									name : 'resourceId',
									index : 'resourceId',
									align : "left",
									sortable : false,
									width : 30,
									formatter : function(val) {
										return '<input type="checkbox" name="resourceCheck" value="'
												+ val + '"/>';
									}
								},
								{
									name : 'name',
									index : 'name',
									align : "left",
									sortable : true,
									sortname : 'name',
									width : 150
								},
								{
									name : 'resourceType',
									index : 'resourceType',
									align : "left",
									sortable : true,
									sortname : 'resourceType',
									width : 150
								},
								{
									name : 'location',
									index : 'location',
									align : "left",
									sortable : true,
									sortname : 'location',
									width : 150
								},
								{
									name : 'controllingIp',
									index : 'controllingIp',
									align : "left",
									sortable : true,
									sortname : 'controllingIp',
									width : 150
								},
								{
									name : 'hostname',
									index : 'hostname',
									align : "left",
									sortable : true,
									sortname : 'hostname',
									width : 150
								},
								{
									name : 'resourceIp',
									index : 'resourceIp',
									align : "left",
									sortable : true,
									sortname : 'resourceIp',
									width : 150
								},
								{
									name : 'applicationNames',
									index : 'applicationNames',
									align : "left",
									sortable : true,
									sortname : 'applicationNames',
									width : 150
								},
								{
									name : 'status',
									index : 'status',
									align : "left",
									sortable : true,
									sortname : 'status',
									width : 150
								},
								{
									name : 'resourceId',
									index : 'resourceId',
									align : "left",
									sortable : true,
									sortname : 'resourceId',
									width : 150,
									formatter : function(val, options, rowdata) {
										var status = rowdata.rule_status;
										var display = '';
										display = '<a href="javascript:editResource('
												+ val + ')" >编辑</a> ';

										display = display
												+ '<a href="javascript:viewResourceDetail('
												+ val + ')" >查看</a> ';
										display = display
												+ '<a href="javascript:deleteResource('
												+ val + ')" >删除</a> ';

										return display;
									}
								} ],
						jsonReader : {
							root : "records",
							total : "totalPages",
							page : "page",
							records : "totalCount",
							repeatitems : false
						},
						pager : "#pageBar_resourceList",
						viewrecords : true,
						width : '100%',
						autowidth : true,
						height : 'auto',
						// height : '200',
						pagerpos : 'right',
						recordpos : 'center'
					}).navGrid('#pageBar_resourceList', {
				add : false,
				edit : false,
				del : false,
				search : false,
				refresh : false
			});

}

function getPostData() {
	return {
		'searchKey' : encodeURI($("#searchKey").val())
	};
}

/**
 * resource 编辑
 * 
 * @param resourceId
 * @returns
 */
function editResource(resourceId) {
	alert("edit resource!");
}
/**
 * resource 查看
 * 
 * @param resourceId
 * @returns
 */
function viewResourceDetail(resourceId) {
	alert("view resource detail!");
}

/**
 * resource 刪除
 * 
 * @param resourceId
 * @returns
 */
function deleteResource(resourceId) {
	alert("detele resource!");

	if (!selectedData) {
		selectedData = '';
		var selectedRule = $('input[name=changeWindowCheck]:checked',
				"#resourceList");
		if (selectedRule && selectedRule.length > 0) {
			for (var i = 0; i < selectedRule.length; i++) {
				selectedData += ($(selectedRule[i]).val() + ',');
			}
		}
	}
	if (selectedData) {
		// 提交删除请求
		$.ajax({
			url : commonContext + "/management/changewindow/delete",
			data : {
				"cdRules" : selectedData

			},
			success : function(data) {
				if (data && data == 'success') {
					Msg.info('成功', '成功删除选中的维护期');
					// 刷新列表
					search();
				} else {
					Msg.error('错误', '删除失败!' + data);
				}
			},
			error : function(e, xhr) {
				Msg.error('错误', '删除失败!');
			}
		});

	} else {
		Msg.alert('警告', '未选择任何服务器');
	}
}

/**
 * resource详情
 * 
 * @returns
 */
function searchResourceList() {
	$("#resourceList").jqGrid('setGridParam', {
		datatype : 'json',
		postData : getPostData(),
		page : 1
	}).trigger("reloadGrid"); // 重新载入
}

/**
 * 
 * @returns
 */
function commitTransaction() {

	alert("1, commit transaction，");

	$("#resourceList").jqGrid('setGridParam', {
		datatype : 'json',
		postData : getPostData(),
		page : 1
	}).trigger("reloadGrid"); // 重新载入
}
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
