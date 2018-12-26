var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false,
				enable : true,
				showLine : true,
				addHoverDom: addHoverDom
				
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				removeTitle: "删除",
				renameTitle: "修改"
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove,
				onRename: onRename
			}
		};

var zNodes =[
	{ id:1, pId:0, name:"日常办公", type:"1", open:false},
	{ id:11, pId:1, name:"叶子节点 1-1", type:"2"},
	{ id:12, pId:1, name:"叶子节点 1-2", type:"2"},
	{ id:13, pId:1, name:"叶子节点 1-3", type:"2"},
	{ id:2, pId:0, name:"公文起草", type:"1", open:false},
	{ id:21, pId:2, name:"叶子节点 2-1", type:"2"},
	{ id:22, pId:2, name:"叶子节点 2-2", type:"2"},
	{ id:23, pId:2, name:"叶子节点 2-3", type:"2"},
	{ id:3, pId:0, name:"信息管理", type:"1", open:false},
	{ id:31, pId:3, name:"叶子节点 3-1", type:"2"},
	{ id:32, pId:3, name:"叶子节点 3-2", type:"2"},
	{ id:33, pId:3, name:"叶子节点 3-3", type:"2"}
];

var log, className = "dark";
function beforeDrag(treeId, treeNodes) {
	return false;
}
function beforeEditName(treeId, treeNode) {
	className = (className === "dark" ? "":"dark");
	showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	var zTree = $.fn.zTree.getZTreeObj("right");
	zTree.selectNode(treeNode);
	setTimeout(function() {
		if (confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？")) {
			setTimeout(function() {
				zTree.editName(treeNode);
			}, 0);
		}
	}, 0);
	var div = $("#propertyForm");
    if (div.is(":hidden")) {
        div.show();
        div.css("left", document.body.scrollLeft + event.clientX + 1);
        div.css("top", document.body.scrollLeft + event.clientY + 10);
    } else {
        div.hide();
    }
	return false;
}
function beforeRemove(treeId, treeNode) {
	className = (className === "dark" ? "":"dark");
	showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	var zTree = $.fn.zTree.getZTreeObj("right");
	zTree.selectNode(treeNode);
	return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
}
function onRemove(e, treeId, treeNode) {
	showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
}
function beforeRename(treeId, treeNode, newName, isCancel) {
	className = (className === "dark" ? "":"dark");
	showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
	if (newName.length == 0) {
		setTimeout(function() {
			var zTree = $.fn.zTree.getZTreeObj("right");
			zTree.cancelEditName();
			alert("节点名称不能为空.");
		}, 0);
		return false;
	}
	return true;
}
function onRename(e, treeId, treeNode, isCancel) {
	console.log("更名成功-回调");
	showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
}
function showLog(str) {
	if (!log) log = $("#log");
	log.append("<li class='"+className+"'>"+str+"</li>");
	if(log.children("li").length > 8) {
		log.get(0).removeChild(log.children("li")[0]);
	}
}
function getTime() {
	var now= new Date(),
	h=now.getHours(),
	m=now.getMinutes(),
	s=now.getSeconds(),
	ms=now.getMilliseconds();
	return (h+":"+m+":"+s+ " " +ms);
}

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
		+ "' title='add node' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_"+treeNode.tId);
	if (btn) btn.bind("click", function(){
		var zTree = $.fn.zTree.getZTreeObj("right");
		zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
		return false;
	});
};
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_"+treeNode.tId).unbind().remove();
};
function selectAll() {
	var zTree = $.fn.zTree.getZTreeObj("right");
	zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
}