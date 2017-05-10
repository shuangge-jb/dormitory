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
	function forwardDetail(id){
		window.location.href ="<%=path%>/getAnnouncement.do?announcementId="+id;
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
      width:67px;
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
 #newAnnounceMent{
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
   <img src="images/scut_new_logo1.jpg" width="73px" height="75px">
   <div class="top_h2">
        华南理工大学虚拟宿舍
   </div>
	</div>
	</div>
		<div id="nav">
<div class="navc">
<a href="<%=path%>/homePage.jsp">首页</a><em></em>
<a href="http://www.mb5u.com/wangyemoban/">网页模板</a>
<a href="http://www.mb5u.com/cmsmoban/">程序模板</a><em></em>
<a href="http://www.mb5u.com/edu/">建站教程</a>
<a href="http://www.mb5u.com/shipinjiaocheng/">视频教程</a><em></em>
<a href="http://www.mb5u.com/jscode/">网页特效</a>
<a href="http://www.mb5u.com/sucai/">图标素材</a>
<a href="http://www.mb5u.com/zitixiazai/">字体下载</a><em></em>
<a href="http://t.mb5u.com/">站长工具</a>
<a href="<%=path%>/listMyDormitoryAnnouncement.do?pageIndex=1&pageSize=10" id="newAnnounceMent">宿舍公告</a>
</div>
</div>
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
				href="<%=path%>/listMyDormitoryAnnouncement.do?pageIndex=1&pageSize=10">首页</a></td>
			<td><a
               href="<%=path%>/listMyDormitoryAnnouncement.do?pageIndex=${pageIndex-1}&pageSize=10">上一页</a></td>
	</c:if>
	 <c:if test="${pageIndex != totalPages}">
				<td><a
					href="<%=path%>/listMyDormitoryAnnouncement.do?pageIndex=${pageIndex+1}&pageSize=10">下一页</a></td>
				<td><a
					href="<%=path%>/listMyDormitoryAnnouncement.do?pageIndex=${totalPages}&pageSize=10">最后一页</a></td>
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