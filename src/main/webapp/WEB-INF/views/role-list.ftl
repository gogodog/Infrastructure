<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/login/css/base.css" />
<link rel="stylesheet" href="/login/css/info-mgt.css" />
<link rel="stylesheet" href="/login/css/WdatePicker.css" />
<title>基础结构平台</title>
</head>

<body>
<div class="title"><h2>角色管理</h2></div>
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions operate-time ue-clear">
            <label>名称：</label>
            <div class="input-box ue-clear">
                <input type="text" id="roleName" style="width:120px" value="${bean.roleName}"/>
            </div>
        </div>
    </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:;" class="confirm">查询</a>
        <a href="javascript:;" class="clear">清空条件</a> 
    </div>
</div>
<div class="table-operate ue-clear">
	<a href="/helloworld?page=role-add" class="add">添加</a>
    <a href="javascript:;" onclick="delline('')" class="del">删除</a>
    <a href="javascript:;" onclick="editline('')" class="edit">编辑</a>
    <a href="javascript:;" class="count">权限</a>
    <a href="javascript:;" class="check">审核</a>
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th class="num">ID</th>
                <th class="name">名称</th>
                <th class="process">创建人</th>
                <th class="node">适节点</th>
                <th class="operate">操作</th>
            </tr>
        </thead>
        <tbody id="list">
        <#list list.objects as item>
        	<tr>
            	<td class="num">${item.roleId}</td>
                <td class="name">${item.roleName}</td>
                <td class="process">${item.createuser}</td>
                <td class="node">${item.siteId}</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript"src="/login/js/jquery.js"></script>
<script type="text/javascript"src="/login/js/common.js"></script>
<script type="text/javascript"src="/login/js/jquery.pagination.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
})
$('.pagination').pagination(${list.totalResults},{
	callback: function(page){
		window.location.href = "/role/list?currentPage="+ (page+1) +"&roleName="+ $("#roleName").val();
	},
	items_per_page : ${bean.onePageSize}, // 每页显示多少条记录
	current_page : ${list.currentPage - 1},
	display_msg: true,
	setPageNo: true
});
$('.confirm').on("click" , function(){window.location.href = "/role/list?currentPage=1&roleName="+ $("#roleName").val()});
$('.clear').on("click" , function(){$("#roleName").val('')});
var arrUl = $(".left_tree_ad_btn_container > ul");

$.each($("#list").children(), function(){
 	$(this).on("click" , function(){
 		if($(this).attr("style") == "background-color:hotpink"){
 			$(".del").attr("onclick",'');
 			$(".del").attr("onclick","delline('')");
 			$(".edit").attr("onclick",'');
 			$(".edit").attr("onclick","editline('')");
 			$(this).attr("style","");
 			return;
 		}
 		var fuc = "'" + "/role/del?roleId="+$(this).children(":first").html() + "'";
 		$(".del").attr("onclick","delline("+ fuc +")");
 		fuc = "'" + "/role/edit?roleId="+$(this).children(":first").html() + "'";
 		$(".edit").attr("onclick","editline("+ fuc +")");
 		$.each($(this).siblings(),function(){
 			$(this).attr("style","");
 		});
 		$(this).attr("style","background-color:hotpink");
 	});
});
function delline(url){
	if(!url){
		alert("点击选择删除行。");
		return;
	}
	if(confirm("是否确定删除 ？")){
		$.ajax({ 
			url: url,
			success: function(data){
			        if(data.error)
			        	alert(data.errorMessage);
			        else
			        	window.location.reload();
	    	}
	    });
    }
};
function editline(url){
	if(!url){
		alert("点击选择修改行。");
		return;
	}
	window.location.href = url;
};
</script>
</html>
