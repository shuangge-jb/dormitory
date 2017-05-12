<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
.lostFondMain{
  background: #F6F6F6;
  padding:24px 120px 0px 150px;
  }
   .lostFond-form{ 
   padding:10px 10px 40px 10px;
   border: 1px solid #D7D7D7;
   background:#fff;
   }
   .content-hd{
     color: #0099FE;
     font-size: 14px;
     border-bottom: 1px solid #E3E3E3;
     height:30px;
     line-height:30px;
     padding-right: 10px;
     margin-bottom:20px;}
     .c_orange{color:#FF6700}
       #page a{
   color:blue;
   }
     #page a :hover{
   color:#0090CE;
   }
</style>
<title>My JSP 'Main.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" />
<script src="<%=path%>/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/mydevice/mydevicehead.css" media="all"/>
<script type="text/javascript">
$(document).ready(function() {
	 $('#lostFond').addClass("titleTip");
	 })
	 function verifyTip(){
	$('#myModal').modal('show');
	//alert("设备名称不能为空");
	$(".modal-body").text("请带有效证件去对应的楼管处认领");
   }
   function checkDetail(detail){
	   
	   $('#myDetailModal').modal('show');
		//alert("设备名称不能为空");
		$(".modal-body").text(detail);
   }
</script>


<body>
<jsp:include page="title.jsp"></jsp:include>
 <div class="lostFondMain">
 <div class="lostFond-form" style="min-height:380px;">
   <h3 class="content-hd"><b>&nbsp;&nbsp;失物招领信息</b>
   <label class="c_orange">(*如果是你的物品，请带证件去对应的楼管认领)</label></h3>
 <c:forEach items="${data}" var="lostFound" varStatus="b">
		<div
			style="width:100%;height:180px;margin-top:10px;border-bottom:1px solid #D7D7D7;">
			<div
				style="float:left;margin-top:5px;margin-left:5px;margin-bottom:5px;">
				<img src="<%=path%>/images/test/image1.jpg" width="220" height="160" 
					alt="whx" />
			</div>
			<div style="margin-left:12px;float:left;width:500px;">
				<div style="margin-top:4px;">
					<font color=#65C0EE size=5> ${lostFound.content}
					</font>
				</div>
				<div style="margin-top:6px;">
					<font color=#818181 size=2>发布人：</font> <font color=#EF972B size=3>
					 李子龙</font>
				</div>
			
				<div style="margin-top:6px;">
					<font color=#818181 size=2>拾取时间：</font> <font color=#EF972B size=3>
					${lostFound.createTime}</font>
				</div>
				<div style="margin-top:6px;">
					<font color=#818181 size=2>拾物地点：</font> <font color=#EF972B size=3>
					C10篮球场 </font>
				</div>
				<div style="margin-top:6px;">
					<font color=#818181 size=2>认领状态：</font> <font color=#EF972B size=3>
					<c:if test="${lostFound.state==0}">未认领</c:if>
					<c:if test="${lostFound.state==1}">已认领</c:if> </font>
				</div>
					<div style="margin-top:6px;">
					<span style="color:#818181;font-size:13"
					onMouseOver="this.style.color='#EF972B';"
				onMouseOut="this.style.color ='#818181';" onclick="checkDetail('${lostFound.content}');">查看详细描述</span>
				</div>
			</div>
			<div
				style="width:85;height:56;float:left;text-align:center;line-height:56px;margin-top:60px;
              margin-left:50px;background:#F7B52C;"
				onMouseOver="this.style.backgroundColor='#FFD700';"
				onMouseOut="this.style.backgroundColor ='#F7B52C';">
				<a onclick="verifyTip();"
					style="text-decoration: none"><font size=3 color=#FEFAF5>
						认领</font></a>
			</div>
		</div>
</c:forEach>
 <div id="page" style="text-align:center;margin-top:12px;">
           当前第${pageIndex}页&nbsp;&nbsp;
     <c:if test="${pageIndex==1}">
				<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
	 </c:if>
	 <c:if test="${pageIndex>1}">
			<td><a
				href="<%=path%>/listLostFound.do?pageIndex=1&pageSize=3"">首页</a></td>
			<td><a
               href="<%=path%>/listLostFound.do?pageIndex=${pageIndex-1}&pageSize=3"">上一页</a></td>
	</c:if>
	 <c:if test="${pageIndex != totalPages}">
				<td><a
					href="<%=path%>/listLostFound.do?pageIndex=${pageIndex+1}&pageSize=3"">下一页</a></td>
				<td><a
					href="<%=path%>/listLostFound.do?pageIndex=${totalPages}&pageSize=3">最后一页</a></td>
		</c:if>
	  <c:if test="${pageIndex == totalPages}">
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
	  </c:if>
           共${totalPages}页&nbsp;&nbsp;
           共${total}条记录&nbsp;&nbsp;
      </div>
 </div>
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
	<!-- 详细描述框（Modal） -->
	<div class="modal fade" id="myDetailModal" tabindex="-1" role="dialog"
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
  <jsp:include page="foot.jsp"></jsp:include> 
</body>

</html>
