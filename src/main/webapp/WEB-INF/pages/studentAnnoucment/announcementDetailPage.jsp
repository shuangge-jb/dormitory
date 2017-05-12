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
<script src="js/jquery-1.8.3.min.js"></script>
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
	<script type="text/javascript">
	 $(document).ready(function() {
		 $('#announcement').addClass("titleTip");
		 })

	function backAnnouncementList(){
		var studentId=${studentId};
		if(studentId==null||studentId==""||studentId==undefined){
			window.location.href ="<%=path%>/forwardAnnouncementPage.do?pageIndex=1&pageSize=10";
		}else{
		window.location.href ="<%=path%>/listMyDormitoryAnnouncement.do?studentId="+studentId+"&pageIndex=1&pageSize=10";
		}
	}
</script>
<style type="text/css">
.newAnnounceMent {
	color: #fff;
	text-decoration: none;
	background-color: #0074A6;
	height: 50px;
	line-height: 51px;
	line-height: 54px\9;
	line-height: 52px\0;
	border-bottom: 0;
}

.new_notice_top {
	width: 998px;
	background: #64b1cb;
	height: 38px;
	line-height: 38px;
	margin: 0 auto;
}

.new_notice_top_p {
	width: 138px;
	text-align: center;
	font-size: 16px;
	color: #fff;
	float: left;
}

.back {
	float: right;
	padding-right: 100px;
	font-size: 16px;
	color: #fff;
}

.back:hover {
	color: #0074A6;
}

.new_notice_content {
	width: 998;
	overflow: hidden;
	border: 1px solid #eaeef5;
	color: #848484;
	margin: 0 auto;
	padding-top: 20px;
	background: #fff;
}

.new_notice_content h3 {
	font-size: 25px;
	text-align: center;
}

.new_notice_content p {
	font-size: 21px;
	margin-top: 10px;
}

.register-tipMain {
	background: #F6F6F6;
	padding: 24px 120px 0px 150px;
}

.register-tipForm {
	width: 100%;
	padding: 0px 0px 50px 0px;
	border: 1px solid #D7D7D7;
	background: #fff;
}

.new_notice_content {
	width: 998px;
	overflow: hidden;
	border: 1px solid #eaeef5;
	margin: 0 auto;
	padding-top: 20px;
	min-height: 380px;
	padding-bottom: 10px;
}

.new_notice_content ul li {
	margin-left: 8%;
	color: #848484;
	display: inline-block;
	font-size: 15px;
	height: 34px;
	text-align: left;
	width: 75%;
	overflow: hidden;
}

.new_notice_content ul li .notice_date {
	float: right;
	maigin-right: 8%;
}

#page a {
	color: blue;
}

#page a:hover {
	color: #0090CE;
}

.announcementTitle:hover {
	color: #0090CE;
}
</style>

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="register-tipMain">

		<div class="new_notice_top">
			<p class="new_notice_top_p">公告明细</p>
			<p class="back" onclick="backAnnouncementList()">返回公告列表</p>
		</div>
		<div class="new_notice_content">
			<h3>${announcement.title}</h3>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${announcement.content}&nbsp;(时间:${announcement.createTime})</p>
			<span
				style="float: right; font-size: 21px; padding-right: 20px; padding-top: 10px;">宿舍楼:${announcement.buildingId}</span>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>

</html>