<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<html>
  <head>
    <meta charset="utf-8">
    <title>Hello, World! - A-Frame</title>
    <script src="https://aframe.io/releases/0.5.0/aframe.min.js"></script> 
    <script src="<%=path%>/js/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" media="all"/>
	<link rel="stylesheet" href="<%=path%>/css/mydevice/mydevicehead.css" media="all"/>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<style type="text/css">
	 #virtualDormitory{
       color:#fff;text-decoration:none;
       background-color:#0074A6;
       height:50px;line-height:51px;
       line-height:54px\9;line-height:52px\0;border-bottom:0;
    }
	</style>
    <script>
     AFRAME.registerComponent('hello-world',{
    	  init:function() {
    	    console .log('Hello，World！');
    	  }
    	});
    </script>
  </head>
  <body>
   <jsp:include page="title.jsp"></jsp:include>
  <a-scene>
  <a-assets>
  <a-asset-item id="tree" src="<%=path%>/images/model/computer.dae"></a-asset-item>
<!--     <a-asset-item  id ="tree-obj"  src ="iphone5.obj"> </a-asset-item >
    <a-asset-item  id ="tree-mtl" src ="iphone5.mtl"> </a-asset-item > -->
    <img id="skyTexture" src="<%=path%>/images/test.jpg">
    
  </a-assets>
   <!--   <a-entity  geometry ="primitive:box" position="0 2 -5"  material ="envMap:#test1233">
         <a-animation attribute="rotation" fill ="forward"
       begin="click" dur="2000" to="0 360 0"></a-animation>
     </a-entity> -->
      <!-- <a-box position="0 2 -5" rotation="90 0 0" scale="1 1 1" src="#boxTexture"> -->
     <!-- <a-box position="0 2.2 -5" rotation="45 45 0" src="#boxTexture" width="4" height="2.4" depth="0.05" color="#B76705">
       <a-animation attribute="rotation" fill ="forward"
       begin="click" dur="2000" to="0 360 0"></a-animation>
     </a-box> -->
    <!--  <a-entity  geometry ="primitive:box"  material ="envMap:#sky;" > </a-entity > -->
    <!--   <a-animation attribute="position" direction="alternate" dur="2000" repeat="indefinite"
      to="0 2.2 -5">
      </a-animation>
     <a-animation attribute="rotation" begin="click" dur="2000" to="360 360 0"></a-animation> -->
    <!-- <a-animation attribute="scale" begin="mouseenter" dur="3000" to="2.3 2.3 2.3"></a-animation>
    <a-animation attribute="scale" begin="mouseleave" dur="3000" to="2 2 2"></a-animation> -->
 <!--  </a-box> -->
 <!-- <a-collada-model src="computer.dae"></a-collada-model> -->
  <!--   <a-image position="-2 0.22 -2" src="images/font.png" rotation="0 0 0"  id="ups" scale="0.5 0.5 0.5"></a-image> -->
<!--  <a-collada-model src="iphone5.dae"></a-collada-model> -->
 <a-entity  hello-world > </a-entity >
<!--    <a-text value="SCUT Card" color="#BBB"
          position="-0.9 1 -3" scale="1 1 1"></a-text>
           <a-text value="up" id="up" color="#BBB"
          position="-0.9 0.2 -3" scale="1 1 1"></a-text> -->
  <a-sky  src="#skyTexture"  rotation="0 -90 0"></a-sky>
  <a-light type="ambient" color="#445451"></a-light>
  <a-light type="point" intensity="2" position="2 4 4"></a-light>
  <a-camera>
    <a-cursor color="#FAFAFA">
  </a-camera>
   <a-collada-model src="<%=path%>/images/model/mouse.dae" id="mouse" position="3 0 -5" scale="10 10 10" rotation="0 180 0" 
    >
    <a-animation attribute="rotation" fill ="forward"
       begin="click" dur="300" to="225 405 0"></a-animation>
   </a-collada-model>
    <a-collada-model src="<%=path%>/images/model/guita.dae" id="guita" position="0 0 -5" scale="20 10 10" rotation="45 180 0" draggable="true">
 
   </a-collada-model>
