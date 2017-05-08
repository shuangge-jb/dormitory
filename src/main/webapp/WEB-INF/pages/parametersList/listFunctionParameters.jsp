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
	  var interfaceId;
	  var deviceId;
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
	    		 $("<option value='"+device[key].id+"'>"+device[key].name+"</option>").appendTo("#deviceSelect"); 
	    	 }
	    	 
	       }
	       
	   })
	 
	   $("#query").click(function(){
		 var deviceId=$('#deviceSelect option:selected').val();
		 var interfaceId = $('#functionSelect option:selected').val();
		 if(deviceId==null||deviceId==""){
			 $('#myModal').modal('show');
			 $(".modal-body").text("请选择设备！");
		 }
		 else  if(interfaceId==null||interfaceId==""){
			 $('#myModal').modal('show');
			 $(".modal-body").text("该设备还没添加功能，请前往添加！");
		 }
		 else{
         $.ajax({
        	type:"post",
        	url:'<%=path%>/listParamByInterfaceId.do',
        	data:{deviceId:deviceId,interfaceId:interfaceId,pageSize:2,pageIndex:1},
        	dataType:"json",
        	success:function(data){
        		$("#parametersTable tbody").html("");
        		if(data.data.length>0){
        		for(var i=0;i<data.data.length;i++){
        		var tr = "<tr><td>"+(i+1)+"</td><td>"+data.data[i].paramaterName+"</td>"+
        		"<td>"+data.data[i].type+"</td><td>"+data.data[i].functionName+"</td>"+
        		"<td>"+data.data[i].deviceName+"</td>"+
        		"<td><input type='button' value='删除' class='crud_device' "+
        		"onclick=\"paramaterDel('"+data.data[i].paramaterId+"')\">"+
        		"<input type='button' value='修改' class='crud_device' "+
        		"onclick=\"paramaterEdit('"+data.data[i].paramaterId+"','"+data.pageIndex+"')\">"+
        		"<input type='button' value='查看' class='crud_device' "+
        		"onclick=\"paramaterQuery('"+data.data[i].paramaterId+"','"+data.pageIndex+"')\"></td></tr>";
				 $("#parametersTable tbody").append(tr);
        	     }
        		$("#page").empty();
        		var page ="当前第"+data.pageIndex+"页  "
        		var homePrev;
        		var endNext;
        		var currentPage="当前第"+data.pageIndex+"页&nbsp;&nbsp";	
        		var totalPages="共"+data.totalPages+"页&nbsp;&nbsp;"
        		var total ="共"+data.total+"条记录&nbsp;&nbsp;"
        		if(data.pageIndex==0){
        			homePrev="首页  上一页&nbsp;&nbsp;";
        		}else if(data.pageIndex>0){
        			homePrev="<span class=\"blue\" onclick=\"forwardHomePage('"+data.data[0].interfaceId+"','"+data.data[0].deviceId+"')\">首页</span>";
        			homePrev+="&nbsp;&nbsp;<span class=\"blue\" onclick=\"forwardPrePage('"+data.data[0].interfaceId+"','"+data.data[0].deviceId+"','"+data.pageIndex+"')\">上一页</span>";
        		}
        		if(data.pageIndex!=data.totalPages){
        			endNext="&nbsp;&nbsp;<span class=\"blue\" onclick=\"forwardNextPage('"+data.data[0].interfaceId+"','"+data.data[0].deviceId+"','"+data.pageIndex+"')\">下一页</span>";
        			endNext+="&nbsp;&nbsp;<span class=\"blue\" onclick=\"forwardEndPage('"+data.data[0].interfaceId+"','"+data.data[0].deviceId+"','"+data.totalPages+"')\">最后一页</span>";
        		}else if(data.pageIndex==data.totalPages){
        			endNext="&nbsp;&nbsp;下一页  最后一页  ";
        		}
        		$("#page").append(currentPage);
        		$("#page").append(homePrev);
        		$("#page").append(endNext);
        		$("#page").append(totalPages);
        		$("#page").append(total);
        		}
        	},
        	error:function(data){
        		alert("查询有误");
        	}
        	
         })
		 }
		   })
		   
});  
    function forwardEndPage(interfaceId ,deviceId,totalPages){
    	var pageSize=2;
    	var pageIndex = totalPages;
    	common(deviceId,interfaceId,pageSize,pageIndex);
    }
    function common(deviceId,interfaceId,pageSize,pageIndex){
    	 $.ajax({
          	type:"post",
          	url:'<%=path%>/listParamByInterfaceId.do',
          	data:{deviceId:deviceId,interfaceId:interfaceId,pageSize:pageSize,pageIndex:pageIndex},
          	dataType:"json",
          	success:function(data){
          		$("#parametersTable tbody").html("");
          		if(data.data.length>0){
          		for(var i=0;i<data.data.length;i++){
          		var tr = "<tr><td>"+(i+1)+"</td><td>"+data.data[i].paramaterName+"</td>"+
          		"<td>"+data.data[i].type+"</td><td>"+data.data[i].functionName+"</td>"+
          		"<td>"+data.data[i].deviceName+"</td>"+
          		"<td><input type='button' value='删除' class='crud_device' "+
          		"onclick=\"paramaterDel('"+data.data[i].paramaterId+"')\">"+
          		"<input type='button' value='修改' class='crud_device' "+
          		"onclick=\"paramaterEdit('"+data.data[i].paramaterId+"','"+data.pageIndex+"')\">"+
          		"<input type='button' value='查看' class='crud_device' "+
          		"onclick=\"paramaterQuery('"+data.data[i].paramaterId+"','"+data.pageIndex+"')\"></td></tr>";
  				 $("#parametersTable tbody").append(tr);
          	     }
          		$("#page").empty();
          		var page ="当前第"+data.pageIndex+"页  "
          		var homePrev;
          		var endNext;
          		var currentPage="当前第"+data.pageIndex+"页&nbsp;&nbsp";	
          		var totalPages="共"+data.totalPages+"页&nbsp;&nbsp;"
          		var total ="共"+data.total+"条记录&nbsp;&nbsp;"
          		if(data.pageIndex==0){
          			homePrev="首页  上一页&nbsp;&nbsp;";
          		}else if(data.pageIndex>0){
          			homePrev="<span class=\"blue\" onclick=\"forwardHomePage('"+data.data[0].interfaceId+"','"+data.data[0].deviceId+"')\">首页</span>";
          			homePrev+="&nbsp;&nbsp;<span class=\"blue\" onclick=\"forwardPrePage('"+data.data[0].interfaceId+"','"+data.data[0].deviceId+"','"+data.pageIndex+"')\">上一页</span>";
          		}
          		if(data.pageIndex!=data.totalPages){
          			endNext="&nbsp;&nbsp;<span class=\"blue\" onclick=\"forwardNextPage('"+data.data[0].interfaceId+"','"+data.data[0].deviceId+"','"+data.pageIndex+"')\">下一页</span>";
          			endNext+="&nbsp;&nbsp;<span class=\"blue\" onclick=\"forwardEndPage('"+data.data[0].interfaceId+"','"+data.data[0].deviceId+"','"+data.totalPages+"')\">最后一页</span>";
          		}else if(data.pageIndex==data.totalPages){
          			endNext="&nbsp;&nbsp;下一页  最后一页  ";
          		}
          		$("#page").append(currentPage);
          		$("#page").append(homePrev);
          		$("#page").append(endNext);
          		$("#page").append(totalPages);
          		$("#page").append(total);
          		}
          	},
          	error:function(data){
          		alert("查询有误");
          	}    	
           })
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
		   window.location.href="<%=path%>/forwardParametersList.do?pageIndex="+pageIndex+"&pageSize="+pageSize;  
	   }
	   
   }
   function back(id){
  	 window.location.href ="<%=path%>/listDeviceFunction.do?pageIndex="+id+"&pageSize="+10;
  }
   function paramaterQuery(id,pageIndex){
	   window.location.href ="<%=path%>/getParamater.do?pageIndex="+pageIndex+"&paramaterId="+id;
   }
   function paramaterDel(id)
   {
       if(confirm('您确定删除该医院吗？'))
       {
          
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
   function paramaterEdit(id){
	   alert("修改"+id);
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
   .blue{
   color:blue;
   }
   .blue:hover{
   color:#0090DB;
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
     #page{
     text-align:center;
     margin-top:5px;
     }
   </style>
</HTML>
  <head>
  </head>
  <body>
  <div style="margin-top:3px;">
  <form action="<%=path%>/listParamByInterfaceId.do" method="post">
     筛选： 设备名称:<select name="deviceId" id="deviceSelect"
					class="inputTxt" >	
					<option value="" style="color: #b6b6b6" disabled selected>请选择设备名称</option>
				</select>
			&nbsp;&nbsp;接口名称:<select name="interfaceId" id="functionSelect"
					class="inputTxt" >	
					
			</select>
			<input type="hidden" name="pageIndex" value="${pageIndex}"/>
			<input type="hidden" value="10" name="pageSize" />
			&nbsp;&nbsp;<input type="button" id="query" value="查询" class="button button-primary button-rounded button-small"/>
  </form>
  </div>
  <table class="table table-bordered table-striped table-hover" id="parametersTable">
	<caption>参数列表</caption>
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
  <c:forEach var="parameters" items="${data}" varStatus="status">
     <tr>
		<td>${status.index+1}</td>
        <td>${parameters.paramaterName}</td>
        <td>${parameters.type}</td>
        <td>${parameters.functionName}</td>
        <td>${parameters.deviceName}</td>
        <td>
           <input type="button" value="删除" class="crud_device"
           onclick="deviceDel(${device.deviceId})" />
           <input type="button" value="查看" class="crud_device"
           onclick="paramaterQuery(${parameters.paramaterId},${pageIndex})" />
           <input type="button" value="修改" class="crud_device"
           onclick="editDeviceFunction(${function.interfaceId})" />
        </td>
		</tr>
  </c:forEach>  
	</tbody>
</table>
     <div id="page" >
           当前第${pageIndex}页&nbsp;&nbsp;
     <c:if test="${pageIndex==1}">
				<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
	 </c:if>
	 <c:if test="${pageIndex>1}">
			<td><a
				href="<%=path%>/forwardParametersList.do?pageIndex=1&pageSize=5">首页</a></td>
			<td><a
               href="<%=path%>/forwardParametersList.do?pageIndex=${pageIndex-1}&pageSize=5">上一页</a></td>
	</c:if>
	 <c:if test="${pageIndex != totalPages}">
				<td><a
					href="<%=path%>/forwardParametersList.do?pageIndex=${pageIndex+1}&pageSize=5">下一页</a></td>
				<td><a
					href="<%=path%>/forwardParametersList.do?pageIndex=${totalPages}&pageSize=5">最后一页</a></td>
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
      <input type="hidden" id="hiddenPageIndex" value="${pageIndex}"/>
      <input type="hidden" id="backhiddenPageIndex" value="${hiddenPageIndex}"/>
      <input type="hidden" id="hiddenTotalPage" value="${totalPages}"/>
      <a onclick="back()" class="button button-glow button-rounded button-raised button-primary">新增功能</a>
	 
       <!-- 错误提示框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					错误提示
				</h4>
			</div>
			<div class="modal-body">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">确定
				</button>
			</div>
		</div>
	</div>
</div>
 </body>
 </html>