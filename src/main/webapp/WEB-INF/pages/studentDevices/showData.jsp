<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" />
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script src="<%=path%>/js/json-to-table.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	var data=$("#data").val();
	console.log("string:"+data);
	if(data==null||data==""){
		$("#appendTable").append("<div style='margin-left: 80px; margin-top: 10px;'><strong style='font-size:larger;#F00'>找不到数据</strong></div>");
	}else{
		console.log("data:"+data);
		var json=  eval(data);
		console.log("json array:"+json);
		for(var i=0;i<json.length;i++){
			for(var key in json[i]){
				console.log(key+":"+json[i][key]);
			}
		}
	var jsonHtmlTable = ConvertJsonToTable(json, 'jsonTable','table table-striped table-bordered',null);
	console.log(jsonHtmlTable);
	$("#appendTable").append(jsonHtmlTable);
	//$("#jsonTable").css("minHeight",380);
	$("#jsonTable").css("style",'margin-left: 80px; margin-top: 10px;');
	}
					});
				
	function AddFavorite(title, url) {
		try {
			window.external.addFavorite(url, title);
		} catch (e) {
			try {
				window.sidebar.addPanel(title, url, "");
			} catch (e) {
				alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
			}
		}
	}
	
	function back(){
		window.location.href="<%=path%>/student/forwardParam.do?interfaceId=${functionId}";
	}
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
#myDormitoryDevice {
	color: #fff;
	text-decoration: none;
	background-color: #0074A6;
	height: 50px;
	line-height: 51px;
	line-height: 54px\9;
	line-height: 52px\0;
	border-bottom: 0;
}
#backIt {
	width: 40;
	height: 128px;
	position: absolute;
	top: 230.2px;
	margin-left: 148px;;
	position: fixed;
	background-color: #A6BDC5;
	text-align: center;
}
#backIt img {
	padding-left: 3px;
	width: 25px;
	height: 25;
	text-align: center;
}
.deviceName {
	font-size: 16px;
	color: #FF8D75;
}

#brief {
	margin-top: 20px;
	margin-left: 40px;
	width: 200;
	color:#333333;
}
#page {
	padding-top: 10px;
}
#page a {
	color: blue
}
#page a:hover {
	color: #0090CE;
}
</style>
</head>
<body bgcolor="#FFFFFF">
<jsp:include page="head.jsp"></jsp:include>
<h3  class="text-center">来自${source}的数据</h3>
<input type="hidden" name="data" id="data" value='${data }'/>
	<div id="appendTable"  style='margin-left: 80px; margin-top: 10px;'></div>
	<div   style="margin-left: 80px; margin-top: 10px;">
	<button class="btn btn-info" onclick="back()">返回参数页面</button>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>

</html>
