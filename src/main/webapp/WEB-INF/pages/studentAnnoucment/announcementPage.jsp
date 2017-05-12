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
	 $(document).ready(function() {
		 $('#announcement').addClass("titleTip");
		 })
	</script>
	<script type="text/javascript">
	$(document).ready(function() {
	 $("#newAnnounceMent").addClass("newAnnounceMent");
	})
	function forwardDetail(id){
		window.location.href ="<%=path%>/getAnnouncement.do?announcementId="+id;
	}
	</script>
	<style type="text/css">
 .newAnnounceMent{
 color:#fff;text-decoration:none;background-color:#0074A6;height:50px;line-height:51px;line-height:54px\9;line-height:52px\0;border-bottom:0;
 }
.new_notice_top{width:998px;background: #64b1cb;height:38px;line-height:38px;
   margin: 0 auto;}
.new_notice_top_p{width:138px;  text-align: center;font-size: 16px;color: #fff;}
.new_notice_content{
width:998;
overflow:hidden;border:1px solid #eaeef5;  
 margin: 0 auto; 
  padding-top: 20px;
  background:#fff;}	
 .register-tipMain{
  background: #F6F6F6;
  padding:24px 120px 0px 150px;
  }
   .register-tipForm{ 
   width:100%;
   padding:0px 0px 50px 0px;
   border: 1px solid #D7D7D7;
   background:#fff;
   }
   .c_orange{color:#FF6700}
   .new_notice_content{
   width:998px;
   overflow:hidden;
   border:1px solid #eaeef5;
   margin: 0 auto; 
   padding-top: 20px;
   min-height:380px;
   padding-bottom:10px;}
   .new_notice_content ul li{
   margin-left:8%;
   color:#848484; 
   display: inline-block;
   font-size: 15px;
   height: 34px;
   text-align:left;
   width:75%;
   overflow: hidden;
   }
   .new_notice_content ul li .notice_date{
   float:right;
   maigin-right:8%;
   }
   #page{
   padding-top:10px;
   }
    #page a{
   color:blue;
   }
   #page a:hover{
   color:#0090CE;
   }
   .announcementTitle:hover{
    color:#0090CE;
   }
   
	</style>
	
  </head> 
  <body >

<jsp:include page="head.jsp"></jsp:include>

   
<div class="register-tipMain">
   
    <div class="new_notice_top">
   <p class="new_notice_top_p">最新公告</p>
     </div>
     <div class="new_notice_content">
   <ul>
   <c:forEach var="announcement" items="${announcementDataList}" varStatus="status">
   <li ><span class="announcementTitle" onclick="forwardDetail(${announcement.announcementId})">
  <c:choose>
   <c:when test="${announcement.importance>0}"><b class="c_orange">*</b></c:when>
   <c:otherwise><b >*</b></c:otherwise></c:choose>
   ${announcement.title}</span> 
   <span class="notice_date">${announcement.createTime}</span></li>
   </c:forEach>
   </ul>
   <div id="page" style="text-align:center;margin-top:5px;">
           当前第${pageIndex}页&nbsp;&nbsp;
     <c:if test="${pageIndex==1}">
				<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
	 </c:if>
	 <c:if test="${pageIndex>1}">
			<td><a
				href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=1&pageSize=10">首页</a></td>
			<td><a
               href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=${pageIndex-1}&pageSize=10">上一页</a></td>
	</c:if>
	 <c:if test="${pageIndex != totalPages}">
				<td><a
					href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=${pageIndex+1}&pageSize=10">下一页</a></td>
				<td><a
					href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=${totalPages}&pageSize=10">最后一页</a></td>
		</c:if>
	  <c:if test="${pageIndex == totalPages}">
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
	  </c:if>
           共${totalPages}页&nbsp;&nbsp;
           共${total}条记录&nbsp;&nbsp;
      </div>
			</div>
   </div>
<jsp:include page="foot.jsp"></jsp:include>
  </body>
  
</html>