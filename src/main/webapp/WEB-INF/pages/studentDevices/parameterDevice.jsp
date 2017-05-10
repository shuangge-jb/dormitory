<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript">	
$(document).ready(function(){  
	var id = $("#interfaceId").val();
   $.ajax({
	type:"post",
    url:'<%=path%>/student/listUserParamByInterfaceId.do',
    dataType:"json",
    data:{interfaceId:id},
    success:function(data){	
    	alert(data);
    	for(var i=0;i<data.length;i++){
    	  var li;
 	      if(data[i].type=='string'||data[i].type=='integer'||data[i].type=='long'){
 	    	li=" <li class=\"pb10\"><label class=\"form-label\"><b class=\"c_orange\">* </b>"+
 	    	   "</b>"+data[i].paramaterName+"&nbsp;:&nbsp;</label><input type=\"text\" class=\"inputTxt\" "+
               "name="+data[i].paramaterName+">&nbsp&nbsp<span class=\"checkDescription\" onclick=\"checkParameter('"+data[i].description+"')\">查看描述<span></li>";
            $('.form-content').append(li);
 	      }
 	      else if(data[i].type=='datetime'){
 	    	 li=" <li class=\"pb10\"><label class=\"form-label\"><b class=\"c_orange\">* </b>"+
	    	   "</b>"+data[i].paramaterName+"&nbsp;:&nbsp;</label><input type=\"date\" class=\"inputTxt\" "+
             "name="+data[i].paramaterName+">&nbsp&nbsp<span class=\"checkDescription\" onclick=\"checkParameter('"+data[i].description+"')\">查看描述<span></li>";
          $('.form-content').append(li);  
 	      }
    	}
    	var endLi = "<li class=\"pb10\"><label class=\"form-label\">&nbsp;</label>"+
                    "<input type=\"submit\"  class=\"registerSubmit\" value=\"提交\"></li>";
    	$('.form-content').append(endLi);
    },
    error:function(data){
    	console.log(data);
    }
    
  })
})
</script>
<style type="text/css">
  .register-main{
  background: #F6F6F6;
  padding:24px 120px 40px 150px;
  }
  .checkDescription{
    color:#929699
  }
  .checkDescription:hover{
  color:red;
  }

  .register-form{ 
   padding:24px 34px 40px 44px;
   border: 1px solid #D7D7D7;
   background:#fff;
   min-height:380px;
   }
   .c_orange{color:#FF6700}
   ul{list-style:none}
   .form-content{padding: 40px 30px 40px 40px;}
   .pb10{padding-bottom:10px}
   .form-label{display: block;float: left;font-size: 14px;text-align:right;width: 115px;}
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
     .passwordStrength{
      width:360px;
      padding-left:6px;
      padding-top:4px;
      padding-bottom:5px;
      border:1;
      cellspacing:0;
      font-size:12px;
      cellpadding:1;
      bordercolor:#F6F6F6;
      overflow:hidden;
      height:28px;
  
     }
    .registerSubmit{
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
    }
    .registerSubmit:hover {
    text-shadow:0 0 2px rgb(255,255,255);
    box-shadow:inset 0 1px 0 rgb(86,174,251),0 0 10px 3px rgba(74,162,241,0.5);
}
.footer-content{height:35px;width:100%;line-height: 30px;padding-top:15px;}
.top_h5{
     font-size:18px;
     line-height:33px;
     color:#006DB3;
     margin-left:420px;
     }
</style>
</head>
<body>
<body >
    <jsp:include page="head.jsp"></jsp:include>	
		<div class="register-main">
		<form action="<%=path%>/student/invokeInterface.do" method="post" 
		enctype="multipart/form-data" >
		<div class="register-form">
			<h3 class="content-hd"><b>${face.interfaceName}参数填写信息</b><label class="c_orange">(*为必填项)</label></h3>
			 <ul class="form-content">
			 </ul>
		</div>
		<input type="hidden" id="interfaceId" name="interfaceId" value="${face.interfaceId}">
		</form>
		<jsp:include page="foot.jsp"></jsp:include>
		</div>
</body>
</html>
