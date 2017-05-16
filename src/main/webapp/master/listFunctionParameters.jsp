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
<link rel="stylesheet" href="<%=path%>/css/buttons.css">
<script type="text/javascript">
$(document).ready(function(){  
	   // 初始化内容
	  $("#deviceSelect").change(function(){	
		 var id =$(this).children('option:selected').val();
		  $.ajax({
			   type:"post",
			   url:'<%=path%>/listFunctionByDeviceIdJSON.do',
			   data:{deviceId:id},
			   dataType:"json",
			   success:function(data){
				   var interFunction= data;
				   $("#functionSelect").empty(); 
				   for(var key in interFunction){
				   $("<option value='"+interFunction[key].id+"'>"+interFunction[key].name+"</option>").appendTo("#functionSelect"); 
				   }
				   }  
		   
		   })
		   
	  }) 
	   $.ajax({
		   type:"post",
	       url:'<%=path%>/listDeviceJSON.do',
	       dataType:"json",
	       success:function(data){
	    	 var device = data;
	    	 for(var key in device){
	    		 var id = device[key].id;
	    		 
	    		 $("<option value='"+device[key].id+"'>"+device[key].name+"</option>").appendTo("#deviceSelect"); 
	    	 }
	       }
	       
	   }) 
 
});  
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
   function editDeviceFunction(id){
	   var pageIndex = document.getElementById('hiddenPageIndex').value;
	   var hiddenPageIndex = document.getElementById('backhiddenPageIndex').value; 
	   window.location.href="<%=path%>/forwardEditInterface.do?interfaceId="+id+"&pageIndex="+pageIndex+"&hiddenPageIndex="+hiddenPageIndex;
   }
   </script>
   <style type="text/css">
 
   a:hover{
   color:#0090DB;
   text-decoration:none;
   }
  a{
    text-decoration:none;
    color:blue;
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
    .inputTxt{
     outline:none;
     border:1px solid #CCC;
     padding:5px;
     -webkit-box-shadow:#DFDFDF 0 1px 2px 0 inset;
     box-shadow:#DFDFDF 0 1px 2px 0 inset;
     width:200px;color:#666;height:28px;
     background:#fff;
     border-radius:3px;
     line-height:28px;
     overflow:hidden;}
    .textAreaTxt{
      outline:none;
     border:1px solid #CCC;
     -webkit-box-shadow:#DFDFDF 0 1px 2px 0 inset;
     box-shadow:#DFDFDF 0 1px 2px 0 inset;
     color:#666;
     background:#fff;
     border-radius:3px;
     line-height:28px;
     overflow:hidden;
     margin-top:5px;
     width:290px;
     height:150px;
     }
   </style>
</HTML>
  <head>
  </head>
  <body>
  <form action="<%=path%>/listParamByInterfaceId.do" method="post">
     筛选： <select name="deviceId" id="deviceSelect"
					class="inputTxt" >	
				</select>
			<select name="interfaceId" id="functionSelect"
					class="inputTxt" >	
			</select>
			<input type="hidden" name="pageIndex" value="1"/>
			<input type="hidden" value="10" name="pageSize" />
			<input type="submit" value="查询"/>
  </form>
  <c:forEach var="parameters" items="${data}" varStatus="status">
     ${parameters.functionName}
  </c:forEach>
      <table class="table table-bordered table-striped table-hover">
	<caption>的功能1</caption>
	<thead>
		<tr>
			<th>序号</th>
			<th>参数名称</th>
			<th>参数类型</th>
			<th>参数所属接口</th>
			<th>参数所属设备</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			 <td>1</td>
        <td>dateTime</td>
        <td>time</td>
        <td>查看本月电费</td>
        <td>电表</td>
        <td>
           <input type="button" value="删除" class="crud_device"
           onclick="deviceDel(${device.deviceId})" />
           <input type="button" value="查看" class="crud_device"
           onclick="functionCheck(${function.interfaceId})" />
           <input type="button" value="修改" class="crud_device"
           onclick="editDeviceFunction(${function.interfaceId})" />
        </td>
		</tr>
		<tr>
			 <td>2</td>
        <td>dormitoryId</td>
        <td>Integer</td>
        <td>查看本宿舍电费</td>
        <td>电表</td>
        <td>
           <input type="button" value="删除" class="crud_device"
           onclick="deviceDel(${device.deviceId})" />
           <input type="button" value="查看" class="crud_device"
           onclick="functionCheck(${function.interfaceId})" />
           <input type="button" value="修改" class="crud_device"
           onclick="editDeviceFunction(${function.interfaceId})" />
        </td>
		</tr>
		<tr>
			 <td>2</td>
        <td>dormitoryId</td>
        <td>Integer</td>
        <td>查看本宿舍电费</td>
        <td>电表</td>
        <td>
           <input type="button" value="删除" class="crud_device"
           onclick="deviceDel(${device.deviceId})" />
           <input type="button" value="查看" class="crud_device"
           onclick="functionCheck(${function.interfaceId})" />
           <input type="button" value="修改" class="crud_device"
           onclick="editDeviceFunction(${function.interfaceId})" />
        </td>
		</tr>
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