<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String backurl=request.getParameter("backurl");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link rel="stylesheet" href="<%=path%>/css/loginUser/login.css"
	type="text/css" />
<script src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function checkUsername(id) {
		var result=false;
		$.ajax({
			   type:"get",
			   url:'<%=path%>/student/isStudentIdExisted.do',
			data : {
				studentId : id
			},
			dataType : "json",
			 async: false,
			success : function(data) {
				result=!data.equals("existed");
			}
		});
		return result;
	}
	function checkPwd(pwd) {
		var reg = /^[\w]{6,20}$/;
		if (pwd == null || pwd == "") {
			document.getElementById("passwordErrorTip").innerText = "用户的密码不能设置为空，请设置密码";
			document.getElementById("passwordErrorTip").style.color = "red";
			passwordflag = false;
			return false;
		} else if (pwd.length<6||pwd.length>20) {
			document.getElementById("passwordErrorTip").innerText = "密码长度不对，请输入6-20位长度的密码！";
			document.getElementById("passwordErrorTip").style.color = "red";
			passwordflag = false;
			return false;
		} else if (!pwd.match(reg)) {
			document.getElementById("passwordErrorTip").innerText = "密码只能是由字母、数字和下划线组成";
			document.getElementById("passwordErrorTip").style.color = "red";
			passwordflag = false;
			return false;
		} else {
			
		var result=false;
		$.ajax({
			   type:"get",
			   url:'<%=path%>/student/isStudentIdExisted.do',
			data : {
				studentId : id
			},
			dataType : "json",
			 async: false,
			success : function(data) {
				result=!data.equals("existed");
			}
		});
		document.getElementById("passwordErrorTip").innerText = "";
		return true;
	}
	}
</script>
</head>

<body id="login">
	<div class="content">
		<form action="<%=path%>/student/studentLogin.do" method="post"
			class="login-form">
			<div class="username">
				<input type="text" name="id" placeholder="请输入学生账号" autocomplete="on" onblur="checkUsername(this.value);" />
				<span class="user-icon icon">u</span> <span id="usrNameTip"
					style="margin-left: 5px; color: #929699;"></span>
			</div>
			<div class="password">
				<input type="password" name="password" placeholder="请输入密码"
					onblur="checkPwd(this.value);" /> <span class="password-icon icon">p</span>
				<span id="passwordErrorTip"
					style="margin-left: 5px; color: #929699;"></span>
			</div>
			
			<div class="account-control">
				<button type="reset">重置</button>
				<button type="submit">登陆</button>
			</div>
			<p class="not-registered">
				还没有虚拟宿舍账号?<a>现在注册!</a>
			</p>
			<div class="backurl">
			<input type="hidden" name="backurl" value="<%=backurl%>"/>
			</div>
		</form>
	</div>
</body>
</html>