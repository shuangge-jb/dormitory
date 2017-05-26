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
	  
  });
  function changeState(id,index){
	  $.ajax({
			type:"post",
		    url:"<%=path%>/changeState.do",
		    dataType:"json",
		    data:{lostFoundId:id},
		    success:function(data){	
		    	console.log(data);
		    	//$("#lostFoundState").html("");
		    	$(index).html(data.data);
		    },
		    error:function(data){
		    //alert("请求失败")
		    console.log("请求失败");
		    }
		    });
  }
  function checkDetail(detail){
	  $('#myModal').modal('show');
		$(".modal-body").text(detail);
		return false;
  }
   function deleteStudent(id)
   {
       if(confirm('您确定删除该学生信息吗？'))
       {
    	   var pageIndex=document.getElementById('hiddenPageIndex').value;
    	   var pageSize=5;
    	   window.location.href ="<%=path%>/master/removeStudent.do?studentId="+id+"&masterId=${masterId}&pageIndex="+pageIndex+"&pageSize="+pageSize;
       }
   }
   function addAnnouncement(){
	   window.location.href="<%=path%>/master/forwardAddAnnouncement.do";
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
		<caption>学生列表</caption>
		<thead>
			<tr>
				<th>序号</th>
				<th>学号</th>
				<th>姓名</th>
				<th>手机号</th>
				<th>宿舍号</th>
				<th>床号</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${data}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${student.studentId}</td>
					<td>${student.name}</td>
					<td>${student.phoneNumber}</td>
					<td>${student.room}</td>
					<td>${student.bedId}</td>
					<td><input type="button" value="删除" class="crud_device"
						onclick="deleteStudent(${student.studentId});" /></td>
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
				href="<%=path%>/master/listStudentByMasterId.do?pageIndex=1&pageSize=5&masterId=${masterId}">首页</a></td>
			<td><a
				href="<%=path%>/master/listStudentByMasterId.do?pageIndex=${pageIndex-1}&pageSize=5&masterId=${masterId}">上一页</a></td>
		</c:if>
		<c:if test="${pageIndex != totalPages}">
			<td><a
				href="<%=path%>/master/listStudentByMasterId.do?pageIndex=${pageIndex+1}&pageSize=5&masterId=${masterId}">下一页</a></td>
			<td><a
				href="<%=path%>/master/listStudentByMasterId.do?pageIndex=${totalPages}&pageSize=5&masterId=${masterId}">最后一页</a></td>
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