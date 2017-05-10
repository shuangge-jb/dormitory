<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#backIt").click(function(){
		window.location.href="<%=path%>/student/listUserDevice.do?pageIndex=1&pageSize=6";
										})
					})
	function AddFavorite(title, url) {
		try {
			window.external.addFavorite(url, title);
		} catch (e) {
			try {
				window.sidebar.addPanel(title, url, "");
			} catch (e) {
				alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
			}
		}
	}
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html {
	width: 100%;
	height: 100%;
	overflow-x: hidden;
	list-style: none;
	border: none;
	font-size: 12px;
}

#header {
	width: 100%;
	margin-top: 0;
	height: 33px;
	background: #F5F5F5;
	border-bottom: 1px solid #eee;
	clear: both;
	line-height: 35px;
}

#header a {
	color: #6C6C6C;
}

a:link, a:visited, a:active {
	text-decoration: none;
}

#header a:hover {
	color: #f60;
	text-decoration: underline;
}

#leftDistance {
	margin-left: 150px;
}

#loginRegister {
	color: #6C6C6C;
	float: left;
	height: 33px;
	text-align: left;
	width: 500px;
}

#loginRegister a {
	margin: 0 5px;
	text-
}

#quick-menu {
	float: right;
}

#quick-menu li {
	float: left;
	display: block;
	padding: 0 10px;
	text-align: left;
	font-size: 12px;
}

#quick-menu li.end {
	padding-right: 180px;
}

#top {
	width: 1000px;
	height: 92px;
	padding-top: 12px;
	margin: 0 auto;
	position: relative;
}

.top_left {
	width: 593px;
	height: 75px;
	float: left;
}

.top_left img, .top_left .top_h2 {
	float: left;
}

.top_h2 {
	margin-left: 15px;
	font-size: 28px;
	width: 438px;
	padding-top: 12px;
	color: #006DB3;
}

#nav {
	height: 50px;
	width: 100%;
	background: #0090CE;
	clear: both;
}

.navc {
	width: 960px;
	height: 50px;
	margin: 0 auto;
	display: block;
}

#nav a {
	display: block;
	text-align: center;
	padding: 0 11px 0 12px;
	_padding: 0 11px 0 11px;
	width: 90px;
	height: 50px;
	line-height: 51px;
	line-height: 54px\9;
	line-height: 52px\0;
	overflow: hidden;
	float: left;
	color: #fff;
	font-size: 14px;
	font-family: "Microsoft Yahei";
	transition: all 0.1s ease-in;
	text-shadow: 0 1px 0 rgba(0, 0, 0, 0.3);
}

#nav a.on, #nav a.on:hover {
	color: #fff;
	text-decoration: none;
	background-color: #0074A6;
	height: 50px;
	line-height: 51px;
	line-height: 54px\9;
	line-height: 52px\0;
	border-bottom: 0;
}

#nav a:hover {
	text-decoration: none;
	background: #0074A6;
}

#nav em {
	width: 1px;
	display: block;
	height: 25px;
	float: left;
	overflow: hidden;
	margin: 13px 6px 0 6px;
}

#nav em {
	border-right: 1px solid #009EE2;
	background: #0074A6;
}

#myDormitoryDevice {
	color: #fff;
	text-decoration: none;
	background-color: #0074A6;
	height: 50px;
	line-height: 51px;
	line-height: 54px\9;
	line-height: 52px\0;
	border-bottom: 0;
}

#backIt {
	width: 40;
	height: 128px;
	position: absolute;
	top: 230.2px;
	margin-left: 148px;;
	position: fixed;
	background-color: #A6BDC5;
	text-align: center;
}

#backIt img {
	padding-left: 3px;
	width: 25px;
	height: 25;
	text-align: center;
}

.deviceName {
	font-size: 16px;
	color: #FF8D75;
}

#brief {
	margin-top: 20px;
	margin-left: 40px;
	width: 200;
	color
	=#333333;
}

#page {
	padding-top: 10px;
}

#page a {
	color: blue
}

