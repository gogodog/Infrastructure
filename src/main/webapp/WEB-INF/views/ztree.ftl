<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/login/css/base.css" />
<link rel="stylesheet" href="/login/css/info-mgt.css" />
<link rel="stylesheet" href="/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript"src="/login/js/jquery.js"></script>
<script type="text/javascript" src="/ztree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/ztree/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="/ztree/jquery.ztree.exedit.js"></script>
<script type="text/javascript" src="/ztree/initZtree.js"></script>
<SCRIPT type="text/javascript">
	$(document).ready(function(){
		console.log(${zNodes});
		$.fn.zTree.init($("#right"), setting, JSON.parse('${zNodes}'));
		$("#selectAll").bind("click", selectAll);
	});
</SCRIPT>
<title>基础结构平台</title>
</head>

<body>
<div class="title"><h2>权限树</h2></div>
<div class="query">
    <div class="query-btn ue-clear">
    	<a href="javascript:;" class="confirm">查询</a>
        <a href="javascript:;" class="clear">清空条件</a> 
    </div>
</div>
<div class="zTreeDemoBackground left">
		<ul id="right" class="ztree"></ul>
</div>

<div class="pagination ue-clear"></div>
</body>

<script type="text/javascript">

</script>
</html>
