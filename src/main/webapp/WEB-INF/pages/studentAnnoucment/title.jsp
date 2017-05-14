<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
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
   >我的设备</a>
  
<a href="<%=path%>/listLostFound.do?pageIndex=1&pageSize=2" id="lostFond">失物招领</a><em></em>
<a href="<%=path%>/student/listRepairRecordByDormitoryId.do?dormitoryId=${dormitoryId}&pageIndex=1&pageSize=2" id="myRepair">我的报修</a><em></em>
<a href="<%=path%>/student/listPostcardByStudentId.do?studentId=${studentId }&pageIndex=1&pageSize=6" id="postCard">宿舍明信片</a><em></em>
<a href="#">虚拟宿舍</a><em></em>
<a href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=1&pageSize=10">最新公告</a><em></em>
<a href="<%=path%>/student/getStudentInfo.do?studentId=${studentId }" id="userInfo">个人中心</a>
<a href="#">使用指南</a>
</div>
</div>
  </body>
</html>