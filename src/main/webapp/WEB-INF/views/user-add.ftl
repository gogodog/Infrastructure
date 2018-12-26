<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/login/css/base.css" />
<link rel="stylesheet" href="/login/css/info-reg.css" />
<title>基础结构平台</title>
</head>

<body>
<div class="title"><h2>新增用户</h2></div>
<div class="main">
	<form id="addform" action="/user/save" method="get">
	    <p class="short-input ue-clear">
	    	<label>角色ID：</label>
	        <input name="userId" type="text" placeholder="用户ID" />
	    </p>
	    <p class="short-input ue-clear">
	    	<label>角色名称：</label>
	        <input name="userName" type="text" placeholder="角色名称" />
	    </p>
	    <p class="short-input ue-clear">
	    	<label>email：</label>
	        <input name="email" type="text" placeholder="邮箱" />
	    </p>
   </form>
</div>
<div class="btn ue-clear">
	<a href="javascript:;" class="confirm">确定</a>
    <a href="javascript:;" class="clear">清空内容</a>
</div>
</body>
<script type="text/javascript" src="/login/js/jquery.js"></script>
<script type="text/javascript" src="/login/js/jquery.form.js"></script>
<script type="text/javascript" src="/login/js/common.js"></script>
<script type="text/javascript">
$('.confirm').on("click" , function(){
	if(confirm("是否确定保存 ？")){
		$("#addform").ajaxSubmit(function(data){ 
	        if(data.error){  
	            alert(data.errorMessage);
	        }else{
	        	window.location.href = "/user/list";
	        }
    	});
	}
});
$('.clear').on("click" , function(){
	$('input[name=userId]').val('');
	$('input[name=userName]').val('');
	$('input[name=email]').val('');
})
</script>
</html>
