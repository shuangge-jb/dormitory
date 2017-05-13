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
<link rel="stylesheet" type="text/css" href="css/sucaijiayuan.css"/>
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/slide.js"></script>
<script type="text/javascript" src="js/animation.js"></script>
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

#homePage {
	color: #fff;
	text-decoration: none;
	background-color: #0074A6;
	height: 50px;
	line-height: 51px;
	line-height: 54px\9;
	line-height: 52px\0;
	border-bottom: 0;
}
</style>

</head>

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

#homePage {
	color: #fff;
	text-decoration: none;
	background-color: #0074A6;
	height: 50px;
	line-height: 51px;
	line-height: 54px\9;
	line-height: 52px\0;
	border-bottom: 0;
}
#loginTip td{
  height:40px;
  font-size:15px;
  font-weight:normal;
}
.inputTxt {
	outline: none;
	border: 1px solid #CCC;
	padding: 5px;
	-webkit-box-shadow: #DFDFDF 0 1px 2px 0 inset;
	box-shadow: #DFDFDF 0 1px 2px 0 inset;
	width: 200px;
	color: #666;
	height: 28px;
	background: #fff;
	border-radius: 3px;
	line-height: 28px;
	overflow: hidden;
}
.registerSubmit{
margin-top:20px;
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
    .registerSubmit:hover {
    text-shadow:0 0 2px rgb(255,255,255);
    box-shadow:inset 0 1px 0 rgb(86,174,251),0 0 10px 3px rgba(74,162,241,0.5);
}
#ilistTile1
{float:left;width:480px;border-bottom:1px solid #e5e5e5;
text-align:left; margin-left:152px;}
#ilistTile2 
{float:left;width:480px;border-bottom:1px solid #e5e5e5;
text-align:left; margin-left:2px;}
.titleAnother{
  height:225px;margin-top:10px;border: 1px solid #D7D7D7;
}
.titleAnother h6{color: #444;
    background: #f9803a;
    padding: 0px;
    font-size: 15px;
    padding-left: 20px;
    line-height: 35px;
    height: 35px;
    }
    .titleAnother li{
    float:left;font-size:13px;
    width:460px;line-height:29px;
    height:29px;overflow:hidden;
    padding-left: 10px;
     color: #848484;
     font-weight:normal;
    }
   .titleAnother h6 a{
   color:#fff;
   } 
     .titleAnother h6 span { float: right;
    font-size: 12px;
    color: #fff;
    font-weight: normal;
    padding-right: 20px;
    }
    .liDate{
    float:right; font-size:13px;
    font-weight:normal; padding-left:10px;
    padding-right: 20px;color: #848484;
    }
  	.foot{
	background: #F6F6F6;
	text-align:center;
	line-height:30px;
	padding-top:20px;
	}  
</style>

</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div id="top">
		<div class="top_left">
			<img src="/dormitory/images/scut_new_logo1.jpg" width="73px"
				height="75px">
			<div class="top_h2">华南理工大学虚拟宿舍</div>
		</div>
	</div>
	<div id="nav">
	<div class="navc">
			<a href="<%=path%>/homePage.jsp" id="homePage">首页</a><em></em> <a
				href="<%=path%>/student/listUserDevice.do?pageIndex=1&pageSize=8"
            id="myDormitoryDevice">我的设备</a><em></em>
			<a href="<%=path%>/listLostFound.do?pageIndex=1&pageSize=3">失物招领</a><em></em>
			<a href="<%=path%>/student/listRepairRecordByDormitoryId.do?dormitoryId=${dormitoryId}&pageIndex=1&pageSize=2">我的报修</a><em></em>
			<a href="<%=path%>/student/listPostcardByStudentId.do?studentId=${studentId }&pageIndex=1&pageSize=6">宿舍明信片</a><em></em>
			 <a href="#">虚拟宿舍</a><em></em> <a
				href="<%=path%>/listMyDormitoryAnnouncement.do?studentId=${studentId }&pageIndex=1&pageSize=10">最新公告</a><em></em>
			<a href="#">使用指南</a>
		</div>
		</div>
		<div>
   <div class="ca1_slide" style="padding-left:152px;float:left;margin-top:15px;"> 
	<div id="slider-wrapper"> 
		<div id="slider-bg">				
				<div id="slider-photos"> 
					<div id="slides"> 
						<div class="slides_container"> 						 		 
			<div class="slide"> 
               <img src="images/2.jpg" width="700" height="300" alt="whx"/> 
               <div class="caption" style="bottom:0"> 
                <h1><a href="#" style="text-decoration:none;font-size:12px;"><b>登陆试试看看有没有你的明信片吧</b></a></h1> 
              </div> 
            </div>                                                                                                                                                                <div class="slide"> 
                <img src="images/4.jpg" width="700" height="300" alt="whx"/> 
                <div class="caption" style="bottom:0"> 
                  <h1><a href="#" style="text-decoration:none;font-size:12px;"><b>看看公告，今天有没有来收水壶的？</b></a></h1> 
                 </div> 
			</div> 
			<div class="slide"> 
			<img src="images/1.jpg" width="700" height="300" alt="whx"/> 
			  <div class="caption" style="bottom:0"> 
				<h1><a href="#" style="text-decoration:none;font-size:12px;"><b>我们虚拟宿舍新增了电表设备，可以方便查询电费啦</b></a></h1> 
				</div> 
         </div> 
                                                                                                                                                                     <div class="slide"> 
              <img src="images/3.jpeg" width="700" height="300" alt="whx"/> 
            <div class="caption" style="bottom:0"> 
               <h1><a href="#" style="text-decoration:none;font-size:12px;"><b>去看看有没有你丢的东西吧</b></a></h1> 
            </div> 
        </div> 
          </div>	
            <a href="#" class="prev"><img src="images/arrow-prev.png" width="30" height="70" alt="Arrow Prev" border="0"></a> 
            <a href="#" class="next"><img src="images/arrow-next.png" width="30" height="70" alt="Arrow Next" border="0"></a>								
		</div> 
	</div> 
	</div> 
	</div>
	</div>
	<div id="login" style="width:250px; height:450;border:1px solid #D0D0D0;float:left;margin-left:10px;margin-top:15px;">
	<div style="width:250px;height:40px;border:0px solid #000;background-color:#F2F2F2;line-height:40px;">
    <font style="margin-left:10px" size=4><b>用户登录</font>  </div>
    <font color="red">
    </font>
    <form action="#" method="post">
    <table id="loginTip">
    <tr><td>用户名:</td></tr>
    <tr><td><input type="text" name="userName" class="inputTxt"/></td></tr>
    <tr><td>密码:</td></tr>
	<tr><td><input type="password" name="userPwd" class="inputTxt"/></td></tr>
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
<h6><a href="#">失物招领</a><span onclick="lostfound();">进去看看</span></h6>
<ul>
<li> 本人在东兴路捡到身份证一张  <span class="liDate">05-01</span></li>
<li>  5月6号（星期六）晚上在丹东月亮岛附近捡到一个钱包！ <span class="liDate">05-02</span></li>
<li>  G7047高铁捡到身份证一张  <span class="liDate">05-01</span></li>
<li> 本人在东兴路捡到身份证一张  <span class="liDate">05-01</span></li>
<li>  Sony蓝牙耳机 <span class="liDate">05-14</span></li>
<li> 本人在东兴路捡到身份证一张  <span class="liDate">05-01</span></li>
</ul>
</div>
<div id="ilistTile2" class="titleAnother"><h6><a href="#">公告列表</a><span onclick="announcement();">进去看看</span></h6>
<ul>
<li>收水费收水费收水费收水费收水费收水费收水费  <span class="liDate">05-01</span></li>
<li>交电费交电费交电费交电费交电费交电费交电费 <span class="liDate">05-02</span></li>
<li>交空调费交空调费交空调费交空调费交空调费交  <span class="liDate">05-01</span></li>
<li>卫生检查卫生检查卫生检查卫生检查卫生检查卫生检查 <span class="liDate">05-01</span></li>
<li>查水表查水表查水表查水表查水表查水表查水表查水表 <span class="liDate">05-14</span></li>
<li> 领蚊香领蚊香领蚊香领蚊香领蚊香领蚊香领蚊香领蚊香 <span class="liDate">05-01</span></li>
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