<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
    function back(id){
	   window.location.href ="<%=path%>/listDevice.do?pageIndex="+id+"&pageSize="+10;
    }
   </script>
   <style>
     .textAreaTxt{
      outline:none;
     border:1px solid #CCC;
     -webkit-box-shadow:#DFDFDF 0 1px 2px 0 inset;
     box-shadow:#DFDFDF 0 1px 2px 0 inset;
     background:#fff;
     border-radius:3px;
     overflow:hidden;
     margin-top:5px;
     width:290px;
     height:150px;
     text-align:left;
     color:#EF972B;
     font-size:15px;
     }
     .back_button{
   font-weight:bolder;
   font-size:13px;
   border:3px solid #0090DB;
   background:#0090DB;
   color:#FFEDF1; 
   font-color:#fff;
   margin-top:8px;
   }
   .back_button:hover{
   color:#fff;
   text-decoration:none;
   background-color:#0074A6;
   }
     </style>
  </head>
  <body>
     <div style="margin-top:10px;margin-left:15px;float:left;">
           <font color=#65C0EE size=5>${device.name}</font><br>
           <font color=#818181 size=3>设备名称：</font> 
           <font color=#EF972B size=3>${device.name}</font><br>
           <font color=#818181 size=3>设备类型：</font> 
           <font color=#EF972B size=3>${device.type}</font><br>
           <font color=#818181 size=3>设备功能描述：</font> <br>
           <textArea  id="deviceBrief"
					name="brief" 
					class="textAreaTxt">${device.description}</textArea><br>
		  <input type="button" value="返回" onclick="back(${pageIndex})" 
        class="back_button"  /> 
      </div>
  </body>
</html>
