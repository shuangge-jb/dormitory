<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="<%=path%>/js/jquery-1.8.3.min.js"></script>
<script src="<%=path%>/js/zoom.js"></script>
<link rel="stylesheet" href="<%=path%>/css/zoom.css" media="all" />
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" />
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/buttons.css">
<script type="text/javascript">

  $(document).ready(function(){
  function changeState(id){
	  $.ajax({
			type:"post",
		    url:'#',
		    dataType:"json",
		    data:{lostFoundId:id},
		    success:function(data){	
		    	$("#lostFoundState").html("");
		    	$("#lostFoundState").html(data);
		    },
		    error:function(data){
		    //alert("请求失败")
		    }
  })
  })

  function checkDetail(detail){
	  $('#myModal').modal('show');
		$(".modal-body").text(detail);
		return false;
  }
   function lostFoundDel(id)
   {
       if(confirm('您确定删除该失物招领信息吗？'))
       {
    	   window.location.href ="#";
       }
   }
   function functionCheck(id){
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   var hiddenPageIndex = document.getElementById('backhiddenPageIndex').value;
	  
	   window.location.href ="<%=path%>/getInterface.do?interfaceId="+id+"&pageIndex="+pageIndex+"&hiddenPageIndex="+hiddenPageIndex;
   }
   function addLostFound(){
	   window.location.href="<%=path%>/master/forwardAddLostFound.do";
   }
   function paramaterEdit(id){
	   //alert("修改"+id);
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   var pageSize=10;
	   window.location.href ="<%=path%>/forwordEditParam.do?paramaterId="+id+"&pageIndex="+pageIndex+"&pageSize="+pageSize;
   }
  
   </script>
<style type="text/css">
a:hover {
	color: #0090DB;
	text-decoration: none;
}

a {
	text-decoration: none;
	color: blue;
}

.blue {
	color: blue;
}

.blue:hover {
	color: #0090DB;
}

.crud_device {
	font-weight: bolder;
	font-size: 14px;
	background-color: #A5DE37;
	border-color: #A5DE37;
	color: #FFF;
	border-radius: 3px;
}

.crud_device:hover {
	background-color: #b9e563;
	border-color: #b9e563;
	color: #FFF;
}

.crud_device:active {
	background-color: #a1d243;
	border-color: #a1d243;
	color: #8bc220;
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

.textAreaTxt {
	outline: none;
	border: 1px solid #CCC;
	-webkit-box-shadow: #DFDFDF 0 1px 2px 0 inset;
	box-shadow: #DFDFDF 0 1px 2px 0 inset;
	color: #666;
	background: #fff;
	border-radius: 3px;
	line-height: 28px;
	overflow: hidden;
	margin-top: 5px;
	width: 290px;
	height: 150px;
}

#page {
	text-align: center;
	margin-top: 5px;
}
</style>
</HTML>
<head>
</head>
<body>
	<table class="table table-bordered table-striped table-hover"
		id="parametersTable">
		<caption>参数列表</caption>
		<thead>
			<tr>
				<th>序号</th>
				<th>发布人</th>
				<th>物品</th>
				<th>时间</th>
				<th>地点</th>
				<th>是否已领取</th>
				<th>详情</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="lostFound" items="${data}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${lostFound.publisher}</td>
					<td>${lostFound.content}</td>
					<td>${lostFound.createTime}</td>
					<td>${lostFound.place}</td>
					<td id="lostFoundState"><c:if test="${lostFound.state==0}">未认领</c:if>
					<c:if test="${lostFound.state==1}">已认领</c:if> </td>
					<td><span style="color:blue;" onclick="checkDetail('${lostFound.content}')">查看详情</span></td>
					<td><input type="button" value="删除" class="crud_device"
						onclick="lostFoundDel(${lostFound.lostFoundId});" /> 
						<input type="button" value="确认领取" class="crud_device"
						onclick="changeState(${lostFound.lostFoundId});" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="page">
		当前第${pageIndex}页&nbsp;&nbsp;
		<c:if test="${pageIndex==1}">
			<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
		</c:if>
		<c:if test="${pageIndex>1}">
			<td><a
				href="<%=path%>/master/listLostFoundByMasterId.do?pageIndex=1&pageSize=5&masterId=${masterId}">首页</a></td>
			<td><a
				href="<%=path%>/master/listLostFoundByMasterId.do?pageIndex=${pageIndex-1}&pageSize=5&masterId=${masterId}">上一页</a></td>
		</c:if>
		<c:if test="${pageIndex != totalPages}">
			<td><a
				href="<%=path%>/master/listLostFoundByMasterId.do?pageIndex=${pageIndex+1}&pageSize=5&masterId=${masterId}">下一页</a></td>
			<td><a
				href="<%=path%>/master/listLostFoundByMasterId.do?pageIndex=${totalPages}&pageSize=5&masterId=${masterId}">最后一页</a></td>
		</c:if>
		<c:if test="${pageIndex == totalPages}">
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
		</c:if>
		共${totalPages}页&nbsp;&nbsp; 共${total}条记录&nbsp;&nbsp; 
	</div>
	<input type="hidden" id="hiddenPageIndex" value="${pageIndex}" />
	<input type="hidden" id="backhiddenPageIndex"
		value="${hiddenPageIndex}" />
	<input type="hidden" id="hiddenTotalPage" value="${totalPages}" />
	<a onclick="addLostFound();"
		class="button button-glow button-rounded button-raised button-primary">新增失误招领</a>

	<!-- 错误提示框（Modal） -->
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