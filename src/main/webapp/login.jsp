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
 var userNameFlag=false;
 var passwordFlag=false;
	function checkUsername(id) {
		var result=false;
		$.ajax({
			type:"post",
			url:'<%=path%>/student/isStudentIdExisted.do',
			data : {studentId:id},
			dataType : "json",
			success : function(data) {
				if(data=="unexisted"){
				document.getElementById("usrNameTip").innerText="";	
				document.getElementById("usrNameTip").innerText="该用户名不存在";
				}
				else if(data=="studentIdNull"){
				document.getElementById("usrNameTip").innerText="";
				document.getElementById("usrNameTip").innerText="用户名不能为空";	
				}
				else{
				document.getElementById("usrNameTip").innerText="";
				userNameFlag=true;
				}
			},
			error:function (data){
				alert("请求异常");
			}
		});
	
	}
	function checkPassword(password){
		var id=document.getElementById("studentId").value;
		$.ajax({
			type:"get",
			url:'<%=path%>/student/isPasswordCorrect.do',
			data : {studentId:id,password:password},
			dataType : "json",
			success : function(data) {
				if(data=="incorrect"){
					document.getElementById("passwordErrorTip").innerText="";
				document.getElementById("passwordErrorTip").innerText="密码不正确";
				}
				else{
					document.getElementById("passwordErrorTip").innerText="";
					passwordFlag=true;
				}
			},
			error:function (data){
				alert("请求异常");
			}
		});
	}
	function vrifyLogin(){		
	 return passwordFlag&&passwordFlag;
	}
	
</script>
</head>

<body id="login">
	<div class="content">
	<form action="<%=path%>/student/studentLogin.do" method="post" onsubmit="return vrifyLogin();"
			class="login-form">
			<div class="username" >
				<input type="text" name="id" id="studentId" placeholder="请输入学生账号"  onblur="checkUsername(this.value);" />
				<span id="usrNameTip" style="margin-left: 5px;color: red;"></span>
				<span class="user-icon icon">u</span> 
			</div>
			<div class="password" style="margin-top:25px;">
				<input type="password" name="password" placeholder="请输入密码"
					onblur="checkPassword(this.value);"  /> <span class="password-icon icon">p</span>
				<span id="passwordErrorTip"
					style="margin-left: 5px; color: red;"></span>
			</div>
			
			<div class="account-control" style="margin-top:25px;">
				<button type="reset">重置</button>
				<button type="submit">登陆</button>
			</div>
			<p class="not-registered">
				还没有虚拟宿舍账号?<a href="<%=path%>/reg.jsp">现在注册!</a>
			</p>
			
		</form>
	</div>
</body>
</html>