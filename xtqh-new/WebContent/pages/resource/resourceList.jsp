<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/pages/common/taglibs.jsp"%>
<%@ include file="/pages/common/commonJS.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="Xenon Boostrap Admin Panel" />
<meta name="author" content="" />

<title>资源管理</title>
</head>
<body>
	<!-- 顶部导航栏 -->
	<ol class="breadcrumb">
		<li><a>资源管理</a></li>
	</ol>
	<!-- 	//////////////////////////// -->
	<div class="detail" style="margin: 1px 10px">
		<h3 class="title">资源列表</h3>
		<i class="ico-1"></i>
		<div class="detail-content back-fff bbor">
			<div class="detail-intro pl0">
				<div class="input-type col-5-1 l">
					<span>资源类型：</span> <select class="select-185" id="type" name="type"
						onchange="queryResource(1,10);">
						<option value="">全部资源类型</option>
					</select>
				</div>
				<div class="input-type col-5-1 l">
					<span>资源地点：</span> <select class="select-185" id="location"
						name="location" onchange="queryResource(1,10);">
						<option value="">全部资源地点</option>
					</select>
				</div>
				<div class="input-type col-5-1 l">
					<span>关联应用系统：</span> <select id="appNameInCmdb"
						name="appNameInCmdb" class="selectpicker form-control"
						data-live-search="true" onchange="queryResource(1, 10)"
						data-live-search-style="begins">
						<option value="">请选择</option>
					</select>
				</div>
				<div class="input-type col-xs-3 r">
					<input type="text" name="" class="input-text l" id="blur"
						name="blur" placeholder="通过资源名称、hostname、控制IP、序列号、等关键字来模糊搜索已有的资源">
					<input type="button" class="btn search" value="搜索"
						onclick="queryResource(1,10);">
				</div>
			</div>
			<div class="hg20"></div>
			<hr />
			<div class="hg10"></div>
			<!-- ///////////////////////////////////// -->
			<div>
				<div id="pageDiv">
					<s:if test="#session.roleList.roleCodel.indexOf('005')!=-1  ">
						<input id="newresource" type="button"
							class="btn btn-danger fr mr-15"
							style="cursor: pointer; border-radius: 6px;" value="新建" />
						<input id="btnBatchCopy" type="button"
							class="btn btn-danger fr mr-15"
							style="cursor: pointer; border-radius: 6px;" value="批量复制cmdb资源" />
						<input id="btnDelMany" type="button"
							class="btn btn-danger fr mr-15"
							style="cursor: pointer; border-radius: 6px;" value="删除" />
					</s:if>
					<p class="r">
						当前可达资源 <span id="ans_resource1"></span>个，不可达资源 <span
							id="ans_resource0" style="cursor: pointer"></span>个。
					</p>
					<div class="hg10"></div>
					<table
						class="table table-striped table-bordered table-bg table-hover"
						id="table">
						<thead class="text-l">
							<tr>
								<th style='width: 40px'><input type="checkbox"
									class="checkedAll"></th>
								<th style='width: 20%'>资源名称</th>
								<th style='width: 20%'>资源类型</th>
								<th style='width: 20%'>资源地点</th>
								<th style='width: 100px'>控制IP地址</th>
								<th style='width: 20%'>主机名</th>
								<th style='width: 100px'>资源ip</th>
								<th style='width: 20%'>所属应用系统</th>
								<th style='width: 80px'>资源状态</th>
								<th style='width: 150px'>操作</th>
							</tr>
						</thead>
						<tbody id="tbodyList" class="text-l">
							<tr>
								<td colspan=100 style="color: red; font-weight: bolder;">无数据</td>
							</tr>
						</tbody>
						<script id="wflistTemplate" type="text/x-jsrender"> 
                      	 {{if #index%2==1 }}
                      		 <tr id="{{>id}}" class="table_tr01" onmouseover="this.style.background='#c6bfbf'" onmouseout="this.style.background=''">								
							{{else}}
							<tr id="{{>id}}" class="table_tr02" onmouseover="this.style.background='#c6bfbf'" onmouseout="this.style.background=''">
							{{/if}}
							<th><input type="checkbox" name="arrid[]" value="{{>id}}"></th>
                       		<td title='{{>name}}'>{{>name}}</td>
							<td>{{>type}}</td>
                       		<td>{{>location}}</td>
							<td title='{{>controllingIp}}'>{{>controllingIp}}</td>
							<td title='{{>hostname}}'>{{>hostname}}</td>
							<td title='{{>ipAddresses}}'>{{>ipAddresses}}</td>														
							<td title='{{>appNameInCmdb}}'>{{>appNameInCmdb}}</td>
							{{if arsState == 1 }}
								<td><span class='glyphicon glyphicon-ok' style="color:green"></span></td>
							{{else}}
								<td><span class='glyphicon glyphicon-remove' style="color:red"></span></td>
							{{/if}}
								<td>
									<s:if test="#session.roleList.roleCodel.indexOf('005')!=-1  ">
								   <a href="javascript:modifiedResource('{{>id}}')">编辑 </a>&nbsp;
									</s:if>
								   <a href="javascript:viewResource('{{>id}}')">查看 </a>&nbsp;
							    </td>                                	     
							</tr>
                       </script>
					</table>
				</div>
				<div style="height: 15px"></div>
			</div>
		</div>
	</div>
</body>
<!-- //////////////////////////////////////////////////----- javascript ------////////////////////////////////////////////////////////////////////// -->
<script type="text/javascript"
	src="<%=path%>/resource/newCssAndJs/js/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resource/js/layer-v2.0/layer.js"></script>
<script type="text/javascript" src="<%=path%>/resource/js/proc/proc.js"></script>
<script type="text/javascript" src="<%=path%>/resource/js/jsrender.js"></script>
<script src="<%=path%>/resource/iCheck/js/icheck.min.js"></script>
<script src="<%=path%>/resource/js/common-utils.js"></script>
<script src="<%=path%>/resource/js/bootstrap.min.js"></script>
<script
	src="<%=path%>/resource/bootstrap-select/dist/js/bootstrap-select.js"></script>
<script type="text/javascript">
	$(function() {
		//加载流程应用系统
		$.ajax({
			url : "resourcemanager!getApplicationIsCitation.action",
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.length != 0) {
					$.each(data, function(i, d) {
						$("#appNameInCmdb").append(
								"<option value='" + d.appNameInCmdb + "'>"
										+ d.appNameInCmdb + "</option>");
					})
				}
			}
		});
		////////////////
		$("#blur").keydown(function(event) {
			if (event.keyCode == 13) {
				queryResource(1, 10);
				return false;
			}
		});

		queryResource(1, 10);

		//资源类型
		$.post("sysitem!getResType.action", function(data) {
			if (data.length != 0) {
				for (var i = 0; i < data.length; i++) {
					$("#type").append(
							"<option value='"+data[i].id+"'>" + data[i].value
									+ "</option>");
				}
			}
		});
		//资源地点
		$.post("sysitem!getResLocation.action", function(data) {
			if (data.length != 0) {
				for (var i = 0; i < data.length; i++) {
					$("#location").append(
							"<option value='"+data[i].id+"'>" + data[i].value
									+ "</option>");
				}
			}
		});

		//获取可达资源数
		$.post("ansresourcestatus!getCount.action?ping_status=1", {}, function(
				data) {
			if (data.result) {
				$("#ans_resource1").text(data.c);
			}
		}, "json");

		//不可达资源数
		$.post("ansresourcestatus!getCount.action?ping_status=0", {}, function(
				data) {
			if (data.result) {
				$("#ans_resource0").text(data.c);
			}
		}, "json");

		$("#ans_resource0").click(function() {

			loadFrame("resourcemanager!toInaccessPage.action");
		})

		$("#btnDelMany").click(function() {
			var ids = [];
			var cpage = $("#cpage").val();
			$("input[name='arrid[]']").each(function() {
				if ($(this).prop('checked')) {
					ids.push($(this).val());
				}
			});
			if (ids.length == 0) {
				layer.msg("请选择要删除的资源");
				return false;
			}
			layer.confirm('确定要删除吗？', {
				btn : [ '是', '否' ]
			//按钮
			}, function(index) {
				var index1 = layer.load(1, {
					shade : [ 0.3 ]
				//0.1透明度的白色背景
				});
				$.post("resourcemanager!deleteResourceMany.action", {
					"ids[]" : ids
				}, function(data) {
					setTimeout(function() {
						layer.closeAll('loading'); //关闭加载层
						if (data.result) {
							layer.close(index);
							for (i = 0; i < ids.length; i++) {
								$("tr[id='" + ids[i] + "']").remove();
							}
							queryResource(cpage, 10);
						} else {
							layer.msg(data.message);
						}
					}, 1000);
				}, "json");
			}, function() {

			});
		});

		//新建资源
		$("#newresource").click(function() {
			//保存时弹出层防止重复点击
			var index1 = layer.load(1, {
				shade : [ 0.3 ]
			//0.1透明度的白色背景
			});

			setTimeout(function() {
				loadFrame("resourcemanager!toAddPage.action");
			}, 1000);
		})

		$("#btnBatchCopy")
				.click(
						function() {
							var index1 = layer.load(1, {
								shade : [ 0.3 ]
							//0.1透明度的白色背景
							});
							////
							setTimeout(
									function() {
										layer.closeAll('loading'); //关闭加载层
										//加载cmdb资源
										var index = layer
												.open({
													type : 2,
													title : '批量复制CMDB资源',
													shade : 0.8,
													shadeClose : true,
													area : [ '70%', '85%' ],
													content : [
															"resourcemanager!toBatchCmdbPage.action?&callback=finishSelCMDB&tag=yes",
															"yes" ]
												});
									}, 1000);
						});
	});
	/////////////////////////////////////
	function queryResource(cpage, pageSize) {
		//条件查询的参数
		var blur = $("#blur").val();
		var type = $("#type").val();
		var location = $("#location").val();
		var isReachable = $("#isReachable").val();
		var appNameInCmdb = $("#appNameInCmdb").val();
		var ownerInCmdb = $("#ownerInCmdb").val();
		var aRolePersonName = $("#aRolePersonName").val();
		//查询所有资源，包括无效的
		var isOk = "0";
		var param = {
			"currentPage" : cpage,
			"pageSize" : pageSize,
			"blur" : blur,
			"type" : type,
			"location" : location,
			"isReachable" : isReachable,
			"appNameInCmdb" : appNameInCmdb,
			"ownerInCmdb" : ownerInCmdb,
			"aRolePersonName" : aRolePersonName,
			"isOk" : isOk
		};
		var paramUrl = 'resourcemanager!searchResourceList.action';
		pageAjax('pageDiv', 'wflistTemplate', 'tbodyList', 'queryResource',
				paramUrl, param, function() {
					//icheck
					$('input').iCheck({
						checkboxClass : 'icheckbox_square-red', // 注意square和blue的对应关系,用于type=checkbox
					});
				});

		//全选、反选
		$('.checkedAll').on('ifChecked', function(event) {
			$('input').iCheck('check');
		});
		$('.checkedAll').on('ifUnchecked', function(event) {
			$('input').iCheck('uncheck');
		});
	}
	//////////////////////////
	function deleteResource(id) {
		layer.confirm('确定要删除吗？', {
			btn : [ '是', '否' ]
		//按钮
		}, function(index) {
			$.post("resourcemanager!deleteResource.action", {
				"id" : id
			}, function(data) {
				if (data.result) {
					layer.close(index);
					$("tr[id='" + id + "']").remove();
				} else {
					layer.msg(data.message);
				}
			});
		}, function() {

		});
		return false;
	}
	//编辑资源信息数据
	function modifiedResource(id) {
		var index1 = layer.load(1, {
			shade : [ 0.3 ]
		//0.1透明度的白色背景
		});
		////
		setTimeout(function() {
			loadFrame("resourcemanager!modifyResource.action?id=" + id
					+ "&isEdit=0");
		}, 1000);
	}

	function viewResource(id) {
		var index1 = layer.load(1, {
			shade : [ 0.3 ]
		//0.1透明度的白色背景
		});
		////
		setTimeout(function() {
			loadFrame("resourcemanager!modifyResource.action?id=" + id
					+ "&viewflag=1&isEdit=1");
		}, 1000);
	}
	//batchcmdb页面的回掉函数
	function f_batchcmdb() {
		queryResource(1, 10);
	}
</script>
</html>
