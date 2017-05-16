<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
.lostFondMain{
  background: #F6F6F6;
  padding:24px 120px 0px 150px;
  }
   .lostFond-form{ 
   padding:10px 10px 40px 10px;
   border: 1px solid #D7D7D7;
   background:#fff;
   height:600px;
   }
   .content-hd{
     color: #0099FE;
     font-size: 14px;
     border-bottom: 1px solid #E3E3E3;
     height:30px;
     line-height:30px;
     padding-right: 10px;
     margin-bottom:20px;}
     .c_orange{color:#FF6700}
  #repairRecord{
   width:87px;
   height:40px;
   background:#E0F1FE;
   border:1px solid #0497FF;
   border-bottom:0px;
   font-size:16px;
   font-weight:bolder;
   color:#029AFF;
}
#applyRepair{
   width:87px;height:40px;
   background:#E0F1FE;border:1px solid #0497FF;
   border-bottom:0px;font-size:16px;
   font-weight:bolder;color:#029AFF;
   }
    .changeSubmit{
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
    .changeSubmit:hover {
    text-shadow:0 0 2px rgb(255,255,255);
    box-shadow:inset 0 1px 0 rgb(86,174,251),0 0 10px 3px rgba(74,162,241,0.5);
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
     ul{
     list-style:none;
     }
     .pb10{padding-bottom:10px}
</style>
<title>My JSP 'Main.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" />
<script src="<%=path%>/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/mydevice/mydevicehead.css" media="all"/>
<script type="text/javascript">
$(document).ready(function() {
	 $('#userInfo').addClass("titleTip");
	 })
 
   function verifyPassword(){
	    	if(document.form1.password.value==""){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("密码不能为空");
	    		return false;
	    	}
	    	else if(document.form1.password1.value==""){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("确认密码不能为空");
	    		return false;
	    	} 
	    	else if(document.form1.password.value!=document.form1.password1.value){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("两次密码不一致");
	    		return false;
	    	} 
	  
	    	return true;
	    }

 
   function goingUserInfo(studentId){
	 window.location.href="<%=path%>/student/getStudentInfo.do?studentId="+studentId;  
   }
   function changeUserPassword(){
	   window.location.href="#";
   }
</script>

<body>
<jsp:include page="title.jsp"></jsp:include>
 <div class="lostFondMain">
 <div class="lostFond-form" style="min-height:380px;">
   <h3 class="content-hd"><b>&nbsp;&nbsp;修改密码</b>
   <label class="c_orange">(*你可以修改个人信息和密码)</label></h3>
   <div style="margin-left:40px;">
				<input type="button" id="repairRecord"
					value="个人信息" onclick="goingUserInfo(${studentId});"/>
				<input type="button"  id="applyRepair"
					value="修改密码"  onclick="changeUserPassword();"/>
	</div>
	<div style="border-bottom:1px solid #009AFF;width:790px;margin-left:6px;"></div>
     <form action="<%=path %>/student/updatePassword.do?studentId=${studentId}" method="post" name="form1"  onsubmit="return verifyPassword();" >
  <div style="float:left;">
     <div style="margin-left:15px;margin-top:15px;">
     <ul>
     <li class="pb10">  
      <font color=#818181 size=4>新密码：</font> 
             <input type="password"   id="password"
					name="password" class="inputTxt" ><br></li>
	 <li class="pb10"> <font color=#818181 size=4>确认新密码：</font> 
             <input type="password"   id="password1"
					name="password1" class="inputTxt" ><br></li>
	
     </ul>    </div>
      <span style="margin-left:10px;"><font color="red">${status}</font></span>
    <input type="submit"  class="changeSubmit" value="修改">
				</div>
   
    </form>
</div>
</div>
 <!-- 提示框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">温馨提示</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">确定
					</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 详细描述框（Modal） -->
	<div class="modal fade" id="myDetailModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">温馨提示</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">确定
					</button>
				</div>
			</div>
		</div>
	</div>
  <jsp:include page="foot.jsp"></jsp:include> 
</body>

</html>
