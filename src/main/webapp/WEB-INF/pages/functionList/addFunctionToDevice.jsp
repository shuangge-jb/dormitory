<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error"%>
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
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
<script type="text/javascript">
	 function back(pageIndex,deviceId,backPageId){
	      var pageSize = 10;
	      window.location.href ="<%=path%>/listInterfaceByDeviceId.do?deviceId="+deviceId+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&hiddenPageIndex="+backPageId;
	 }   
    function verifyInterfaceInfo(){
    	if(document.form1.interfaceName.value==""){
    		$('#myModal').modal('show');
    		//alert("设备名称不能为空");
    		$(".modal-body").text("功能名称不能为空！");
    		return false;
    	}
    	else if(document.form1.interfaceUrl.value==""){
    		$('#myModal').modal('show');
    		$(".modal-body").text("功能URL不能为空！");
    		return false;
    	}
    	else if(document.form1.source.value==""){
    		$('#myModal').modal('show');
    		$(".modal-body").text("功能接口来源不能为空！");
    		return false;
    	}
    	else if(document.form1.method.value==""){
    		$('#myModal').modal('show');
    		$(".modal-body").text("请选择post或get类型！");
    		return false;
    	} 
    	else if(document.getElementById('description').value==""){
    		$('#myModal').modal('show');
    		$(".modal-body").text("功能描述不能为空！");
    		return false;
    	} 
    	return true;
    }
    function keyPress() //textArea输入长度处理   
    {  
    	var description = document.getElementById("description").value;  
        var len; //记录剩余字符串的长度   
        if (description.length >=100) //textarea控件不能用maxlength属性，就通过这样显示输入字符数了   
        {  
            document.getElementById("description").value = description.substr(0, 100);  
            len = 0;  
        } else {  
            len = 100 - description.length;  
        }  
        var show = "你还可以输入" + len + "个字";  
        document.getElementById("miaoshu").innerText = show;   
    }
    
    function addFunction(){
    	var pageIndex=document.getElementById('hiddenPageIndex').value;
    	var pageSize=10;
    	  var hiddenPageIndex = document.getElementById('backhiddenPageIndex').value;  
    	  window.location.href ="<%=path%>/admin/saveInterface.do?pageIndex="+pageIndex+"&pageSize="+pageSize+"&hiddenPageIndex="+hiddenPageIndex;
    }
   </script>
<style type="text/css">
#shuoming {
	color: blue;
	margin-left: 40px;
	margin-top: 30px;
	border-bottom: 1px solid #D7D7D7;
}

.inputTxt {
	outline: none;
	border: 1px solid #CCC;
	padding: 5px;
	-webkit-box-shadow: #DFDFDF 0 1px 2px 0 inset;
	box-shadow: #DFDFDF 0 1px 2px 0 inset;
	width: 200px;
	color: #666;
	height: 28px;
	background: #fff;
	border-radius: 3px;
	line-height: 28px;
	overflow: hidden;
}

.textAreaTxt {
	outline: none;
	border: 1px solid #CCC;
	-webkit-box-shadow: #DFDFDF 0 1px 2px 0 inset;
	box-shadow: #DFDFDF 0 1px 2px 0 inset;
	color: #666;
	background: #fff;
	border-radius: 3px;
	line-height: 28px;
	overflow: hidden;
	margin-top: 5px;
	width: 290px;
	height: 150px;
}
</style>
</head>

<body>
	<div style="margin-top: 10px; margin-left: 5px;">
		<div id="shuoming">
			<b>新增${device.name}的功能信息</b><font style="color: red">（*号为必填）</font>
			&nbsp;<font style="color: red">${status}</font>
		</div>
		<form action="<%=path%>/admin/saveInterface.do?pageIndex=${pageIndex}&pageSize=10&backPageIndex=${backPageIndex}" name="form1" method="post"
			enctype="multipart/form-data"
			onsubmit="return verifyInterfaceInfo();">
			<input type="hidden" name="deviceId" value="${device.deviceId }" />
			<div style="margin-left: 80px; margin-top: 30px;">
				<font color=red>*</font> 功能名称：<input type="text"
					name="interfaceName" class="inputTxt" placeholder="如:查询电表电费">
			</div>
			<div style="margin-left: 80px; margin-top: 30px;">
				<font color=red>*</font> 功能的url：<input type="text"
					name="interfaceUrl" class="inputTxt" placeholder="如:功能来源哪个外部url">
			</div>
			<div style="margin-left: 80px; margin-top: 30px;">
				<font color=red>*</font> 功能的来源：<input type="text" name="source"
					class="inputTxt" placeholder="如:学校的电费系统">
			</div>
			<div style="margin-left: 80px; margin-top: 10px;">
				<font style="color: red">*</font>方法类型： <select name="method"
					class="inputTxt">
					<option value="" style="color: #b6b6b6" disabled selected>请选择post/get</option>
					<option value="post">post</option>
					<option value="get">get</option>
				</select>
			</div>
			<div style="margin-left: 80px; margin-top: 10px;">
				<font color=red>*</font> 功能描述：<br>
				<textArea name="description" id="description" class="textAreaTxt"
					placeholder="描述清楚该功能的作用" onkeyup="keyPress()" onblur="keyPress()"></textArea>
				<font color="gray" size=2><label id="miaoshu">&nbsp;你还可以输入100个字</label></font>
			</div>
			<input type="submit" value="新增"
				style="margin-top: 10px; margin-left: 130px; font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 50; position: absolute; background: #0090DB; color: #FFEDF1;"
				onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" />&nbsp; <input
				type="button" value="返回"
				onclick="back(${pageIndex},${device.deviceId},${backPageIndex})"
				style="margin-top: 10px; margin-left: 210px; background: #F7B52C; width: 50; height: 30; font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 50; position: absolute; background: #0090DB; color: #FFEDF1;"
				onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" />
		</form>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">错误提示</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">确定
					</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
