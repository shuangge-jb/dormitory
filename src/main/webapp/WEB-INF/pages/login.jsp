<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	  
	<style type="text/css">
		* {
			margin:0;
			padding:0;
		}
		html {
			width:100%;
			height:100%;
			overflow-x:hidden;
		}
		body {
			height:100%;
			margin:0;
			padding:0;
			font-size:10pt;
			background:#F1F1F1;
			color:#333;
			overflow:auto;
			overflow-x:hidden;
		
		}
		body#login {
			background: url(/dormitory/images/dormitorybg.jpg) repeat-x scroll 0 0;
		}
	.content {
    width:600px;
    height:350px;
    margin:50px auto 10px auto;
}
.login-form {
    width:400px;
    height:149px;
    margin:70px auto 0;
    padding-top:73px;
    position:relative;
    background:#fff;
    background-image:-*-linear-gradient(top,rgb(255,255,255),rgb(242,242,242));
    box-shadow:0 3px 3px rgba(21,62,78,0.8);
}
.login-form:before {
    content:"";
    position:absolute;
    top:-50px;
    left:150px;
    width:102px;
    height:102px;
    padding:2px;
    border:1px solid rgb(216,216,219);
    background:#fff url("profilepicture.jpg") no-repeat 2px 2px;
}
.not-registered {
    position:absolute;
    color:rgb(153,153,153);
    font-weight:bold;
	font-size:13px;
    top:calc(100%);
    background-color:rgb(255,255,255);
    width:400px;
    height:40px;
    margin:0 auto;
    line-height:46px;
    text-align: center;
    box-shadow:0 3px 3px rgba(21,62,78,0.8);
}
.not-registered a {
    margin-left:5px;
    text-decoration: none;
    color:rgb(52,119,182);
    cursor: pointer;
}
.login-form div {
    width:216px;
    height:28px;
    margin:20px auto;
    position:relative;
    line-height:28px;
    border:none;
}
.login-form .user-icon, 
.login-form .password-icon {
    display:inline-block;
    font-family: 'loginform-icon';
    font-size:15px;
    text-align:center;
    line-height:28px;
    color:rgb(153,153,153);
    position:absolute;
    left:1px;
    top:1px;
    background-color:rgb(255,255,255);
    border:none;
    border-right:1px solid rgb(229,229,232);
    width:30px;
    height:28px;
    transition: all 300ms linear;
}
.login-form .username input, .login-form .password input {
    height:100%;
    width:calc(100% - 40px);
    padding-left:40px;
    border-radius:2px;
    border:1px solid;
    border-color:rgb(229,229,232) rgb(220,220,221) rgb(213,213,213) rgb(220,220,221);
    display:block;
    transition: all 300ms linear;
}
.login-form .icon:before, .login-form .icon:after {
    content:"";
    position:absolute;
    top:10px;
    left:30px;
    width:0;
    height:0;
    border:4px solid transparent;
    border-left-color:rgb(255,255,255);
}
.login-form .icon:before {
    top:9px;
    border:5px solid transparent;
    border-left-color:rgb(229,229,232);
}
.login-form .username input:focus, .login-form .password input:focus {
    border-color:rgb(69,153,228);
    box-shadow:0 0 2px 1px rgb(200,223,244);
}
.login-form .username input:focus + span, .login-form .password input:focus + span {
    background:-*-linear-gradient(top,rgb(255,255,255),rgb(245,245,245));
    color:rgb(51,51,51);
}
.login-form .username input:focus + span:after, .login-form .password input:focus + span:after {
    border-left-color:rgb(250,250,250);
}

