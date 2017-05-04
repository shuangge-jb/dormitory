<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="error.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="<%=path%>/js/jquery-1.8.3.min.js"></script> 
<script src="<%=path%>/js/zoom.js"></script> 
<link rel="stylesheet" href="<%=path %>/css/zoom.css" media="all" />
<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css" />  
<script src="<%=path%>/js/jquery-2.1.4.min.js"></script> 
<script src="<%=path%>/js/bootstrap.min.js"></script> 
<link rel="stylesheet" href="css/buttons.css">
<script type="text/javascript">
   function pageForward(){
	   var pageIndex = document.getElementById('pageIndex').value;
	   var totalPage = document.getElementById('hiddenTotalPage').value;
	    alert(totalPage);
	    if(!/^\+?[1-9][0-9]*$/.test(pageIndex)){
	    	alert("请输入大于0的页数");
	   }
	   else if(pageIndex>totalPage){
		   alert("跳转页码不能大于总页数");  
	   }
	   else{
		   var pageSize = 10;	  
		   window.location.href="<%=path%>/listDevice.do?pageIndex="+pageIndex+"&pageSize="+pageSize;  
	   }
	   
   }
   function back(id){
  	 window.location.href ="<%=path%>/listDeviceFunction.do?pageIndex="+id+"&pageSize="+10;
  }
   function deviceDel(id)
   {
       if(confirm('您确定删除该医院吗？'))
       {
           window.location.href="<%=path%>/admin/removeDevice.do?deviceId="+id+"&pageIndex="+1+"&pageSize="+10;
       }
   }
   function functionCheck(id){
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   var hiddenPageIndex = document.getElementById('backhiddenPageIndex').value;
	  
	   window.location.href ="<%=path%>/getInterface.do?interfaceId="+id+"&pageIndex="+pageIndex+"&hiddenPageIndex="+hiddenPageIndex;
   }
   function addFunction(deviceId){
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   var hiddenPageIndex = document.getElementById('backhiddenPageIndex').value;  
	   window.location.href ="<%=path%>/forwardAddInterface.do?deviceId="+deviceId+"&pageIndex="+pageIndex+"&hiddenPageIndex="+hiddenPageIndex;
   }
   function editDevice(id){
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   window.location.href="<%=path%>/admin/editDevicePage.do?deviceId="+id+"&pageIndex="+pageIndex;
   }
   </script>
   
   <style type="text/css">
   a{
    text-decoration:none;
    color:blue;
   }
   a:hover{
   color:#0090DB;
   text-decoration:none;
   }
   .crud_device{
   font-weight:bolder;
   font-size:14px;
    background-color: #A5DE37;
  border-color: #A5DE37;
  color: #FFF;
  border-radius:3px;
   }
   .crud_device:hover{
    background-color: #b9e563;
    border-color: #b9e563;
    color: #FFF;
   }
   .crud_device:active
   {
    background-color: #a1d243;
    border-color: #a1d243;
    color: #8bc220;
    }
   </style>
</HTML>
  <head>
  </head>
  <body>
 
      <table class="table table-bordered table-striped table-hover">
	<caption>${device.name}的功能</caption>
	<thead>
		<tr>
			<th>序号</th>
			<th>功能名称</th>
			<th>功能Url</th>
			<th>来源</th>
			<th>类型</th>
			<th>设备图像</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="function" items="${data}" varStatus="status">
		<tr>
			 <td>${status.index+1}</td>
        <td>${function.interfaceName}</td>
        <td>${function.interfaceUrl}</td>
        <td>${function.source}</td>
        <td>${function.method}</td>
        <td><img id="img1" src="images/test/image1.jpg" width="30px" height="30px" data-action="zoom"></td>
        <td>
           <input type="button" value="删除" class="crud_device"
           onclick="deviceDel(${device.deviceId})" />
           <input type="button" value="查看" class="crud_device"
           onclick="functionCheck(${function.interfaceId})" />
           <input type="button" value="修改" class="crud_device"
           onclick="editDevice(${device.deviceId})" />
        </td>
		</tr>
	  </c:forEach>	
	</tbody>
</table>
     <div id="page" style="text-align:center;margin-top:5px;">
           当前第${pageIndex}页&nbsp;&nbsp;
     <c:if test="${pageIndex==1}">
				<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
	 </c:if>
	 <c:if test="${pageIndex>1}">
			<td><a
				href="<%=path%>/listDevice.do?pageIndex=1&pageSize=10">首页</a></td>
			<td><a
               href="<%=path%>/listDevice.do?pageIndex=${pageIndex-1}&pageSize=10">上一页</a></td>
	</c:if>
	 <c:if test="${pageIndex != totalPages}">
				<td><a
					href="<%=path%>/listDevice.do?pageIndex=${pageIndex+1}&pageSize=10">下一页</a></td>
				<td><a
					href="<%=path%>/listDevice.do?pageIndex=${totalPages}&pageSize=10">最后一页</a></td>
		</c:if>
	  <c:if test="${pageIndex == totalPages}">
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
	  </c:if>
           共${totalPages}页&nbsp;&nbsp;
           共${total}条记录&nbsp;&nbsp;     
      <input type="text" name="pageIndex" id="pageIndex" style="width:25px;height:20px;"/>&nbsp;
      <input type="button" value="go" style="border-radius:2px;font-size:12px;background-color:#D7D7D7;" 
      onclick="pageForward();" >
      </div>
       <input type="button" value="返回" onclick="back(${hiddenPageIndex})"
         style="background:#F7B52C;height:30;margin-left:5px;margin-top:10px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:100;position:absolute;background:#0090DB;color:#FFEDF1;" onMouseOver="this.style.backgroundColor='#0074A6';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" />
		<input type="button" value="新增功能" onclick="addFunction(${device.deviceId})"
         style="background:#F7B52C;height:30;margin-left:105px;margin-top:10px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:100;position:absolute;background:#0090DB;color:#FFEDF1;" onMouseOver="this.style.backgroundColor='#0074A6';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" />
      <input type="hidden" id="hiddenPageIndex" value="${pageIndex}"/>
      <input type="hidden" id="backhiddenPageIndex" value="${hiddenPageIndex}"/>
      <input type="hidden" id="hiddenTotalPage" value="${totalPages}"/>
 </body>
 </html>