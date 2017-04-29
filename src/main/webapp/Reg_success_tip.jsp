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
<base href="<%=basePath%>">
<title>My JSP 'Reg_success_tip.jsp' starting page</title>
<style type="text/css">
* {
			margin:0;
			padding:0;
		}
		html {
			width:100%;
			height:100%;
			overflow-x:hidden;
			list-style:none;
			border:none;
			font-size:12px;
		}
  #header{
           width:100%;
           margin-top:0;
           height:33px;
           background:#F5F5F5;
           border-bottom:1px solid #eee;
           clear:both;
           line-height:35px;
      }
      #header a{
       color:#6C6C6C;
      }
      a:link,a:visited,a:active{
      text-decoration:none;
      }
      #header a:hover{
      color:#f60;
      text-decoration:underline;
      }
      #leftDistance{
       margin-left:150px;    
      }  
      #loginRegister{
        color:#6C6C6C;
        float:left;
        height:33px;
        text-align:left;
        width:500px;
      }
      #loginRegister a{
      margin:0 5px;
      text-
      }
      #quick-menu{float:right;}
      #quick-menu li{
      float:left;
      display:block;
      padding:0 10px;
      text-align:left;
      font-size:12px;
     }
    #quick-menu li.end{
     padding-right:180px;
     }
     #top{
     width: 1000px;
     height: 92px;
     padding-top: 12px;
     margin: 0 auto;
     position:relative;}
     .top_left{width:593px;height:75px;float: left;}
     .top_left img,.top_left .top_h2{float:left;}
     .top_h2{
     margin-left:15px;
     font-size:28px;
     width: 438px; 
     padding-top: 12px;color:#006DB3;}
     #nav{
     height:25px;
     width:100%;
     background: #0090CE;
     clear:both;}  
  .register-tipMain{
  background: #F6F6F6;
  padding:24px 120px 0px 150px;
  }
   .register-tipForm{ 
   padding:24px 34px 50px 44px;
   border: 1px solid #D7D7D7;
   background:#fff;
   height:250px;
   }
    .loginBack{
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
    .loginBack:hover {
    text-shadow:0 0 2px rgb(255,255,255);
    box-shadow:inset 0 1px 0 rgb(86,174,251),0 0 10px 3px rgba(74,162,241,0.5);
}
#tip{
  text-align:center;
}
#tip ul li{
 list-style:none;display:block;margin-top:15px;font-size:14px;
 }
 #tip ul li a{
color:blue;
 }
  </style>
</head>
<body >
	 <div id="header">
     
      <div id="loginRegister">
               <div id="leftDistance"> 
                                您好，欢迎来到虚拟宿舍！
               <a href="<%=path%>/login.jsp">登录</a>
               <a href="#">注册</a>
               </div> 
               
      </div>
      <div id="quick-menu">
         <ul>
         <li><a href="javascript:AddFavorite('虚拟宿舍','http://localhost:8080/dormitory/homePage.jsp/')">收藏</a></li>
         <li class="end"><a href="#">帮助</a></li>
         </ul>
      </div>
   </div>
   <div id="top">
   <div class="top_left">
   <img src="images/scut_new_logo1.jpg" width="73px" height="75px">
   <div class="top_h2">
        华南理工大学虚拟宿舍
   </div>
	</div>
	</div>
		<div id="nav">
</div> 
	<div class="register-tipMain">
	<div class="register-tipForm">
	<div style="text-align:center;border-bottom: 1px solid #E3E3E3;padding-bottom:20px;">
		<img src="images/regSuccess.png" style="vertical-align:middle;"
			width=35px height=42px /><span style="margin-left:10px;font-size:15px;">恭喜你完成注册 ！</span> <br>
	</div>
	<div id="tip">
	<ul >
	<li >
	 尊敬的用户，你已成功注册华南理工大学虚拟宿舍，请<a href="<%=path%>/login.jsp">点击登录</a></li>
	<li>	
	<input type="button" class="loginBack"
			value="返回登录"  onclick="window.location.href='/dormitory/login.jsp'"/>
	</li>
	</ul>
	</div>
	</div>
	
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
