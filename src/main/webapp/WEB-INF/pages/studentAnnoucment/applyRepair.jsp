<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
	<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" media="all"/>
	<link rel="stylesheet" href="<%=path%>/css/mydevice/mydevicehead.css" media="all"/>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function AddFavorite(title, url) {
	    try {
	        window.external.addFavorite(url, title);
	    }
	    catch (e) {
	        try {
	            window.sidebar.addPanel(title, url, "");
	        }
	        catch (e) {
	            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
	        }
	    }
	}
	function goingRepairRecord(){
		window.location.href ="<%=path%>/repair/listRepairRecord.do?pageIndex=1&pageSize=2";
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
	function  verifyRepairInfo(){
		    	if(document.form1.studentId.value==""){
		    		$('#myModal').modal('show');
		    		//alert("设备名称不能为空");
		    		$(".modal-body").text("学生Id不能为空！");
		    		return false;
		    	}
		    	else if(document.form1.deviceName.value==""){
		    		$('#myModal').modal('show');
		    		$(".modal-body").text("设备名称不能为空！");
		    		return false;
		    	}
		    	else if(document.form1.dormitoryId.value==""){
		    		$('#myModal').modal('show');
		    		$(".modal-body").text("宿舍Id不能为空！");
		    		return false;
		    	}
		    	else if(document.form1.telephone.value==""){
		    		$('#myModal').modal('show');
		    		$(".modal-body").text("手机号码不能为空！");
		    		return false;
		    	}
		    	else if(!(/^1(3|4|5|7|8)\d{9}$/.test(document.form1.telephone.value))){
		    		$('#myModal').modal('show');
		    		$(".modal-body").text("手机号码格式不正确！");
		    		return false;
		    	}	
		    	else if(document.form1.content.value==""){
		    		$('#myModal').modal('show');
		    		$(".modal-body").text("简述不能为空");
		    		return false;
		    	} 
		    	else if(document.getElementById('description').value==""){
		    		$('#myModal').modal('show');
		    		$(".modal-body").text("功能描述不能为空！");
		    		return false;
		    	} 
		return true; 
	 }
	    
	</script>

  <style type="text/css">
  
#repairRecord{
   width:87px;
   height:40px;
   background:#E0F1FE;
   border:1px solid #0497FF;
   border-bottom:0px;
   font-size:16px;
   font-weight:bold;
   color:#029AFF;
}
#applyRepair{
   width:87px;height:40px;
   background:#E0F1FE;border:1px solid #0497FF;
   border-bottom:0px;font-size:16px;
   font-weight:bold;color:#029AFF;
   }
  #repair{
 color:#fff;text-decoration:none;background-color:#0074A6;height:50px;line-height:51px;line-height:54px\9;line-height:52px\0;border-bottom:0;
 }
   ul{list-style:none}
   .form-content{padding: 40px 30px 0px 40px;}
   .pb10{padding-bottom:10px}
   .form-label{display: block;float: left;font-weight:500;font-size: 13px;text-align:right;width: 115px;}
   .content-hd{
     color: #0099FE;
     font-size: 14px;
     border-bottom: 1px solid #E3E3E3;
     height:30px;
     line-height:30px;
     padding-right: 10px;}
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
	width: 275px;
	height: 120px;
}
 .repairSubmit{
     color:#fff;
    font-weight:bold;
    width:68px;
    height:30px;
    position:relative;
    background:-webkit-linear-gradient(top,rgb(74,162,241),rgb(52,119,182)) 1px 0 no-repeat, -webkit-linear-gradient(top,rgb(52,118,181),rgb(36,90,141)) left top no-repeat;
    background-size:66px 28px,68px 29px;
    border:none;
    border-top:1px solid rgb(52,118,181);
    border-radius:2px;
    box-shadow:inset 0 1px 0 rgb(86,174,251);
    text-shadow:0 1px 1px rgb(51,113,173);
    transition: all 200ms linear;
    margin-left:80px;
    }
  </style>
	
  </head>
  
  <body >
<jsp:include page="title.jsp"></jsp:include>
    <div class="register-main">
    <div class="register-form" style="min-height:380px;">
    <h3 class="content-hd"><b>我的报修</b><label class="c_orange">(*可以查看报修记录和申请报修)</label></h3>
    <div style="margin-left:40px;">
				<input type="button" id="repairRecord"
					value="报修记录" onclick="goingRepairRecord();"/>
				<input type="button"  id="applyRepair"
					value="现在报修"  onclick="applyRepair();"/>
	</div>
	<div style="border-bottom:0.5px solid #009AFF;width:790px;margin-left:6px;"></div>
	 <form action="#" onsubmit="return verifyRepairInfo();" name="form1" method="post">
	 <ul class="form-content">
	         <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   报修人Id：</label><input type="text" class="inputTxt" name="studentId"  id="studentId"
			  />
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   维修设备：</label><input type="text" class="inputTxt" name="deviceName"
			      id="deviceName"
			   placeholder="填写坏的设备名称" />
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   报修宿舍：</label><input type="text" class="inputTxt" name="dormitoryId"  id="dormitoryId"
			   placeholder="填写清楚报修的宿舍" />
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			     维修简述：</label><input type="text" class="inputTxt" name="content"  id="content"
			   maxlength="15"/>
			   
			 </li>
			  <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			     保修人号码：</label><input type="text" class="inputTxt" name="telephone"  id="telephone"
			   />
			 </li>
			 </ul>
			 <div style="margin-left: 80px; margin-top:-13px;">
				<font color=red>*</font> 报修描述：<br>
				<textArea name="description" id="description" class="textAreaTxt"
					placeholder="描述清楚报修情况" onkeyup="keyPress()" onblur="keyPress()"></textArea>
				<font color="gray" size=2><label id="miaoshu">&nbsp;你还可以输入100个字</label></font>
			</div>
		    <input type="submit"  class="repairSubmit" value="提交">
		    </form>
	<div style="clear:both;"></div>
	</div>
  <jsp:include page="foot.jsp"></jsp:include> 
</div>
<!-- 错误提示框（Modal） -->
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