</a-scene>
  <span id="before">前</span><span id="back">后</span><span id="up">上</span><span id="down">下</span><span id="left">左</span><span id="right">右</span>
 <span id="big">大</span><span id="small">小</span>
  rotationX:<input type="text" id="rotationX"/>rotationY:<input type="text" id="rotationY"/>rotationZ:<input type="text" id="rotationZ"/>
 <input type="button" id="sure" value="确定"/>
  </body>
  <script>
 /*    var boxEl = document.querySelector('a-box');
    boxEl.addEventListener('click',function() {
    	//window.location.href="http://localhost:8080/VirtualDormitory/test.html";
    boxEl.setAttribute('scale',{ x:4,y:4,z:4 });
    }); */
    $(document).ready(function(){
    	  $('#before').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  boxEl.setAttribute('position',{x:boxEl.getAttribute('position').x,y:boxEl.getAttribute('position').y,z:boxEl.getAttribute('position').z+1})
    		  //alert(boxEl.getAttribute('position').z);
    	  });
    	  $('#back').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  boxEl.setAttribute('position',{x:boxEl.getAttribute('position').x,y:boxEl.getAttribute('position').y,z:boxEl.getAttribute('position').z-1})
    		 // alert(boxEl.getAttribute('position').z);
    	  });
    	  $('#up').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  boxEl.setAttribute('position',{x:boxEl.getAttribute('position').x,y:boxEl.getAttribute('position').y+1,z:boxEl.getAttribute('position').z})
    		  //alert(boxEl.getAttribute('position').y);
    	  });
    	  $('#down').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  boxEl.setAttribute('position',{x:boxEl.getAttribute('position').x,y:boxEl.getAttribute('position').y-1,z:boxEl.getAttribute('position').z})
    		  //alert(boxEl.getAttribute('position').y);
    	  });
    	  $('#left').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  boxEl.setAttribute('position',{x:boxEl.getAttribute('position').x-1,y:boxEl.getAttribute('position').y,z:boxEl.getAttribute('position').z})
    		 // alert(boxEl.getAttribute('position').x);
    	  });
    	  $('#right').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  boxEl.setAttribute('position',{x:boxEl.getAttribute('position').x+1,y:boxEl.getAttribute('position').y,z:boxEl.getAttribute('position').z})
    		 // alert(boxEl.getAttribute('position').x);
    	  });
    	  $('#big').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  boxEl.setAttribute('scale',{x:boxEl.getAttribute('scale').x+1,y:boxEl.getAttribute('scale').y+1,z:boxEl.getAttribute('scale').z+1})
    		 // alert(boxEl.getAttribute('position').x);
    	  });
    	  $('#small').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  boxEl.setAttribute('scale',{x:boxEl.getAttribute('scale').x-1,y:boxEl.getAttribute('scale').y-1,z:boxEl.getAttribute('scale').z-1})
    		 // alert(boxEl.getAttribute('position').x);
    	  });
    	  $('#sure').click(function(){
    		  var boxEl = document.querySelector('#mouse');
    		  alert(Number($('#rotationX').val()))
    		  alert(boxEl.getAttribute('rotation').y)
    		  boxEl.setAttribute('rotation',{x:Number($('#rotationX').val()),y:Number($('#rotationY').val()),z:Number($('#rotationZ').val())})
    		 // alert(boxEl.getAttribute('position').x);
    	  });
    	});
   /*  alert(up) */
    /* var boxEl = document.querySelector('#guita'); */
    var boxEl = document.querySelector('#guita');
    up.addEventListener('click',function() {
    	/* //window.location.href="http://localhost:8080/VirtualDormitory/test.html"; */
    	var posX=boxEl.getAttribute('position').x;
    	
    	
    //boxEl.setAttribute('position',{ x:10,y:4,z:4 });
    });
    
  </script >
</html>
