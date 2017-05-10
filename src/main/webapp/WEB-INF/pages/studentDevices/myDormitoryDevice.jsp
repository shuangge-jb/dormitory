<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
	<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" media="all"/>
	<script type="text/javascript">
	function AddFavorite(title, url) {
	    try {
	        window.external.addFavorite(url, title);
	    }
	    catch (e) {
	        try {
	            window.sidebar.addPanel(title, url, "");
	        }
	        catch (e) {
	            alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
	        }
	    }
	}
	</script>

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
     height:50px;
     width:100%;
     background: #0090CE;
     clear:both;}
     .navc{width:960px;height:50px;margin:0 auto;display:block;}
      #nav a{
      display:block;
      text-align:center;
      padding:0 11px 0 12px;
      _padding:0 11px 0 11px;
      width:90px;
      height:50px;
      line-height:51px;
      line-height:54px\9;
      line-height:52px\0;
      overflow:hidden;
      float:left;
      color:#fff;
      font-size:14px;
      font-family:"Microsoft Yahei";
      transition: all 0.1s ease-in;
    text-shadow:0 1px 0 rgba(0,0,0,0.3);}
#nav a.on,#nav a.on:hover{color:#fff;text-decoration:none;background-color:#0074A6;height:50px;line-height:51px;line-height:54px\9;line-height:52px\0;border-bottom:0;}
#nav a:hover{text-decoration:none;background:#0074A6;}
#nav em{width:1px;display:block;height:25px;float:left;overflow:hidden;margin:13px 6px 0 6px;}
#nav em{border-right:1px solid #009EE2;background:#0074A6;}
#myDormitoryDevice{
 color:#fff;text-decoration:none;background-color:#0074A6;height:50px;line-height:51px;line-height:54px\9;line-height:52px\0;border-bottom:0;
 } 
  .brand a{
	display: block;
	float: left;
	margin: 20px;
	width: 180px;
	height: 240px;
	text-align: center;
	position: relative;
}
.brand img{
	width: 180px;
	height: 240px;
}
.brand .info{
	display: none;
	background-color: #f0f0f0;
	color: #369242;
}
.vertical .info{
	width: 0;
	height: 240px;
	margin: 0 auto;
}
  .register-main{
  background: #F6F6F6;
  padding:24px 120px 40px 150px;
  }
  .register-form{ 
   padding:10px 34px 40px 44px;
   border: 1px solid #D7D7D7;
   background:#fff;
   }
   .content-hd{
     color: #0099FE;
     font-size: 15px;
     border-bottom: 1px solid #E3E3E3;
     height:30px;
     line-height:30px;
     padding-right: 10px;}
   .c_orange{color:#FF6700; font-size: 13px;}
   .checkDeviceDetail:hover{
    color: #0099FE;
   }
   .checkDeviceDetail
   {text-align:center;color:#0090CE;}
   #page{
   padding-top:10px;
   }
   
	</style>
	
  </head>
  
  <body >
   <div id="header">
      <div id="loginRegister">
               <div id="leftDistance"> 
                                您好，欢迎来到虚拟宿舍！
               <a href="#">登录</a>
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
   <img src="<%=path%>/images/scut_new_logo1.jpg" width="73px" height="75px">
   <div class="top_h2">
        华南理工大学虚拟宿舍
   </div>
	</div>
	</div>
	<div id="nav">
	<div class="navc">
<a href="<%=path%>/homePage.jsp">首页</a><em></em>
<a href="<%=path%>/student/listUserDevice.do?pageIndex=1&pageSize=8"
   id="myDormitoryDevice">我的设备</a>
<a href="http://www.mb5u.com/cmsmoban/">程序模板</a><em></em>
<a href="http://www.mb5u.com/edu/">建站教程</a>
<a href="http://www.mb5u.com/shipinjiaocheng/">视频教程</a><em></em>
<a href="http://www.mb5u.com/jscode/">网页特效</a>
<a href="http://www.mb5u.com/sucai/">图标素材</a>
<a href="http://www.mb5u.com/zitixiazai/">字体下载</a><em></em>
<a href="http://t.mb5u.com/">站长工具</a>
<a href="http://www.mb5u.com/ask/" target="_blank">站长问答</a>
</div>
</div>
    <div class="register-main">
    <div class="register-form">
    <h3 class="content-hd"><b>我的宿舍设备</b><label class="c_orange">(*每个设备有多个功能)</label></h3>
    <div style="width:720px;margin:0 auto;">
	<div id="vertical" class="brand vertical">
	<c:forEach items="${data}" var="device" varStatus="b">
	   <div style="width:220px;margin-left:10px;margin-top:10px;float:left;box-shadow: rgb(214, 214, 214) 0px 0px 15px 0px;">
		<a target="_blank" href="#">
		<img alt="" src="${device.imgPath }" />
		<span class="info">
		<h4>${device.name}</h4><br>
		${device.description}
		</span></a>
		<span style="text-align:center;color:#0090CE;">
		<h4>${device.name}</h4>
		</span>
		<span class="checkDeviceDetail" onclick="forwardFunction(${device.deviceId})">
		<h5>查看该设备的功能</h5>
		</span>
		</div>
		</c:forEach>
	</div>
	<div style="clear:both;"></div>
	</div>
	 <div id="page" style="text-align:center;margin-top:5px;">
           当前第${pageIndex}页&nbsp;&nbsp;
     <c:if test="${pageIndex==1}">
				<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
	 </c:if>
	 <c:if test="${pageIndex>1}">
			<td><a
				href="<%=path%>/student/listUserDevice.do?pageIndex=1&pageSize=6">首页</a></td>
			<td><a
               href="<%=path%>/student/listUserDevice.do?pageIndex=${pageIndex-1}&pageSize=6">上一页</a></td>
	</c:if>
	 <c:if test="${pageIndex != totalPages}">
				<td><a
					href="<%=path%>/student/listUserDevice.do?pageIndex=${pageIndex+1}&pageSize=6">下一页</a></td>
				<td><a
					href="<%=path%>/student/listUserDevice.do?pageIndex=${totalPages}&pageSize=10">最后一页</a></td>
		</c:if>
	  <c:if test="${pageIndex == totalPages}">
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
	  </c:if>
           共${totalPages}页&nbsp;&nbsp;
           共${totalCount}条记录&nbsp;&nbsp;
      </div>
    
</div>
  <jsp:include page="foot.jsp"></jsp:include> 
</div>
</body>
<script type="text/javascript">
function forwardFunction(deviceId){
    var pageIndex =1;
    var pageSize = 2;
    window.location.href ="<%=path%>/student/listUserInterfaceByDeviceId.do?deviceId="+deviceId+"&pageIndex="+pageIndex+"&pageSize="+pageSize;
}
//品牌翻转
var turn = function(target,time,opts){
	target.find('a').hover(function(){
		$(this).find('img').stop().animate(opts[0],time,function(){
			$(this).hide().next().show();
			$(this).next().animate(opts[1],time);
		});
	},function(){
		$(this).find('.info').animate(opts[0],time,function(){
			$(this).hide().prev().show();
			$(this).prev().animate(opts[1],time);
		});
	});
}
var verticalOpts = [{'width':0},{'width':'180px'}];
turn($('#vertical'),300,verticalOpts);

</script>
</html>