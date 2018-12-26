<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/login/css/base.css" />
<link rel="stylesheet" href="/login/css/info-reg.css" />
<title>基础结构平台</title>
</head>

<body>
<div class="title"><h2>权限编辑</h2></div>
<div class="main">
	<form id="addform" action="/user/update" method="get">
    <p class="short-input ue-clear">
    	<label>用户ID：</label>
        <input name="userId" type="text" placeholder="用户ID" value="${model.userId}" readonly="readonly"/><span>不可编辑</span>
    </p>
    <p class="short-input ue-clear">
    	<label>用户名称：</label>
        <input name="userName" type="text" placeholder="用户名称" value="${model.userName}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>email：</label>
        <input name="email" type="text" placeholder="email" value="${model.email}"/>
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
	        	window.location.href = "/user/list";
	        }
    	});
	}
});
$('.clear').on("click" , function(){
	window.location.reload();
})
</script>
</html>
