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
<link rel="stylesheet" type="text/css" href="css/register.css" />
<script type="text/javascript">	
	//判断输入密码的类型    
		function CharMode(iN) {
			if (iN >= 48 && iN <= 57) //数字    
				return 1;
			if (iN >= 65 && iN <= 90) //大写    
				return 2;
			if (iN >= 97 && iN <= 122) //小写    
				return 4;
			else
				return 8;
		}
		
	//bitTotal函数    
		//计算密码模式    
		function bitTotal(num) {
			modes = 0;
			for (i = 0; i < 4; i++) {
				if (num & 1)
					modes++;
				num >>>= 1;
			}
			return modes;
		}
		//返回强度级别    
	    function checkStrong(sPW){    
	        if (sPW.length<6)    
	            return 0; //密码太短，不检测级别  
	        Modes=0;    
	        for (i=0;i<sPW.length;i++){    
	            //密码模式    
	            Modes|=CharMode(sPW.charCodeAt(i));    
	        }  
	        return bitTotal(Modes);    
	    }  
	    //显示颜色    
	    function checkPwd(pwd){  
	    	Dfault_color = "#F6F6F6";
	   	    L_color = "#FF6700";
	   	    M_color = "#FF9900";
	   	    H_color = "#339900";
	        if (pwd==null||pwd==''){    
	            Lcolor=Mcolor=Hcolor=Dfault_color;  
	        }    
	        else{    
	            S_level=checkStrong(pwd);    
	            switch(S_level) {    
	            case 0:    
	                Lcolor=Mcolor=Hcolor=Dfault_color;  
	                break;  
	            case 1:    
	                Lcolor=L_color;  
	                Mcolor=Hcolor=Dfault_color;  
	                break;    
	            case 2:    
	                Lcolor=Mcolor=M_color;    
	                Hcolor=Dfault_color;    
	                break;    
	            default:    
	                Lcolor=Mcolor=Hcolor=H_color;    
	        }    
	    }    
		document.getElementById("strength_L").style.background = Lcolor;
		document.getElementById("strength_M").style.background = Mcolor;
		document.getElementById("strength_H").style.background = Hcolor;
		var reg = /^[\w]{6,20}$/;
		if(pwd==null|| pwd==""){
			document.getElementById("passwordErrorTip").innerText="用户的密码不能设置为空，请设置密码";
			document.getElementById("passwordErrorTip").style.color="red";	
			passwordflag = false;
			return false;
		}
		else if(pwd.length<6||pwd.length>20){
		document.getElementById("passwordErrorTip").innerText="密码长度不对，请输入6-20位长度的密码！";
		document.getElementById("passwordErrorTip").style.color="red";
		    passwordflag = false;
		    return false;
		}
		else if(!pwd.match(reg)){
			document.getElementById("passwordErrorTip").innerText="密码只能是由字母、数字和下划线组成";
			document.getElementById("passwordErrorTip").style.color="red";	
			passwordflag = false;
			return false;
		}
		else{
			document.getElementById("passwordErrorTip").innerText="";
			return true;
		}
	}
	    function showUserNameTip(){
	    	document.getElementById("usrNameTip").innerText="注册帐号为学号";
	    	document.getElementById("usrNameTip").style.color="#929699";
	    }
	   function showUserNameErrorTip(userName){
	    	 var reg = new RegExp("^[0-9]*$");
	    	 if(userName==""||userName==null){
	    		 document.getElementById("usrNameTip").innerText="注册帐号不能为空";
				 document.getElementById("usrNameTip").style.color="red";
				 return false;
	    	 }	 
	    	 else if(!reg.test(userName)||userName.length>12){
				 document.getElementById("usrNameTip").innerText="注册帐号必须为数字,长度不能超过12位";
				 document.getElementById("usrNameTip").style.color="red";
				 return false;
			 }
			 else{
				 document.getElementById("usrNameTip").innerText="";
				 return true;
			 }
	    }
	   function bedIdTip(bedId){
		   if(bedId==null||bedId==""){
			   document.getElementById("bedIdTip").innerText="请选择所在的床位";
			   document.getElementById("bedIdTip").style.color="red";
			   return false;
		   }
		   else{
			   document.getElementById("bedIdTip").innerText=""; 
			   return true;
		   }
	   }
	   function roomTip(room){
	    	 var reg = new RegExp("^[0-9]*$");
	    	 if(room==""||room==null){
	    		 document.getElementById("roomTip").innerText="宿舍房号不能为空";
				 document.getElementById("roomTip").style.color="red";
				 return false;
	    	 }	 
	    	 else if(!reg.test(room)||room.length>6){
				 document.getElementById("roomTip").innerText="宿舍房号必须为数字,长度不能超过6位";
				 document.getElementById("roomTip").style.color="red";
				 return false;
			 }
			 else{
				 document.getElementById("roomTip").innerText="";
				 return true;
			 }
	    }
	   function realNameTip(name){
		   if(name==null || name==""){
			   document.getElementById("realNameTip").innerText="学生姓名不能为空"; 
			   document.getElementById("realNameTip").style.color="red";
			   return false;
		   } 
		   else {
			   document.getElementById("realNameTip").innerText=""; 
			   return true;
		   }
	   }
	   function imgTip(img){
		   if(img==null || img==""){
			   document.getElementById("imgTip").innerText="请上传头像"; 
			   document.getElementById("imgTip").style.color="red";
			   return false;
		   } 
		   else {
			   document.getElementById("imgTip").innerText=""; 
			   return true;
		   }
	   }
	  
	function phoneNumberTip(phoneNumber) {
		if (phoneNumber == null || phoneNumber == "") {
			document.getElementById("phoneNumberTip").innerText = "手机号码不能为空";
			document.getElementById("phoneNumberTip").style.color = "red";
			return false;
		} else if (!(/^1(3|4|5|7|8)\d{9}$/.test(phoneNumber))) {
			document.getElementById("phoneNumberTip").innerText = "手机号码有误，请重填";
			document.getElementById("phoneNumberTip").style.color = "red";
			return false;
		} else {
			document.getElementById("phoneNumberTip").innerText = "";
			return true;
		}

	}

	function emailTip(email) {
		if (email == null || email == "") {
			document.getElementById("emailTip").innerText = "邮箱不能为空";
			document.getElementById("emailTip").style.color = "red";
			return false;
		} else if (!(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/
				.test(email))) {
			document.getElementById("emailTip").innerText = "邮箱格式有误，请重填";
			document.getElementById("emailTip").style.color = "red";
			return false;
		} else {
			document.getElementById("emailTip").innerText = "";
			return true;
		}

	}

	function buildingNameTip(buildingName) {
		if (buildingName == null || buildingName == "") {
			document.getElementById("buildingNameTip").innerText = "宿舍楼不能为空";
			document.getElementById("buildingNameTip").style.color = "red";
			return false;
		} else {
			document.getElementById("buildingNameTip").innerText = "";
			return true;
		}
	}

	function showConfirmPasswordTip(pwd) {
		if (pwd == null || pwd == "") {
			document.getElementById("confirmPasswordTip").innerText = "确认密码不能为空";
			document.getElementById("confirmPasswordTip").style.color = "red";
			return false;
		} else if (pwd != document.getElementById("password").value) {
			document.getElementById("confirmPasswordTip").innerText = "两次密码输入不一致";
			document.getElementById("confirmPasswordTip").style.color = "red";
			return false;
		} else {
			document.getElementById("confirmPasswordTip").innerText = "";
			return true;
		}

	}
	function validate() {
		var userName = document.getElementById("studentId").value;
		var password = document.getElementById("password").value;
		var password2 = document.getElementById("password2").value;
		var realName = document.getElementById("realName").value;
		var phoneNumber = document.getElementById("phoneNumber").value;
		var email = document.getElementById("email").value;
		var buildingName = document.getElementById("buildingName").value;
		var room = document.getElementById("room").value;
		var bedId = document.getElementById("bedId").value;
		var img = document.getElementById("img").value;
		if (!showUserNameErrorTip(userName)) {
			return false;
		} else if (!checkPwd(password)) {
			return false;
		} else if (!showConfirmPasswordTip(password2)) {
			return false;
		} else if (!realNameTip(realName)) {
			return false;
		} else if (!phoneNumberTip(phoneNumber)) {
			return false;
		} else if(!emailTip(email)){
			return false
		} else if(!buildingNameTip(buildingName)){
			return false;
		} else if(!roomTip(room)){
			return false;
		}else if(!bedIdTip(bedId)){
			return false;
		}else if(!imgTip(img)){
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
  .register-main{
  background: #F6F6F6;
  padding:24px 120px 40px 150px;
  }
  .register-form{ 
   padding:24px 34px 40px 44px;
   border: 1px solid #D7D7D7;
   background:#fff;
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
	<div id="top">
		<div class="top_left">
			<img src="/dormitory/images/scut_new_logo1.jpg" width="73px" height="75px">
			<div class="top_h2">华南理工大学虚拟宿舍</div>
		</div>
	</div>
	<div id="nav">
			<div class="navc">
<a href="<%=path%>/homePage.jsp" id="homePage">首页</a><em></em>
<a href="<%=path%>/student/listUserDevice.do?pageIndex=1&pageSize=8"
   id="myDormitoryDevice">我的设备</a><em></em>
<a href="#">失物招领</a><em></em>
<a href="#">我的报修</a><em></em>
<a href="#">宿舍明信片</a><em></em>
<a href="#">虚拟宿舍</a><em></em>
<a href="<%=path%>/listMyDormitoryAnnouncement.do?pageIndex=1&pageSize=10">最新公告</a><em></em>
<a href="#">使用指南</a>
</div>
</div>
		<div class="register-main">
		<form action="<%=path %>/student/register.do" method="post" 
		enctype="multipart/form-data" onsubmit="return validate();">
		<div class="register-form">
			<h3 class="content-hd"><b>注册信息</b><label class="c_orange">(*为必填项)</label></h3>
			<li >
			 <font  style="margin-left:80px;color:#FF0000;" size=4>
			   ${status}</font>
			 </li>
			 <ul class="form-content">
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   用户名：</label><input type="text" class="inputTxt" name="studentId"  id="studentId"
			   onblur="showUserNameErrorTip(this.value);"
			   onfocus="showUserNameTip();" />
			   <span id="usrNameTip" style="margin-left:5px;color:#929699;"></span>
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   登录密码：</label>
			  <input type="password" class="inputTxt" name="password" id="password" style="float:left;"
			  maxlength="20" onkeyup="checkPwd(this.value);" onblur ="checkPwd(this.value);" />	  	
              <table class="passwordStrength">
              <tr align="center" bgcolor="#F6F6F6" >
              <td width="5%" bgcolor="#fff" >弱</td>
              <td width="6%" id="strength_L" ></td>
             <td width="6%" id="strength_M" ></td>
             <td width="6%" id="strength_H" ></td>
             <td width="3%" bgcolor="#fff">强</td>
             <td id="passwordErrorTip" bgcolor="#fff"></td>
              </tr>
              </table>
			 </li>
			  <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			     确认密码：</label>
			   <input type="password" class="inputTxt" name="password2" id="password2"
			   onblur="showConfirmPasswordTip(this.value);">
			   <span id="confirmPasswordTip"></span>
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   学生姓名：</label><input type="text" class="inputTxt" name="name" id="realName"
			   onblur="realNameTip(this.value);">
			   <span id="realNameTip"></span>
			 </li>
			  <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   手机号：</label><input type="text" class="inputTxt" name="phoneNumber" id="phoneNumber"
			    onblur="phoneNumberTip(this.value)">
			   <span id="phoneNumberTip"></span>
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   邮箱：</label><input type="text" class="inputTxt" name="email" id="email"
			   onblur="emailTip(this.value)">
			   <span id="emailTip"></span>
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   宿舍楼：</label><input type="text" class="inputTxt" name="buildingName" id="buildingName"
			   onblur="buildingNameTip(this.value)">
			   <span id="buildingNameTip"></span>
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   所在宿舍：</label><input type="text" class="inputTxt" name="room" id="room"
			   onblur="roomTip(this.value)">
			   <span id="roomTip"></span>
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   所在床位：</label>
			   <select name="bedId" id="bedId" class="inputTxt" onblur="bedIdTip(this.value)">
			   <option value="" style="color: #b6b6b6" disabled selected>请选择床号</option>
			   <option value="1">1号</option>
			   <option value="2">2号</option>
			   <option value="3">3号</option>
			   <option value="4">4号</option>
			   </select>
			   <span id="bedIdTip"></span>
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   <b class="c_orange">*</b>
			   头像：</label><input type="file" class="inputTxt" name="img" id="img" style="height:34px;"
			   onblur="imgTip(this.value)">
			   <span id="imgTip"></span>
			 </li>
			 <li class="pb10">
			  <label class="form-label">
			   &nbsp;</label>
			   <input type="submit"  class="registerSubmit" value="注册">
			 </li>
			 </ul>
		</div>
		</form>
		<jsp:include page="foot.jsp"></jsp:include>
		</div>
	
</body>
</html>
