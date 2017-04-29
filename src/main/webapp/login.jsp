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
	<link rel="stylesheet" href="<%=path%>/css/loginUser/login.css" type="text/css" />  
	
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