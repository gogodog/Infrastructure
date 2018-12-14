<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/login/css/base.css" />
<link rel="stylesheet" href="/login/css/info-reg.css" />
<title>基础结构平台</title>
</head>

<body>
<div class="title"><h2>新增功能</h2></div>
<div class="main">
	<form id="addform" action="/func/save" method="get">
    <p class="short-input ue-clear">
    	<label>功能ID：</label>
        <input name="id" type="text" placeholder="功能ID" />
    </p>
    <p class="short-input ue-clear">
    	<label>功能名称：</label>
        <input name="name" type="text" placeholder="功能名称" />
    </p>
    <p class="short-input ue-clear">
    	<label>URL：</label>
        <input name="funcUrl" type="text" placeholder="URL" />
    </p>
    <p class="short-input ue-clear">
    	<label>父级：</label>
        <input name="pid" type="text" placeholder="父级ID" />
    </p>
    <p class="short-input ue-clear">
    	<label>FUNCSEQ：</label>
        <input name="funcSeq" type="text" placeholder="FUNCSEQ" />
    </p>
    <p class="short-input ue-clear">
    	<label>SITEID：</label>
        <input name="siteId" type="text" placeholder="SITEID" />
    </p>
    <div class="short-input select ue-clear">
    	<label>类型：</label>
        <div class="select-wrap">
        	<div class="select-title ue-clear"><span>一级菜单</span><i class="icon"></i></div>
            <ul class="select-list">
            	<li>一级菜单</li>
                <li>二级菜单</li>
                <li>功能</li>
            </ul>
        </div>
    </div>
    <input name="funcType" type="text" style="display:none" value="一级菜单"/>
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
	        	window.location.href = "/func/list";
	        }
    	});
	}
});
$('.clear').on("click" , function(){
	$('input[name=id]').val('');
	$('input[name=name]').val('');
	$('input[name=siteId]').val('');
	$('input[name=pid]').val('');
	$('input[name=funcSeq]').val('');
	$('input[name=siteId]').val('');
})
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$('input[name=funcType]').val(txt);
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
})
</script>
</html>