#page a:hover {
	color: #0090CE;
}
</style>
</head>
<body bgcolor="#FFFFFF">
<jsp:include page="head.jsp"></jsp:include>
	<!-- <div id="header">
		<div id="loginRegister">
			<div id="leftDistance">
				您好，欢迎来到虚拟宿舍！ <a href="#">登录</a> <a href="#">注册</a>
			</div>

		</div>
		<div id="quick-menu">
			<ul>
				<li><a
					href="javascript:AddFavorite('虚拟宿舍','http://localhost:8080/dormitory/homePage.jsp/')">收藏</a></li>
				<li class="end"><a href="#">帮助</a></li>
			</ul>
		</div>
	</div> -->
	<div id="top">
		<div class="top_left">
			<img src="<%=path%>/images/scut_new_logo1.jpg" width="73px"
				height="75px">
			<div class="top_h2">华南理工大学虚拟宿舍</div>
		</div>
	</div>
	<div id="nav">
		<div class="navc">
			<a href="<%=path%>/homePage.jsp">首页</a><em></em> <a
				href="<%=path%>/student/listUserDevice.do?pageIndex=1&pageSize=8"
				id="myDormitoryDevice">我的设备</a> <a
				href="http://www.mb5u.com/cmsmoban/">程序模板</a><em></em> <a
				href="http://www.mb5u.com/edu/">建站教程</a> <a
				href="http://www.mb5u.com/shipinjiaocheng/">视频教程</a><em></em> <a
				href="http://www.mb5u.com/jscode/">网页特效</a> <a
				href="http://www.mb5u.com/sucai/">图标素材</a> <a
				href="http://www.mb5u.com/ask/" target="_blank">站长问答</a>
		</div>
	</div>
	<div id="backIt">
		<img src="<%=path%>/images/back.PNG;" /> <font size=2 color=#DEEBF3>
			选<br> 其<br> 他<br> 设<br> 备
		</font>
	</div>
	<div
		style="width: 1000px; height: 600px; margin-left: 160px; border: 0.1px solid #CBCBCB; margin-top: 20;">
		<div
			style="height: 100%; width: 32%; float: left; border-right: 0.1px solid #DADADA; float: left;">
			<div style="margin-left: 40px; margin-top: 25px;">
				<span class="deviceName">${device.name}</span><br> <img
					src="${device.imgPath }"
					style="width: 168px; height: 200px; border: 1px #D7D7D7 solid; margin-top: 10px;" />
				<div style="padding-top: 8px">
					<font size=2 color=#333333 mrgin-top=10px>类型:${device.type}</font>
				</div>
			</div>
			<div id="brief">
				<font size=2>简介:</font> <br> ${device.description}
			</div>
		</div>
		<div
			style="height: 100%; width: 1.5%; background: -webkit-gradient(linear, 100% 0%, 0% 0%, from(#FFFFFF), to(#EDEDED)); border: 0px; float: left;"></div>
		<div style="float: left;">
			<div style="height: 120px; padding-top: 20px; padding-left: 20px;">
				<font color=#FF8D3F size=2> *温馨提示：<br /> 1.标灰的功能暂不可用。<br>
					2.点击功能可以进入输入参数页面，输入对应参数即可实现用户需求<br>
				</font>
				<div style="margin-top: 15;">
					<form
						action="<%=path%>/student/listFunctionByDeviceIdLike.do?&deviceId=${device.deviceId }&pageIndex=${pageIndex}&pageSize=10"
						method="post">
						<input type="text" id="keyword" name="keyword" value="${keyword}"
							placeholder="请输入功能名称"
							style="width: 300px; height: 30px; border: 2px solid #0090DB" />
						<input type="submit" value="搜索"
							style="font-weight: bolder; font-size: 15px; border: 3px solid #0090DB; height: 30px; width: 50; position: absolute; background: #0090DB; color: #FFEDF1;">
					</form>
				</div>
			</div>
			<div style="width: 650px; border: 0.1px solid #D7D7D7;"></div>
			<c:forEach items="${data}" var="functionOfDevice" varStatus="b">
				<c:if test="${functionOfDevice.state==1}">
					<div
						style="height: 40px; line-height: 40px; border-bottom: #D7D7D7 1px dashed;">
						<a
							href="<%=path%>/student/forwardParam.do?interfaceId=${functionOfDevice.interfaceId}"
							style="text-decoration: none; color: #0093D0;"> <font size=2>${functionOfDevice.interfaceName}</font>
						</a>
					</div>
				</c:if>
				<c:if test="${functionOfDevice.state==0}">
					<div
						style="height: 40px; line-height: 40px; border-bottom: #D7D7D7 1px dashed;">
						<font size=2 color=#9F9FB2>
							${functionOfDevice.interfaceName} </font>
					</div>
				</c:if>
			</c:forEach>

			<div id="page" style="text-align: center; margin-top: 5px;">
				当前第${pageIndex}页&nbsp;&nbsp;
				<c:if test="${pageIndex==1}">
					<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
				</c:if>
				<c:if test="${pageIndex>1}">
					<td><a
						href="<%=path%>/student/listUserInterfaceByDeviceId.do?pageIndex=1&pageSize=2&deviceId=${device.deviceId}">首页</a></td>
					<td><a
						href="<%=path%>/student/listUserInterfaceByDeviceId.do?pageIndex=${pageIndex-1}&pageSize=2&deviceId=${device.deviceId}">上一页</a></td>
				</c:if>
				<c:if test="${pageIndex != totalPages}">
					<td><a
						href="<%=path%>/student/listUserInterfaceByDeviceId.do?pageIndex=${pageIndex+1}&pageSize=2&deviceId=${device.deviceId}">下一页</a></td>
					<td><a
						href="<%=path%>/student/listUserInterfaceByDeviceId.do?pageIndex=${totalPages}&pageSize=2&deviceId=${device.deviceId}">最后一页</a></td>
				</c:if>
				<c:if test="${pageIndex == totalPages}">
					<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
				</c:if>
				共${totalPages}页&nbsp;&nbsp; 共${total}条记录&nbsp;&nbsp;
			</div>

		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>

</html>
