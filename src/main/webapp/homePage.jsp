<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/sucaijiayuan.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/homePage.css"/>
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/slide.js"></script>
<script type="text/javascript" src="<%=path%>/js/animation.js"></script>
<script type="text/javascript">
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
	function lostfound(){
	window.location.href="<%=path%>/listLostFound.do?pageIndex=1&pageSize=3";
	}
	function announcement(){
		window.location.href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=1&pageSize=10";
		}
	$(document).ready(function(){  
	   $.ajax({
		   type:"post",
	       url:'<%=path%>/listAnnouncementLimit.do',
	       dataType:"json",
	       data:{n:6},
	       success:function(data){
	    	 var device = data;
	    	 for(var i=0;i<data.length;i++){
	    		 var li = "<li>"+data[i].title+"<span class=\"liDate\">"+data[i].createTime+"</span></li>";
	    		 $("#ilistTile2").append(li);
	    	 }	
	    	 
	       }    
	   })
	    $.ajax({
		   type:"post",
	       url:'<%=path%>/listLostFoundLimit.do',
	       dataType:"json",
	       data:{n:6},
	       success:function(data){
	    	 var device = data;
	    	 for(var i=0;i<data.length;i++){
	    		 var li = "<li>"+data[i].content+"<span class=\"liDate\">"+data[i].createTime+"</span></li>";
	    		 $("#ilistTile1").append(li);
	    	 }	
	    	 
	       }    
	   })
	   
	})
</script>

</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div id="top">
		<div class="top_left">
			<img src="<%=path%>/images/scut_new_logo1.jpg" width="73px"
				height="75px">
			<div class="top_h2">华南理工大学虚拟宿舍</div>
		</div>
	</div>
	<div id="nav">
	<div class="navc">
			<a href="<%=path%>/homePage.jsp" id="homePage">首页</a><em></em> <a
				href="<%=path%>/student/listUserDevice.do?pageIndex=1&pageSize=6"
            id="myDormitoryDevice">我的设备</a><em></em>
			<a href="<%=path%>/listLostFound.do?pageIndex=1&pageSize=3">失物招领</a><em></em>
			<a href="<%=path%>/student/listRepairRecordByDormitoryId.do?dormitoryId=${dormitoryId}&pageIndex=1&pageSize=2">我的报修</a><em></em>
			<a href="<%=path%>/student/listPostcardByStudentId.do?studentId=${studentId }&pageIndex=1&pageSize=6">宿舍明信片</a><em></em>
			 <a href="<%=path%>/student/virtualDormitory.do">虚拟宿舍</a><em></em> <a
				href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=1&pageSize=10">最新公告</a><em></em>
			<a href="<%=path%>/student/getStudentInfo.do?studentId=${studentId }">个人中心</a>
			<a href="#">使用指南</a>
		</div>
		</div>
		<div>
   <div class="ca1_slide" style="padding-left:122px;float:left;margin-top:15px;"> 
	<div id="slider-wrapper"> 
		<div id="slider-bg">				
				<div id="slider-photos"> 
					<div id="slides"> 
						<div class="slides_container"> 						 		 
			<div class="slide"> 
               <img src="<%=path %>/images/2.jpg" width="700" height="300" alt="whx"/> 
               <div class="caption" style="bottom:0"> 
                <h1><a href="#" style="text-decoration:none;font-size:12px;"><b>登陆试试看看有没有你的明信片吧</b></a></h1> 
              </div> 
            </div>                                                                                                                                                                <div class="slide"> 
                <img src="<%=path %>/images/4.jpg" width="700" height="300" alt="whx"/> 
                <div class="caption" style="bottom:0"> 
                  <h1><a href="#" style="text-decoration:none;font-size:12px;"><b>看看公告，今天有没有来收水壶的？</b></a></h1> 
                 </div> 
			</div> 
			<div class="slide"> 
			<img src="<%=path %>/images/1.jpg" width="700" height="300" alt="whx"/> 
			  <div class="caption" style="bottom:0"> 
				<h1><a href="#" style="text-decoration:none;font-size:12px;"><b>我们虚拟宿舍新增了电表设备，可以方便查询电费啦</b></a></h1> 
				</div> 
         </div> 
                                                                                                                                                                     <div class="slide"> 
              <img src="<%=path %>/images/3.jpeg" width="700" height="300" alt="whx"/> 
            <div class="caption" style="bottom:0"> 
               <h1><a href="#" style="text-decoration:none;font-size:12px;"><b>去看看有没有你丢的东西吧</b></a></h1> 
            </div> 
        </div> 
          </div>	
            <a href="#" class="prev"><img src="<%=path %>/images/arrow-prev.png" width="30" height="70" alt="Arrow Prev" border="0"></a> 
            <a href="#" class="next"><img src="<%=path %>/images/arrow-next.png" width="30" height="70" alt="Arrow Next" border="0"></a>								
		</div> 
	</div> 
	</div> 
	</div>
	</div>
	<div id="login" style="width:250px; height:450;border:1px solid #D0D0D0;float:left;margin-left:6px;margin-top:15px;">
	<div style="width:250px;height:40px;border:0px solid #000;background-color:#F2F2F2;line-height:40px;">
    <font style="margin-left:10px" size=4><b>用户登录</font>  </div>
    <font color="red">
    </font>
    <form action="<%=path%>/student/studentLogin.do" method="post">
    <table id="loginTip">
    <tr><td>用户名:</td></tr>
    <tr><td><input type="text" name="id" class="inputTxt"/></td></tr>
    <tr><td>密码:</td></tr>
	<tr><td><input type="password" name="password" class="inputTxt"/></td></tr>
	<tr ><td>
	<input  type="submit" value="登录" class="registerSubmit">
	<input type="button" value="注册" class="registerSubmit" />
	</td>
	</tr>
	<tr><td><a href="#" style="color:blue">忘记密码？</a></td></tr>	
    </table>
    <font color=red>${tip4}</font>
    </form>
</div>
</div>
<div id="ilistTile1" class="titleAnother">
<h6><a href="<%=path%>/listLostFound.do?pageIndex=1&pageSize=3">失物招领</a><span onclick="lostfound();">进去看看</span></h6>
<ul>

</ul>
</div>
<div id="ilistTile2" class="titleAnother"><h6><a href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=1&pageSize=10">公告列表</a><span onclick="announcement();">进去看看</span></h6>
<ul>
</ul>
</div>
  <div class="foot"  style="margin-top:600px;">
  <div class="footer-content">
          <img src="<%=path%>/images/scut.jpg" width="32px" height="30spx" style="vertical-align:middle;"
           >
        <span class="top_h5" >
                 华南理工大学虚拟宿舍
        </span>   
   </div> 
		<div>
	   <ul>
     <li style="list-style:none;display:block;text-align:center;color:#929699;line-height:25px;font-size:12px;">               
                   地址：华南理工大学 C10 &nbsp;  技术支持：华工软件学院 &nbsp; 华南理工大学软件学院版权所有
     </li>
     <li style="list-style:none;text-align:center;color:#929699;line-height:25px;font-size:12px;" > 
                 粤ICP备12059770号   &nbsp; 粤公网安备 44010402000394号
     </li> 
   </ul>
   </div>
   </div>
</body>

</html>