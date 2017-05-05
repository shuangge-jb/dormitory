<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=path%>/js/jquery-1.8.3.min.js"></script> 
	<script src="<%=path%>/js/jquery-2.1.4.min.js"></script> 
    <script src="<%=path%>/js/bootstrap.min.js"></script> 
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/css/buttons.css">
    <style>
     .inputTxt{
     outline:none;
     border:1px solid #CCC;
     padding:5px;
     -webkit-box-shadow:#DFDFDF 0 1px 2px 0 inset;
     box-shadow:#DFDFDF 0 1px 2px 0 inset;
     width:200px;color:#666;height:28px;
     background:#fff;
     border-radius:3px;
     line-height:28px;
     overflow:hidden;}
     .textAreaTxt{
      outline:none;
     border:1px solid #CCC;
     -webkit-box-shadow:#DFDFDF 0 1px 2px 0 inset;
     box-shadow:#DFDFDF 0 1px 2px 0 inset;
     color:#666;
     background:#fff;
     border-radius:3px;
     line-height:28px;
     overflow:hidden;
     margin-top:5px;
     width:290px;
     height:150px;
     }
    </style>
	<script type="text/javascript">
	function keyPress() //textArea输入长度处理   
		    {  
				var description = document.getElementById("description").value;  
		        var len; //记录剩余字符串的长度   
		        if (description >=100) //textarea控件不能用maxlength属性，就通过这样显示输入字符数了   
		        {  
		            document.getElementById("description").value = description.substr(0, 100);  
		            len = 0;  
		        } else {  
		            len = 100 - description.length;  
		        }  
		        var show = "你还可以输入" + len + "个字";  
		        document.getElementById("miaoshu").innerText = show;   
	 }
	function back(pageIndex,deviceId,backPageId){
	      var pageSize = 10;
	      window.location.href ="<%=path%>/listInterfaceByDeviceId.do?deviceId="+deviceId+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&hiddenPageIndex="+backPageId;
	    }
    function edit(){
    	 $('#interfaceName').attr("disabled",false);
    	  $('#interfaceUrl').attr("disabled",false);
    	  $('#source').attr("disabled",false);
    	  $('#method').attr("disabled",false);
    	  $('#description').attr("disabled",false);
    	  $('#savebtn').attr("disabled",false);
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
     
    function save(){
    	if(!verifyInterfaceInfo()){
    		return false;
    	}
      $('#interfaceName').attr("disabled",false);
   	  $('#interfaceUrl').attr("disabled",false);
   	  $('#source').attr("disabled",false);
   	  $('#method').attr("disabled",false);
   	  $('#description').attr("disabled",false);
   	  $('#savebtn').attr("disabled",false);
  	  return true;
    }
   </script>
  </head>
  
  <body>
  <div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">修改${device.name}的功能</h3>
		</div>
		<div class="panel-body">
		  <form action="#" name="form1" method="post" 
             onsubmit="return save();">
            <div style="margin-left:80px;margin-top:30px;">
				<font color=red>*</font> 功能名称：<input type="text" id="interfaceName"
					name="interfaceName" class="inputTxt" value="${data.interfaceName}" disabled="true">
			</div>
			<div style="margin-left:80px;margin-top:30px;">
				<font color=red>*</font> 功能的url：<input type="text" id="interfaceUrl"
					name="interfaceUrl" class="inputTxt" value="${data.interfaceUrl}" disabled="true">
			</div>
			<div style="margin-left:80px;margin-top:30px;">
				<font color=red>*</font> 功能的来源：<input type="text" id="source"
					name="source" class="inputTxt" value="${data.source}" disabled="true">
			</div>
			<div style="margin-left: 80px; margin-top: 30px;">
					<font color=red>*</font> 方法类型： <select name="method" id="method"
						class="inputTxt" disabled="true">
						<option value="post"
							<c:if test="${data.method.equals('post')}"> selected</c:if>>post</option>
						<option value="get"
							<c:if test="${data.method.equals('get')}"> selected</c:if>>get</option>
					</select>
			</div>
				<div style="margin-left:80px;margin-top:10px;">
				<font color=red>*</font> 功能描述：<br>
				<textArea 
					name="description" id="description"
					class="textAreaTxt" 
					onkeyup="keyPress()" onblur="keyPress()" disabled="true">${data.description}</textArea>
					<font color="gray" size=2><label id="miaoshu"></label></font>
			</div>
			<span style="margin-left:79px;"><font color="red">${status}</font></span>
				<div>
					<input type="button" value="编辑" onclick="edit();"
						style="background: #F7B52C; width: 40; height: 30; margin-left: 79px;  font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 100; position: absolute; background: #0090DB; color: #FFEDF1;"
						onMouseOver="this.style.backgroundColor='#EF972B';"
						onMouseOut="this.style.backgroundColor ='#0090DB';" /> <input
						type="submit" value="保存" id="savebtn"
						style="background: #F7B52C; width: 40; height: 30; margin-left: 174px;  font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 100; position: absolute; background: #0090DB; color: #FFEDF1;"
						onMouseOver="this.style.backgroundColor='#EF972B';"
						onMouseOut="this.style.backgroundColor ='#0090DB';"
						disabled="true" /> <input type="button" value="返回"
						onclick="back(${pageIndex},${device.deviceId},${backPageIndex})"
						style="background: #F7B52C; width: 40; height: 30; margin-left: 274px;  font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 100; position: absolute; background: #0090DB; color: #FFEDF1;"
						onMouseOver="this.style.backgroundColor='#EF972B';"
						onMouseOut="this.style.backgroundColor ='#0090DB';" />
				</div>
			</form>
		</div>
			
  </div>
  <!-- 错误提示框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					错误提示
				</h4>
			</div>
			<div class="modal-body">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">确定
				</button>
			</div>
		</div>
	</div>
</div>
  </body>
</html>
