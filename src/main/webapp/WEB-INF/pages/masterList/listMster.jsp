<%@ page contentType="text/html; charset=utf-8" language="java"
	%>
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

    function forwardEndPage(interfaceId ,deviceId,totalPages){
    	var pageSize=2;
    	var pageIndex = totalPages;
    	common(deviceId,interfaceId,pageSize,pageIndex);
    }
    function forwardNextPage(interfaceId ,deviceId,pageIndex){
    	var pageIndex = parseInt(pageIndex)+parseInt(1);
    	var pageSize=2;
    	common(deviceId,interfaceId,pageSize,pageIndex);	
   }
    function  forwardHomePage(interfaceId ,deviceId){
    	var pageIndex = 1;
    	var pageSize = 2;
    	common(deviceId,interfaceId,pageSize,pageIndex);
    }
    function  forwardPrePage(interfaceId ,deviceId,pageIndex){
    	var pageIndex = parseInt(pageIndex)-parseInt(1);
    	var pageSize=2;
    	common(deviceId,interfaceId,pageSize,pageIndex);
    } 
   function pageForward(){
	   var pageIndex = document.getElementById('pageIndex').value;
	   var totalPage = document.getElementById('hiddenTotalPage').value;
	    if(!/^\+?[1-9][0-9]*$/.test(pageIndex)){
	    	alert("请输入大于0的页数");
	   }
	   else if(pageIndex>totalPage){
		   alert("跳转页码不能大于总页数");  
	   }
	   else{
		   var pageSize = 5;	  
		   window.location.href="<%=path%>/admin/listMaster.do?pageIndex="+pageIndex+"&pageSize="+pageSize;  
	   }
	   
   }
 
   function paramaterQuery(id,pageIndex){
	   window.location.href ="<%=path%>/getParamater.do?pageIndex="+pageIndex+"&paramaterId="+id;
   }
   function masterDel(id)
   {
       if(confirm('您确定删除该宿管吗？'))
       {
    	   var pageIndex = document.getElementById('hiddenPageIndex').value;
    	   var pageSize=10;
    	   window.location.href ="<%=path%>/admin/removeMaster.do?masterId="+id+"&pageIndex="+pageIndex+"&pageSize="+pageSize;
       }
   }
   function functionCheck(id){
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   var hiddenPageIndex = document.getElementById('backhiddenPageIndex').value;
	  
	   window.location.href ="<%=path%>/getInterface.do?interfaceId="+id+"&pageIndex="+pageIndex+"&hiddenPageIndex="+hiddenPageIndex;
   }
   function addMaster(){
	   window.location.href="<%=path%>/admin/forwardAddMaster.do";
   }
   function masterEdit(id){
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
				<th>楼管名称</th>
				<th>楼管Id</th>
				<th>所在宿舍楼</th>
				<th>手机号码</th>
				<th>身份证</th>
				<th>入职时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="master" items="${data}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${master.name}</td>
					<td>${master.masterId}</td>
					<td>${master.buildingName}</td>
					<td>${master.phoneNumber}</td>
					<td>${master.idCard }</td>
					<td>${master.entryTime }</td>
					<td><input type="button" value="删除" class="crud_device"
						onclick="masterDel(${master.masterId})" /> 
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
				href="<%=path %>/admin/listMaster.do?pageIndex=1&pageSize=5">首页</a></td>
			<td><a
				href="<%=path%>/admin/listMaster.do?pageIndex=${pageIndex-1}&pageSize=5">上一页</a></td>
		</c:if>
		<c:if test="${pageIndex != totalPages}">
			<td><a
				href="<%=path%>/admin/listMaster.do?pageIndex=${pageIndex+1}&pageSize=5">下一页</a></td>
			<td><a
				href="<%=path%>/admin/listMaster.do?pageIndex=${totalPages}&pageSize=5">最后一页</a></td>
		</c:if>
		<c:if test="${pageIndex == totalPages}">
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
		</c:if>
		共${totalPages}页&nbsp;&nbsp; 共${total}条记录&nbsp;&nbsp; <input
			type="text" name="pageIndex" id="pageIndex"
			style="width: 25px; height: 20px;" />&nbsp; <input type="button"
			value="go"
			style="border-radius: 2px; font-size: 12px; background-color: #D7D7D7;"
			onclick="pageForward();">
	</div>
	<input type="hidden" id="hiddenPageIndex" value="${pageIndex}" />
	<input type="hidden" id="backhiddenPageIndex"
		value="${hiddenPageIndex}" />
	<input type="hidden" id="hiddenTotalPage" value="${totalPages}" />
	<a onclick="addMaster();"
		class="button button-glow button-rounded button-raised button-primary">新增楼管</a>

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