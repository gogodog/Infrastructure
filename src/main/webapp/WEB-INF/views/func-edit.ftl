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
	    	<label>功能ID：</label>
	        <input name="id" type="text" placeholder="功能ID" value="${model.id}"/>
	    </p>
	    <p class="short-input ue-clear">
	    	<label>功能名称：</label>
	        <input name="name" type="text" placeholder="功能名称" value="${model.name}"/>
	    </p>
	    <p class="short-input ue-clear">
	    	<label>URL：</label>
	        <input name="funcUrl" type="text" placeholder="URL" value="${model.funcUrl}"/>
	    </p>
	    <p class="short-input ue-clear">
	    	<label>父级：</label>
	        <input name="pid" type="text" placeholder="父级ID" value="${model.pId}"/>
	    </p>
	    <p class="short-input ue-clear">
	    	<label>FUNCSEQ：</label>
	        <input name="funcSeq" type="text" placeholder="FUNCSEQ" value="${model.funcSeq}"/>
	    </p>
	    <p class="short-input ue-clear">
	    	<label>SITEID：</label>
	        <input name="siteId" type="text" placeholder="SITEID" value="${model.siteId}"/>
	    </p>
	    <div class="short-input select ue-clear">
	    	<label>类型：</label>
	        <div class="select-wrap">
	        	<div class="select-title ue-clear"><span>${model.funcType}</span><i class="icon"></i></div>
	            <ul class="select-list">
	            	<li>一级菜单</li>
	                <li>二级菜单</li>
	                <li>功能</li>
	            </ul>
	        </div>
	    </div>
	    <input name="funcType" type="text" style="display:none" value="${model.funcType}"/>
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
});
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
});
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$('input[name=funcType]').val(txt);
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
})
</script>
</html>
