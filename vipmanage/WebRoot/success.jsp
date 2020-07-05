<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = basePath+"JSP/home/main.jsp";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  	<meta http-equiv=refresh content=3;url=<%=url %>>
    <title>SUCCESS</title>
<style type="text/css">

   *{
		margin: 0px;
		padding: 0px;
		font-family: "宋体";
		text-decoration: none;
	}
	.success{
		position:absolute;
		top:50%;
		left:50%;
		transform: translate(-50%,-50%);
	}
	#head_page{
		height: 60px;
		background-color: #7bed9f;
	}
	
	#left{
		width:50%;
		float: left;
		position: relative;
		top:18px;
		left:30px;
		color: #dff9fb;
	}
	#right{
		width:50%;
		float: right;
		
	}
	#right ul{
		margin:0px;
		margin-top: 30px
		padding: 0px;
		float: right;
		position: relative;
		right:40px;
		
	}
	#right ul li{
		list-style:none;  
		float: left;
		margin:10px 18px;
		position: relative;
		top:28px;
	}
	#head_page a{
		color: #dff9fb;
	}
	#head_page a:HOVER{
		color: #e9521f;
	}
</style>
<script type="text/javascript">  
	function countDown(secs){
	        jump.innerText=secs;
	        if(--secs>0)
	            setTimeout("countDown("+secs+" )",1000);
	    }
	    countDown(3);
</script>
 </head>
 <body>
	<div id="head">
		<jsp:include page="${pageScope.basePath}/JSP/home/head.jsp" />
	</div>
  <div class="success">
    <div style="color :green" ><h1>操作成功!<br></h1></div>
    <b style="color:blue;font-size:12px"><span id=jump>3</span> 秒钟后页面将自动返回</b><br>
    <a href="./JSP/home/main.jsp">确定</a>
  </div>
  </body>
</html>
