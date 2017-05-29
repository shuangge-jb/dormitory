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
	<script src="<%=path%>/js/bootstrap.min.js"></script>
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
	function goingRepairRecord(){
		window.location.href ="<%=path%>/repair/listRepairRecord.do?pageIndex=1&pageSize=2";
	}
	function getPostCard(state){
		if(state==1){
			$('#myModal').modal('show');
			//alert("设备名称不能为空");
			$(".modal-body").text("你已经领取了该明信片");
		}
		else{
		$('#myModal').modal('show');
		//alert("设备名称不能为空");
		$(".modal-body").text("请前往楼管那里领取");
		}
	}
	
	</script>

  <style type="text/css">
  #repairTable td{
  border:solid 1.5px #a0c6e5;height:40px;
  }
  #repairTable
  {
  width:800px;
  margin-top:20px;
  text-align:center;
  border-collapse:collapse;
  border:solid 1px #a0c6e5;
  }
  .button {
	background-color:#188808;
	color: #FFFFFF;
	border-radius: 3px;
	width: 50px;
	height: 28px;
	color:#fff;
	/* margin-left: 10px; */
	border-color: #34ABD6;
}
#repairRecord{
   width:87px;
   height:40px;
   background:#E0F1FE;
   border:1px solid #0497FF;
   border-bottom:0px;
   font-size:16px;
   font-weight:bolder;
   color:#029AFF;
}
#applyRepair{
   width:87px;height:40px;
   background:#E0F1FE;border:1px solid #0497FF;
   border-bottom:0px;font-size:16px;
   font-weight:bolder;color:#029AFF;
   }
    #userGuide{
 color:#fff;text-decoration:none;background-color:#0074A6;height:50px;line-height:51px;line-height:54px\9;line-height:52px\0;border-bottom:0;
 }
  </style>
	
  </head>
  
  <body >
    <jsp:include page="title.jsp"></jsp:include>
    <div class="register-main">
    <div class="register-form" style="min-height:380px;">
    <h3 class="content-hd"><b>虚拟宿舍使用指南</b></h3>
    <div style="margin-top:30px;margin-left:100px;"><font color=#333333><b>第一步，登录，如果您是新用户，需先注册再登录。</b></font></div>
   <div style="margin-top:10px;margin-left:100px;"><img src="<%=path%>/images/userGuide/login.png" width="600px" height="280px;"/></div>
   <div style="margin-top:30px;margin-left:100px;"><font color=#333333><b>第二步，点击我的设备，进入设备列表页。</b></font></div>
   <div style="margin-top:10px;margin-left:100px;"><img src="<%=path%>/images/userGuide/myDevice.jpg" width="600px" height="280px;"/></div>
   <div style="margin-top:30px;margin-left:100px;"><font color=#333333><b>第三步，点击其中一个设备，进入功能列表页。</b></font></div>
   <div style="margin-top:10px;margin-left:100px;"><img src="<%=path%>/images/userGuide/myFunction.png" width="600px" height="280px;"/></div>
    <div style="margin-top:30px;margin-left:100px;"><font color=#333333><b>第四步，点击其中一个功能，进入参数请求页。</b></font></div>
   <div style="margin-top:10px;margin-left:100px;"><img src="<%=path%>/images/userGuide/myParameter.png" width="600px" height="280px;"/></div>
   <div style="margin-top:30px;margin-left:100px;"><font color=#333333><b>第五步，填写参数，请求外部系统的数据。</b></font></div>
   <div style="margin-top:10px;margin-left:100px;"><img src="<%=path%>/images/userGuide/requestData.png" width="600px" height="280px;"/></div>
   </div>
  <jsp:include page="foot.jsp"></jsp:include> 
</div>
<!-- 提示框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">温馨提示</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">确定
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>