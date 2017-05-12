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
    #postCard{
 color:#fff;text-decoration:none;background-color:#0074A6;height:50px;line-height:51px;line-height:54px\9;line-height:52px\0;border-bottom:0;
 }
  </style>
	
  </head>
  
  <body >
    <jsp:include page="title.jsp"></jsp:include>
    <div class="register-main">
    <div class="register-form" style="min-height:380px;">
    <h3 class="content-hd"><b>我的明信片</b><label class="c_orange">(*可以查看宿舍所有相关本人的明信片)</label></h3>
   
	<table id="repairTable"
			>	<tr
					style="background:#E0F1FE;height:45px;border-bottom:solid 1px #a0c6e5;">
					<td style="border-right:solid 1px #a0c6e5;width:80px;">序号</td>
					<td style="border-right:solid 1px #a0c6e5;width:90px;">收明信片名字</td>
					<td style="border-right:solid 1px #a0c6e5;">宿舍楼</td>
					<td style="border-right:solid 1px #a0c6e5;width:90px;">时间</td>
					<td style="border-right:solid 1px #a0c6e5;">状态</td>
					<td style="border-right:solid 1px #a0c6e5;width:50px;">操作</td>		
				</tr>
				
	<c:forEach items="${data}" var="postCard" varStatus="b">
	  <tr>
	  <td>${b.index+1}</td>
	  <td>${postCard.studentId}</td>
	  <td>${postCard.dormitoryId}</td>
	  <td>${postCard.createTime}</td>
	  <td style="color:red"><c:if test="${postCard.state==1}">已领取</c:if>
	  <c:if test="${postCard.state==0}">未领取</c:if>
	  </td>
	   <td><input type="button"  class="button" onclick="getPostCard('${postCard.state}')"
      onMouseOver="this.style.backgroundColor ='#7ACD00';" onMouseOut="this.style.backgroundColor ='#188808';"
       value="领取"  /></td>
	  </tr>
		</c:forEach>
		</table>
		 <div id="page" style="text-align:center;margin-top:15px;">
           当前第${pageIndex}页&nbsp;&nbsp;
     <c:if test="${pageIndex==1}">
				<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
	 </c:if>
	 <c:if test="${pageIndex>1}">
			<td><a
				href="<%=path%>/student/listPostcardByStudentId.do?studentId=${studentId}&pageIndex=1&pageSize=6">首页</a></td>
			<td><a
               href="<%=path%>/student/listPostcardByStudentId.do?studentId=${studentId}&pageIndex=${pageIndex-1}&pageSize=6">上一页</a></td>
	</c:if>
	 <c:if test="${pageIndex != totalPages}">
				<td><a
					href="<%=path%>/student/listPostcardByStudentId.do?studentId=${studentId}&pageIndex=${pageIndex+1}&pageSize=6">下一页</a></td>
				<td><a
					href="<%=path%>/student/listPostcardByStudentId.do?studentId=${studentId}&pageIndex=${totalPages}&pageSize=6">最后一页</a></td>
		</c:if>
	  <c:if test="${pageIndex == totalPages}">
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
	  </c:if>
           共${totalPages}页&nbsp;&nbsp;
           共${total}条记录&nbsp;&nbsp;
      </div>
	<div style="clear:both;"></div>
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
					<h4 class="modal-title" id="myModalLabel">错误提示</h4>
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