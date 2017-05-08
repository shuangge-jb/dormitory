<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error"%>
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
	 function back(){
          var pageSize = 5;
          var pageIndex = 1;
          window.location.href ="<%=path%>/forwardParametersList.do?pageIndex="+pageIndex+"&pageSize="+pageSize;
       }
	var flag=false;
    function edit(){
    	 $('#paramaterName').attr("disabled",false);
    	  $('#type').attr("disabled",false);
    	  $('#description').attr("disabled",false);
    	  flag=true;
    }
    function verifyParameterInfo(){
    	if(!flag){
    		$('#myModal').modal('show');
    		$(".modal-body").text("先点击过编辑按钮，才能点击保存按钮！");
    		return false;
    	}
    	if(document.form1.paramaterName.value==""){
    		$('#myModal').modal('show');
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
    	return true;
    }
     
    function save(){
    	if(!verifyParameterInfo()){
    		return false;
    	}
    	$('#paramaterName').attr("disabled",false);
  	    $('#type').attr("disabled",false);
  	    $('#description').attr("disabled",false);
  	  return true;
    }
   </script>
  </head>
  
  <body>
  <div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">修改${data.paramaterName}参数页面</h3>
		</div>
		<div class="panel-body">
		  <form action="#" name="form1" method="post" 
             onsubmit="return save();">
             <input type="hidden" name="interfaceId" value="${data.interfaceId }"/>
             <input type="hidden" name="deviceId" value="${data.deviceId }"/>
            <div style="margin-left:80px;margin-top:30px;">
				<font color=red>*</font>参数名称：<input type="text" id="paramaterName"
					name="paramaterName" class="inputTxt" value="${data.paramaterName}" disabled="true">
			</div>
			<div style="margin-left: 80px; margin-top: 30px;">
				<font color=red>*</font> 参数类型：<input type="text" id="type"
					name="type" class="inputTxt" value="${data.paramaterName}" disabled="true">
			</div>
			<div style="margin-left: 80px; margin-top: 10px;">
				<font color=red>*</font> 参数描述：<br>
				<textArea name="description" id="description" class="textAreaTxt"
					 onkeyup="keyPress()" onblur="keyPress()" disabled="true"></textArea>
				<font color="gray" size=2><label id="miaoshu">&nbsp;你还可以输入100个字</label></font>
			</div>
			<span style="margin-left:79px;"><font color="red">${status}</font></span>

	 <div class="button-group">
    <button type="button" class="button button-pill button-action" onclick="edit();">编辑</button>
    <button type="submit" class="button button-pill button-action" >保存</button>
    <button type="button" class="button button-pill button-action" onclick="back()">返回</button>
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
