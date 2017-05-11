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
	<link rel="stylesheet" href="<%=path%>/css/mydevice/mydevicehead.css" media="all"/>
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

  
	
  </head>
  
  <body >
    <div id="header"> 
      <div id="quick-menu">
         <ul>
         <li><a href="javascript:AddFavorite('虚拟宿舍','http://localhost:8080/dormitory/homePage.jsp/')">收藏</a></li>
         <li class="end"><a href="#">帮助</a></li>
         </ul>
      </div>
      <c:choose>
			<c:when test="${empty studentId }">
				<div id="loginRegister">
					<div class="leftDistance">
						您好，欢迎来到虚拟宿舍！ <a href="<%=path %>/login.jsp">登录</a> <a href="<%=path %>/reg.jsp">注册</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
			<div id="userNameTip">
			    <div class="leftDistance">
				欢迎你！<c:out value="${studentName}" />
				<a href="/dormitory/student/logout.do" >安全退出</a>
				</div>
				</div>
			</c:otherwise>
		</c:choose>
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
<a href="http://t.mb5u.com/">站长工具</a><a href="http://www.mb5u.com/ask/" target="_blank">最新公告</a>
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