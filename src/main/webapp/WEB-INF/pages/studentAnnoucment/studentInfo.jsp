<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
.lostFondMain {
	background: #F6F6F6;
	padding: 24px 120px 0px 150px;
}

.lostFond-form {
	padding: 10px 10px 40px 10px;
	border: 1px solid #D7D7D7;
	background: #fff;
	height: 600px;
}

.content-hd {
	color: #0099FE;
	font-size: 14px;
	border-bottom: 1px solid #E3E3E3;
	height: 30px;
	line-height: 30px;
	padding-right: 10px;
	margin-bottom: 20px;
}

.c_orange {
	color: #FF6700
}

#repairRecord {
	width: 87px;
	height: 40px;
	background: #E0F1FE;
	border: 1px solid #0497FF;
	border-bottom: 0px;
	font-size: 16px;
	font-weight: bolder;
	color: #029AFF;
}

#applyRepair {
	width: 87px;
	height: 40px;
	background: #E0F1FE;
	border: 1px solid #0497FF;
	border-bottom: 0px;
	font-size: 16px;
	font-weight: bolder;
	color: #029AFF;
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

ul {
	list-style: none;
}

.pb10 {
	padding-bottom: 10px
}
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
<link rel="stylesheet" href="<%=path%>/css/mydevice/mydevicehead.css"
	media="all" />
<script type="text/javascript">
$(document).ready(function() {
	 $('#userInfo').addClass("titleTip");
	 })
   function edit(){
  	 $('#name').attr("disabled",false);
  	  $('#dormitoryId').attr("disabled",false);
  	  $('#room').attr("disabled",false);
  	  $('#phoneNumber').attr("disabled",false);
  	  $('#email').attr("disabled",false);
  	  $('#bedId').attr("disabled",false);
  	  $('#img').attr("disabled",false);
  	  $('#savebtn').attr("disabled",false);
  }
   function verifyUserInfo(){
	    	if(document.form1.name.value==""){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("姓名不能为空");
	    		return false;
	    	}
	    	else if(document.form1.buildingName.value==""){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("宿舍楼不能为空");
	    		return false;
	    	} 
	    	else if(document.form1.room.value==""){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("宿舍房号不能为空");
	    		return false;
	    	} 
	    	else if(document.form1.phoneNumber.value==""){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("手机号不能为空");
	    		return false;
	    	} 
	    	else if(document.form1.email.value==""){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("邮箱不能为空");
	    		return false;
	    	} 
	    	/* else if(document.form1.img.value==""){
	    		  $('#myDetailModal').modal('show');
	    			//alert("设备名称不能为空");
	    			$(".modal-body").text("头像不能为空");
	    		return false;
	    	}  */
	    	return true;
	    }

   function save(){
   	if(!verifyUserInfo()){
   		return false;
   	}
    $('#name').attr("disabled",false);
	  $('#dormitoryId').attr("disabled",false);
	  $('#room').attr("disabled",false);
	  $('#phoneNumber').attr("disabled",false);
	  $('#email').attr("disabled",false);
	  $('#bedId').attr("disabled",false);
	  $('#img').attr("disabled",false);
 	  return true;
   }
   function goingUserInfo(studentId){
	 window.location.href="<%=path%>/student/getStudentInfo.do?studentId="+studentId;  
   }
   function changeUserPassword(){
	   window.location.href="<%=path%>/student/forwardChangePasswordPage.do?";
   }
</script>
<body>
	<jsp:include page="title.jsp"></jsp:include>
	<div class="lostFondMain">
		<div class="lostFond-form" style="min-height: 380px;">
			<h3 class="content-hd">
				<b>&nbsp;&nbsp;个人信息</b> <label class="c_orange">(*你可以修改个人信息和密码)</label>
			</h3>
			<div style="margin-left: 40px;">
				<input type="button" id="repairRecord" value="个人信息"
					onclick="goingUserInfo(${studentId});" /> <input type="button"
					id="applyRepair" value="修改密码" onclick="changeUserPassword();" />
			</div>
			<div
				style="border-bottom: 1px solid #009AFF; width: 790px; margin-left: 6px;"></div>
			<form
				action="<%=path %>/student/updateStudentInfo.do?studentId=${studentId}"
				method="post" name="form1" enctype="multipart/form-data"
				onsubmit="return save();">
				<div style="float: left;">
					<div style="margin-left: 15px;">
						<ul>
							<li class="pb10"><font color=#818181 size=4>学生姓名：</font> <input
								type="text" value="${student.name}" id="name" name="name"
								class="inputTxt" disabled="true"><br></li>
							<li class="pb10"><font color=#818181 size=4>宿舍楼：</font> <input
								type="text" value="${student.buildingName}" id="dormitoryId"
								name="buildingName" class="inputTxt" disabled="true"><br></li>
							<li class="pb10"><font color=#818181 size=4>房号：</font> <input
								type="text" value="${student.room}" id="room" name="room"
								class="inputTxt" disabled="true"><br></li>

							<li class="pb10"><font color=#818181 size=4>电话号码：</font> <input
								type="text" value="${student.phoneNumber}" id="phoneNumber"
								name="phoneNumber" class="inputTxt" disabled="true"><br></li>
							<li class="pb10"><font color=#818181 size=4>床号：</font> <select
								name="bedId" id="bedId" class="inputTxt" disabled="true">
									<option value="1"
										<c:if test="${student.bedId==1}">selected</c:if>>1号</option>
									<option value="2"
										<c:if test="${student.bedId==2}">selected</c:if>>2号</option>
									<option value="3"
										<c:if test="${student.bedId==3}">selected</c:if>>3号</option>
									<option value="4"
										<c:if test="${student.bedId==4}">selected</c:if>>4号</option>
							</select></li>
							<li class="pb10"><font color=#818181 size=4>邮箱：</font> <input
								type="text" value="${student.email}" id="email" name="email"
								class="inputTxt" disabled="true"/><br></li>
							<li>
							<li class="pb10"><span style="float:left;"><font color=#818181 size=4> 头像：</font></span><input
								type="file" class="inputTxt" name="img" id="img"
								style="height: 32px;" disabled="true"/></li>
							
						</ul>

					</div>
					<span style="margin-left: 10px;"><font color="red">${status}</font></span>
					<div>
						<input type="button" value="编辑" onclick="edit();"
							style="background: #F7B52C; width: 40; height: 30; margin-left: 15px; margin-top: 10px; font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 100; position: absolute; background: #0090DB; color: #FFEDF1;"
							onMouseOver="this.style.backgroundColor='#EF972B';"
							onMouseOut="this.style.backgroundColor ='#0090DB';" /> <input
							type="submit" value="保存" id="savebtn"
							style="background: #F7B52C; width: 40; height: 30; margin-left: 110px; margin-top: 10px; font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 100; position: absolute; background: #0090DB; color: #FFEDF1;"
							onMouseOver="this.style.backgroundColor='#EF972B';"
							onMouseOut="this.style.backgroundColor ='#0090DB';"
							disabled="true" />
					</div>
				</div>
				<div id="headImg" style="margin-top: 20px; margin-left: 420px;">
					<img src="${student.imgPath}" width="100px" height="120px"
						alt="userImg" />

				</div>
<input type="hidden" name="password"
								value="${student.password }" />
							<input
								type="hidden" name="imgPath"
								value="${student.imgPath}"/><br>
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
