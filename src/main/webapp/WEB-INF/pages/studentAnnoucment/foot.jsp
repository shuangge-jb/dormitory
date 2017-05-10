<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<style type="text/css">
	body{
	 margin:0px auto;
	}
	.foot{
	background: #F6F6F6;
	text-align:center;
	line-height:30px;
	padding-top:20px;
	}
	.footer-content{
	 width:100%;
	}
    .top_h5{
      font-size:16px;
      margin-left:3px;
      color:#006DB3;
     }

	</style>
	
  </head> 
  <body >
  <div class="foot" >
  <div class="footer-content">
          <img src="<%=path%>/images/scut.jpg" width="32px" height="30spx" style="vertical-align:middle;"
           >
        <span class="top_h5" >
                 华南理工大学虚拟宿舍
        </span>
        <div>     
   </div> 
		</div>
	   <ul>
     <li style="list-style:none;display:block;text-align:center;color:#929699;line-height:25px;font-size:12px;">               
                   地址：华南理工大学 C10 &nbsp;  技术支持：华工软件学院 &nbsp; 华南理工大学软件学院版权所有
     </li>
     <li style="list-style:none;text-align:center;color:#929699;line-height:25px;font-size:12px;" > 
                 粤ICP备12059770号   &nbsp; 粤公网安备 44010402000394号
     </li> 
   </ul>
   </div>
  </body>
</html>