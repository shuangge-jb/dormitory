<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="error.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
   function pageForward(){
	   var pageIndex = document.getElementById('pageIndex').value;
	   window.location.href="<%=path%>/adminHospitalAction.action?pageIndex="+pageIndex;
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
   function addHospital(){
	   window.location.href ="<%=path%>/admin/hospital/addHospital.jsp";
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
   </style>
</HTML>
  <head>
  </head>
  <body>
  <table 
  style="font-size:15px;color:#333333;text-align:center;margin-left:5px;margin-top:10px;borderColor:#D7D7D7;"
   	cellspacing=0 border="1" width="98%;" cellPadding=1>
							<tr bgcolor=#EBEBEB height=30>
							<td>序号</td><td>医院名称</td><td>医院级别</td><td>医院热线</td><td>医院属性</td><td>操作</td>
							</tr>
       <c:foreach var="device" items="${list}" varStatus="status">
        <tr height=30>
        <td>${status.index}</td>
        <td>${ device}</td>
        <td><s:property	value="#hospital.rank"/></td>
         <td><s:property value="#hospital.telephone" /></td>
         <td><s:property value="#hospital.property"/></td>    
           <td><input type="button" value="删除" style="border-radius:2px;font-size:13px;background-color:#D7D7D7;"
           onclick="hospitalDel(<s:property value="#hospital.hospitalId" />)" />
           <input type="button" value="查看" style="border-radius:2px;font-size:13px;background-color:#D7D7D7;"
           onclick="hospitalCheck(<s:property value="#hospital.hospitalId" />)" />
           <input type="button" value="修改" style="border-radius:2px;font-size:13px;background-color:#D7D7D7;"
           onclick="editHospital(<s:property value="#hospital.hospitalId" />)" />
           </td>
         </tr>
     </c:foreach>
      </table>
     <div id="page" style="text-align:center;margin-top:5px;">
           当前第<s:property value="pageIndex"/>页&nbsp;&nbsp;
     <s:if test="%{pageIndex== 1}">
				<td>首页&nbsp;&nbsp;上一页&nbsp;&nbsp;</td>
	 </s:if>
	 <s:else>
			<td><a
				href="<%=path%>/adminHospitalAction.action?pageIndex=1">首页</a></td>
			<td><a
               href="<%=path%>/adminHospitalAction.action?pageIndex=<s:property value="%{pageIndex-1}"/>">上一页</a></td>
	 </s:else>
	 <s:if test="%{pageIndex != totalPages}">
				<td><a
					href="<%=path%>/adminHospitalAction.action?pageIndex=<s:property value="%{pageIndex+1}"/>">下一页</a></td>
				<td><a
					href="<%=path%>/adminHospitalAction.action?pageIndex=<s:property value="totalPages"/>">最后一页</a></td>
			</s:if>
	 <s:else>
			<td>下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;</td>
	 </s:else>
           共<s:property value="totalPages"/>页&nbsp;&nbsp;
           共<s:property value="count"/>条记录&nbsp;&nbsp;     
      <input type="text" name="pageIndex" id="pageIndex" style="width:25px;"/>&nbsp;
      <input type="button" value="go" style="border-radius:2px;font-size:13px;background-color:#D7D7D7;" onclick="pageForward()">
      </div>
      <input type="button" value="新增医院" onclick="addHospital()"
      style="margin-left:5px;margin-top:10px;font-weight:bolder;font-size:15px;border:3px solid #0090DB;height:30px;width:100;position:absolute;background:#0090DB;color:#FFEDF1;"  onMouseOver="this.style.backgroundColor='#EF972B';"
				onMouseOut="this.style.backgroundColor ='#0090DB';"/>
      <input type="hidden" id="hiddenPageIndex" value="<s:property value="pageIndex"/>"/>
 </body>
 </html>