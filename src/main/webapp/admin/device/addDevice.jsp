<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
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
	<script type="text/javascript">
    function back(){
	   window.location.href ="<%=path%>/adminHospitalAction.action?";
    }
    function verifyHospitalInfo(){
    	if(document.form1.name.value==""){
    		alert("医院名称不能为空");
    		return false;
    	}
    	else if(document.form1.myFile.value==""){
    		alert("请选择医院头像");
    		return false;
    	}
    	else if(document.form1.telephone.value==""){
    		alert("医院电话热线不能为空");
    		return false;
    	}
    	else if(!validate(document.form1.telephone.value)){
    		alert("医院电话热线格式不符合要求");
    		return false;
    	}
    	else if(document.form1.address.value==""){
    		alert("医院地址不能为空");
    		return false;
    	} 
    	return true;
    }
    function validate(telephone){
		 var reg = new RegExp("/^0[\d]{2,3}-[\d]{7,8}$/");
		 if((/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test(telephone.trim()))){
			 return true;
		 }
		 else{
			 return false
		 }
	 }
   </script>
   <style type="text/css">
   #shuoming {
	color: blue;
	margin-left: 40px;
	margin-top: 30px;
	border-bottom: 1px solid #D7D7D7;
	}
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
  </head>
  
  <body>
     <div style="margin-top:10px;margin-left:5px;">
              <div id="shuoming">
				<b>新增设备信息</b><font style="color:red">（*号为必填）</font>
				&nbsp;<font style="color:red"><s:property value="addHospitalTip"/></font>
			</div>
            <form action="<%=path%>/admin/saveOrUpdateDevice.do" name="form1" method="post" 
            enctype="multipart/form-data" onsubmit="return verifyHospitalInfo();">
            <div style="margin-left:80px;margin-top:30px;">
				<font color=red>*</font> 设备名称：<input type="text" id="hospitalName"
					name="name" class="inputTxt">
			</div>
			<div style="margin-left:80px;margin-top:10px;">
				<font style="color:red">*</font>设备类型： <select name="type"
					class="inputTxt">
					<option value="" style="color: #b6b6b6" disabled selected>请选择设备</option>
					<option value="个人设备">个人设备</option>
					<option value="宿舍公有">宿舍公有</option>
				</select>
			</div>
			<div style="margin-left:80px;margin-top:13px;">
				<font style="color:red">*</font>设备图片： <input type="file" name="myFile" id="myFile"
					class="inputTxt" style="height:34px;"> 
			</div>
           <div style="margin-left:80px;margin-top:13px;">
				 &nbsp;设备模型： <input type="file" name="myFile" id="myFile"
					class="inputTxt" style="height:34px;"> 
			</div>	
			<div style="margin-left:80px;margin-top:10px;">
				<font color=red>*</font> 设备功能描述：<br>
				<textArea  id="hospitalBrief"
					name="brief" 
					class="textAreaTxt">
					</textArea>
			</div>
			     <input type="submit" value="新增" style="margin-top:10px;margin-left:130px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:50;position:absolute;background:#0090DB;color:#FFEDF1;"/>&nbsp;
			     <input type="button" value="返回" onclick="back()"
         style="margin-top:10px;margin-left:210px;background:#F7B52C;width:50;height:30;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:50;position:absolute;background:#0090DB;color:#FFEDF1;" onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" /> 
           </form>
      </div>
   
     
  </body>
</html>
