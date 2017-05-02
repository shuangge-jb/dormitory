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
<link rel="stylesheet" href="css/buttons.css">
<script type="text/javascript">
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
		   var pageSize = 10;	  
		   window.location.href="<%=path%>/listDevice.do?pageIndex="+pageIndex+"&pageSize="+pageSize;  
	   }
	   
   }
   function hospitalDel(id)
   {
       if(confirm('您确定删除该医院吗？'))
       {
           window.location.href="<%=path%>/deleteHospital.action?hospitalId="+id;
       }
   }
   function hospitalCheck(id){
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   window.location.href ="<%=path%>/checkHospitalDetail.action?hospitalId="+id+"&pageIndex="+pageIndex;
   }
   function addDevice(){
	   window.location.href ="<%=path%>/admin/device/addDevice.jsp";
   }
   function editHospital(id){
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   window.location.href="<%=path%>/checkEditHospital.action?hospitalId="+id+"&pageIndex="+pageIndex;
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
   font-size:13px;
   border:3px solid #0090DB;
   background:#0090DB;
   color:#FFEDF1; 
   font-color:#fff;
   }
   .crud_device:hover{
   color:#fff;
   text-decoration:none;
   background-color:#0074A6;
   }
   </style>
</HTML>
  <head>
  </head>
  <body>
  <table 
  style="font-size:15px;color:#333333;text-align:center;margin-left:15px;margin-top:10px;borderColor:#D7D7D7;"
   	cellspacing=0 border="1" width="96%;" cellPadding=1>
							<tr bgcolor=#EBEBEB height=30>
							<td>序号</td><td>设备名称</td><td>设备类型</td><td>设备图像</td><td>操作</td>
							</tr>
       <c:forEach var="device" items="${data}" varStatus="status">
        <tr height=30>
        <td>${status.index+1}</td>
        <td>${ device.name}</td>
        <td>${device.type}</td>
        <td><img id="img1" src="images/test/image1.jpg" width="30px" height="30px" data-action="zoom"></td>
       
           <td><input type="button" value="删除" class="crud_device"
           onclick="deviceDel(${device.deviceId})" />
           <input type="button" value="查看" class="crud_device"
           onclick="deviceCheck(${device.deviceId})" />
           <input type="button" value="修改" class="crud_device"
           onclick="editDevice(${device.deviceId})" />
           </td>
         </tr>
     </c:forEach>
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
	 <c:if test="${pageIndex != totalPage}">
				<td><a
					href="<%=path%>/listDevice.do?pageIndex=${pageIndex+1}&pageSize=10">下一页</a></td>
				<td><a
					href="<%=path%>/listDevice.do?pageIndex=${totalPage}&pageSize=10">最后一页</a></td>
		</c:if>
	  <c:if test="${pageIndex == totalPage}">
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
	  </c:if>
           共${totalPage}页&nbsp;&nbsp;
           共${totalCount}条记录&nbsp;&nbsp;     
      <input type="text" name="pageIndex" id="pageIndex" style="width:25px;height:20px;"/>&nbsp;
      <input type="button" value="go" style="border-radius:2px;font-size:12px;background-color:#D7D7D7;" 
      onclick="pageForward();" >
      </div>
      <input type="button" value="新增设备" onclick="addDevice()"
      style="margin-left:5px;margin-top:10px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:100;position:absolute;background:#0090DB;color:#FFEDF1;"  onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';"/>
      <input type="hidden" id="hiddenPageIndex" value="${pageIndex}"/>
      <input type="hidden" id="hiddenTotalPage" value="${totalPage}"/>
 </body>
 </html>