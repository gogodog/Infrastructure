<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/login/css/base.css" />
<link rel="stylesheet" href="/login/css/info-reg.css" />
<title>基础结构平台</title>
</head>

<body>
<div class="title"><h2>功能编辑编辑</h2></div>
<div class="main">
	<form id="addform" action="/func/update" method="get">
    <p class="short-input ue-clear">
    	<label>角色ID：</label>
        <input name="id" type="text" placeholder="角色ID" value="${model.id}" readonly="readonly"/><span>不可编辑</span>
    </p>
    <p class="short-input ue-clear">
    	<label>角色名称：</label>
        <input name="name" type="text" placeholder="角色名称" value="${model.name}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>SITEID：</label>
        <input name="siteId" type="text" placeholder="SITEID" value="${model.siteId}"/>
    </p>
   </form>
</div>
<div class="btn ue-clear">
	<a href="javascript:;" class="confirm">确定</a>
    <a href="javascript:;" class="clear">重置</a>
</div>
</body>
<script type="text/javascript" src="/login/js/jquery.js"></script>
<script type="text/javascript" src="/login/js/jquery.form.js"></script>
<script type="text/javascript" src="/login/js/common.js"></script>
<script type="text/javascript">
$('.confirm').on("click" , function(){
	if(confirm("是否确定保存修改 ？")){
		$("#addform").ajaxSubmit(function(data){
	        if(data.error){  
	            alert(data.message);     
	        }else{
	        	window.location.href = "/func/list";
	        }
    	});
	}
});
$('.clear').on("click" , function(){
	window.location.reload();
})
</script>
</html>
