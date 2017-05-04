<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script src="<%=path%>/js/jquery-2.1.4.min.js"></script> 
     <script src="<%=path%>/js/bootstrap.min.js"></script> 
   <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
   <link rel="stylesheet" href="<%=path%>/css/buttons.css">
	<script type="text/javascript">
    function back(pageIndex,deviceId,backPageId){
      var pageSize = 10;
      window.location.href ="<%=path%>/listInterfaceByDeviceId.do?deviceId="+deviceId+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&hiddenPageIndex="+backPageId;
    }
   </script>
 
  </head>
  <body>
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">${device.name}的功能明细</h3>
		</div>
		<div class="panel-body">
		<h5>功能描述:</h5>
		<p> ${data.description}</p>
		</div>
		<ul class="list-group">
		<li class="list-group-item"><h5>功能名称:</h5>${data.interfaceName}</li>
		<li class="list-group-item"><h5>功能Url:</h5>${data.interfaceUrl}</li>
		<li class="list-group-item"><h5>接口来源:</h5>${data.source}</li>
		<li class="list-group-item"><h5>接口方法类型:</h5>${data.method}</li>
		
	</ul>
	 
	</div>
	<a onclick="back(${pageIndex},${device.deviceId},${backPageIndex})" class="button button-action button-rounded button-small">返回</a>
	 
  </body>
</html>
