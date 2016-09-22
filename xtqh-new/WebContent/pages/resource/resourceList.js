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
						colNames : [ '全选', '资源名称', '资源类型' ],
						colModel : [
								{
									name : 'resource_id',
									index : 'resource_id',
									align : "left",
									sortable : false,
									width : 30,
									formatter : function(val) {
										return '<input type="checkbox" name="resourceCheck" value="'
												+ val + '"/>';
									}
								}, {
									name : 'name',
									index : 'name',
									align : "left",
									sortable : true,
									sortname : 'name',
									width : 150
								}, {
									name : 'resource_type',
									index : 'resource_type',
									align : "left",
									sortable : true,
									sortname : 'resource_type',
									width : 150
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
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
