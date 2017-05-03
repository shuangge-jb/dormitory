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
    function back(id){
    	 window.location.href ="<%=path%>/listDevice.do?pageIndex="+id+"&pageSize="+10;
    }
    function edit(){
    	 $('#name').attr("disabled",false);
    	  $('#img').attr("disabled",false);
    	  $('#description').attr("disabled",false);
    	  $('#model').attr("disabled",false);
    	  $('#type').attr("disabled",false);
    	  $('#savebtn').attr("disabled",false);
    }
    function verifyDeviceInfo(){
    	if(document.form1.name.value==""){
    		alert("设备名称不能为空");
    		return false;
    	}
    	else if(document.form1.type.value==""){
    		alert("请选择设备类型");
    		return false;
    	} 
    	else if(document.getElementById('description').value==""){
    		alert("描述不能为空");
    		return false;
    	} 
    	return true;
    }
     
    function save(){
    	if(!verifyDeviceInfo()){
    		return false;
    	}
      $('#name').attr("disabled",false);
   	  $('#img').attr("disabled",false);
   	  $('#description').attr("disabled",false);
   	  $('#model').attr("disabled",false);
   	  $('#type').attr("disabled",false);
  	  return true;
    }
   </script>
  </head>
  
  <body>
   <form action="<%=path%>/admin/updateDevice.do" method="post" name="form1" enctype="multipart/form-data" onsubmit="return save();" >
  <div style="float:left;">
     <div style="margin-left:15px;">
           <font color=#818181 size=4>设备名称：</font> 
             <input type="text"  value="${device.name}" id="name"
					name="name" style="width:200px;height:25px;border-radius:5px;color:#65C0EE ;font-size:15px;" disabled="true"><br>
          <font color=#818181 size=4>图片路径：</font> 
          <input type="text" name="imgPath" id="imgPath"
					style="width:200px;height:25px;border-radius:5px;color:#EF972B;font-size:15px;maigin-top:25px;" value="${device.imgPath}" disabled="true"><br>
          <font color=#818181 size=4>更改图片：</font> 
           <input type="file" name="img" id="img"
					style="width:200px;height:25px;border-radius:5px;color:#EF972B;font-size:15px;maigin-top:25px;" value="${device.imgPath}" disabled="true"><br>
           <font color=#818181 size=4>模型路径：</font> 
          <input type="text" name="modelPath" id="modelPath"
					style="width:200px;height:25px;border-radius:5px;color:#EF972B;font-size:15px;maigin-top:25px;" value="${device.modelPath}" disabled="true"><br>
           <font color=#818181 size=4>更改设备：</font> 
           <select name="type" id="type"
					style="width:200px;border-radius:5px;height:25px;color:#EF972B;font-size:15px;" disabled="true">
					<option value="个人私有" <c:if test="${device.type.equals('个人私有')}"> selected</c:if> >个人私有</option>
					<option value="宿舍公有" <c:if test="${device.type.equals('宿舍公有')}"> selected</c:if> >宿舍共有</option>	
				</select><br>
           <font color=#818181 size=4>设备模型：</font> 
            
           <input type="file" name="model"  id="model"
					style="width:200px;height:25px;border-radius:5px;color:#EF972B;font-size:15px;" value="111" disabled="true"><br>
           <font color=#818181 size=4>设备功能描述：</font> <br>
           <textArea   name="description"  onkeyup="keyPress()" onblur="keyPress()"
           id="description" style="color:#EF972B;overflow-x:hidden;overflow-y:hidden;font-size:15px;width:290px;height:150px;border-radius:5px;"  disabled="true">${device.description}</textArea>
		   <font color="gray" size=2><label id="miaoshu">&nbsp;</label></font>
           <input type="hidden" name="deviceId" value="${device.deviceId}"/>
         <input type="hidden" name="pageIndex" value="${pageIndex}"/>
      </div>
      <span style="margin-left:10px;"><font color="red">${status}</font></span>
      <div>
      <input type="button" value="编辑" onclick="edit();"
         style="background:#F7B52C;width:40;height:30;margin-left:15px;margin-top:10px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:100;position:absolute;background:#0090DB;color:#FFEDF1;" onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" />
				<input type="submit" value="保存" id="savebtn"
         style="background:#F7B52C;width:40;height:30;margin-left:110px;margin-top:10px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:100;position:absolute;background:#0090DB;color:#FFEDF1;" onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';"  disabled="true"/>
				 <input type="button" value="返回" onclick="back(${pageIndex})"
         style="background:#F7B52C;width:40;height:30;margin-left:210px;margin-top:10px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:100;position:absolute;background:#0090DB;color:#FFEDF1;" onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" />
				</div>
				</div>
		<div id="headImg" style="margin-top:20px;margin-left:420px;">
          <img src="${device.imgPath}" width="100px" height="120px" alt="deviceImg"/>
       
    </div>
    </form>
  </body>
</html>
