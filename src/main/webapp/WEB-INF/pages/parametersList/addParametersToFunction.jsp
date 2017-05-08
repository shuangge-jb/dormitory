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
     function back(){
          var pageSize = 5;
          var pageIndex = 1;
          window.location.href ="<%=path%>/forwardParametersList.do?pageIndex="+pageIndex+"&pageSize="+pageSize;
       }
     function verifyParameterInfo(){
    	if(document.form1.paramaterName.value==""){
    		$('#myModal').modal('show');
    		//alert("设备名称不能为空");
    		$(".modal-body").text("参数名称不能为空！");
    		return false;
    	}
    	else if(document.form1.type.value==""){
    		$('#myModal').modal('show');
    		$(".modal-body").text("参数类型不能为空！");
    		return false;
    	}
    	else if(document.getElementById('description').value==""){
    		$('#myModal').modal('show');
    		$(".modal-body").text("参数描述不能为空！");
    		return false;
    	} 
    	 $('#interfaceId').attr("disabled",false);
   	     $('#deviceId').attr("disabled",false);
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
			<b>新增${device.name}的${face.interfaceName}的功能信息</b><font style="color: red">（*号为必填）</font>
			&nbsp;<font style="color: red">${status}</font>
		</div>
		<form action="<%=path %>/admin/saveParamater.do?pageIndex=${pageIndex}&pageSize=10" name="form1" method="post"
			enctype="multipart/form-data"
			onsubmit="return verifyParameterInfo();">
			<div>
			<input type="hidden" name="deviceId"
				id="deviceId" value="${deviceId}"/>
			<input type="hidden" name="interfaceId"
				id="interfaceId" value="${functionId}"/>
			</div>
			<div style="margin-left: 80px; margin-top: 30px;">
				<font color=red>*</font> 参数名称：<input type="text" id="paramaterName"
					name="paramaterName" class="inputTxt" placeholder="如:userName">
			</div>
			<div style="margin-left: 80px; margin-top: 30px;">
				<font color=red>*</font> 参数类型：<input type="text" id="type"
					name="type" class="inputTxt" placeholder="如:String/Integer">
			</div>
			<div style="margin-left: 80px; margin-top: 30px;">
				<font color=red>*</font> 参数所属接口名：<input type="text" name="interfaceName"
				id="interfaceName" class="inputTxt"  value="${functionName}" disabled="true">
			</div>
			<div style="margin-left: 80px; margin-top: 30px;">
				<font color=red>*</font> 参数所属设备：<input type="text" name="deviceId"
				id="deviceId"	class="inputTxt"  value="${deviceName}" disabled="true">
			</div>
			<div style="margin-left: 80px; margin-top: 10px;">
				<font color=red>*</font> 参数描述：<br>
				<textArea name="description" id="description" class="textAreaTxt"
					placeholder="描述清楚该参数的用途" onkeyup="keyPress()" onblur="keyPress()"></textArea>
				<font color="gray" size=2><label id="miaoshu">&nbsp;你还可以输入100个字</label></font>
			</div>
			<input type="submit" value="新增"
				style="margin-top: 10px; margin-left: 130px; font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 50; position: absolute; background: #0090DB; color: #FFEDF1;"
				onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" />&nbsp; <input
				type="button" value="返回"
				onclick="back();"
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