.login-form .account-control label {
    margin-left:24px;
    font-size:12px;
    font-family: Arial, Helvetica, sans-serif;
    cursor:pointer;
}
.login-form button[type="reset"]{
    color:#fff;
    font-weight:bold;
    margin-left:15px;
     margin-right:22px;
    float:right;
    width:68px;
    height:30px;
    position:relative;
    background:-*-linear-gradient(top,rgb(74,162,241),rgb(52,119,182)) 1px 0 no-repeat,
               -*-linear-gradient(top,rgb(52,118,181),rgb(36,90,141)) left top no-repeat;
    background-size:66px 28px,68px 29px;
    border:none;
    border-top:1px solid rgb(52,118,181);
    border-radius:2px;
    box-shadow:inset 0 1px 0 rgb(86,174,251);
    text-shadow:0 1px 1px rgb(51,113,173);
    transition: all 200ms linear;
}
.login-form button[type="submit"] {
    color:#fff;
    font-weight:bold;
    margin-left:15px;
    float:right;
    width:68px;
    height:30px;
    position:relative;
    background:-*-linear-gradient(top,rgb(74,162,241),rgb(52,119,182)) 1px 0 no-repeat,
               -*-linear-gradient(top,rgb(52,118,181),rgb(36,90,141)) left top no-repeat;
    background-size:66px 28px,68px 29px;
    border:none;
    border-top:1px solid rgb(52,118,181);
    border-radius:2px;
    box-shadow:inset 0 1px 0 rgb(86,174,251);
    text-shadow:0 1px 1px rgb(51,113,173);
    transition: all 200ms linear;
}
.login-form button[type="submit"]:hover {
    text-shadow:0 0 2px rgb(255,255,255);
    box-shadow:inset 0 1px 0 rgb(86,174,251),0 0 10px 3px rgba(74,162,241,0.5);
}
.login-form button[type="reset"]:hover {
    text-shadow:0 0 2px rgb(255,255,255);
    box-shadow:inset 0 1px 0 rgb(86,174,251),0 0 10px 3px rgba(74,162,241,0.5);
}
.login-form button[type="reset"]:active {
    background:-*-linear-gradient(top,rgb(52,119,182),rgb(74,162,241)) 1px 0 no-repeat,
               -*-linear-gradient(top,rgb(52,118,181),rgb(36,90,141)) left top no-repeat;
}

.login-form button[type="submit"]:active {
    background:-*-linear-gradient(top,rgb(52,119,182),rgb(74,162,241)) 1px 0 no-repeat,
               -*-linear-gradient(top,rgb(52,118,181),rgb(36,90,141)) left top no-repeat;
}

.login-form .account-control input {
    width:0px;
    height:0px;
}
.login-form label.check {
    position:absolute;
    left:0;
    top:50%;
    margin:-8px 0;
    display:inline-block;
    width:16px;
    height:16px;
    line-height: 16px;
    text-align:center;
    border-radius:2px;
    background:-*-linear-gradient(top,rgb(255,255,255),rgb(246,246,246)) 1px 1px no-repeat,
               -*-linear-gradient(top,rgb(227,227,230),rgb(165,165,165)) left top no-repeat;
    background-size:14px 14px,16px 16px;
}
.login-form .account-control input:checked + label.check:before {
    content:attr(data-on);
    font-family:loginform-icon;
}
@font-face {
  font-family: 'loginform-icon';
  src: url("font/loginform-icon.eot");
  src: url("font/loginform-icon.eot?#iefix") format('embedded-opentype'),
       url("font/loginform-icon.woff") format('woff'),
       url("font/loginform-icon.ttf") format('truetype'),
       url("font/loginform-icon.svg#loginform-icon") format('svg');
  font-weight: normal;
  font-style: normal;
}
	</style>
	
  </head>
  
  <body id="login">
	 <div class="content">
           <form action="<%=path%>/student/loginController" method="post" class="login-form">
               <div class="username">
                   <input type="text" name="id" placeholder="请输入学生账号" autocomplete="on" />
                   <span class="user-icon icon">u</span>
               </div>
               <div class="password">
                   <input type="password" name="password" placeholder="请输入密码" />
                   <span class="password-icon icon">p</span>
               </div>
               <div class="account-control">
               <button type="reset">重置</button>
                   <button type="submit">登陆</button>
                   
                   
               </div>
               <p class="not-registered">还没有虚拟宿舍账号?<a>现在注册!</a></p>
           </form>
	   </div>
  </body>
</html>