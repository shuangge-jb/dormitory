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
<script type="text/javascript">
    function back(id){
       
	   window.location.href ="<%=path%>/master/listPostcardByMasterId.do?pageIndex=1&pageSize=5&masterId="+id;

    }  
    function verifyPostCard(){
    	if(document.form1.name.value==""){
    		$('#myModal').modal('show');
    		$(".modal-body").text("领取人姓名不能为空");
    		return false;
    	}
    
    	else if(document.form1.createTime.value==""){
    		$('#myModal').modal('show');
    		$(".modal-body").text("公告创建时间不能为空");
    		return false;
    	}
    	
    	return true;
    }
  
   </script>
   <style type="text/css">
   #shuoming {
	color: blue;
	margin-left: 40px;
	margin-top: 30px;
	border-bottom: 1px solid #D7D7D7;
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
  </head>
  
  <body>
     <div style="margin-top:10px;margin-left:5px;">
              <div id="shuoming">
				<b>新增明信片信息</b><font style="color:red">（*号为必填）</font>
				&nbsp;<font style="color:red">${status}</font>
			</div>
            <form action="<%=path %>/master/savePostcard.do?buildingId=${buildingId}" name="form1" method="post" 
             onsubmit="return verifyPostCard();">
            <div style="margin-left:80px;margin-top:30px;">
				<font color=red>*</font> 接收人：<input type="text"  id="name"
					name="name" class="inputTxt">
			</div>
			 <div style="margin-left:80px;margin-top:30px;">
				<font color=red>*</font> 明信片到达时间：<input type="date"  id="createTime"
					name="createTime" class="inputTxt" >
			</div>
			<div>
			<input type="hidden" name="publisherId" value="${masterId}"/>
			</div>
			<input type="hidden" value="0" name="state">
			     <input type="submit" value="新增" style="margin-top:30px;margin-left:130px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:50;position:absolute;background:#0090DB;color:#FFEDF1;" 
			     onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';"/>&nbsp;
			     <input type="button" value="返回" onclick="back(${masterId})"
         style="margin-top:30px;margin-left:210px;background:#F7B52C;width:50;height:30;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:50;position:absolute;background:#0090DB;color:#FFEDF1;" onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';" /> 
           </form>
      </div>
   <!-- 模态框（Modal） -->
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
