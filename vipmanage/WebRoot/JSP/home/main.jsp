<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量
	String basePath = request.getScheme()+"://"+request.getServerName()
			+":"+request.getServerPort()+path+"/";
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。
	pageContext.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>main</title>
<link href="${pageScope.basePath}/CSS/main.css" rel="stylesheet" type="text/css" />
<link href="${pageScope.basePath}/CSS/head.css" rel="stylesheet" type="text/css" />
<link href="${pageScope.basePath}/CSS/main_left.css" rel="stylesheet" type="text/css" />
<link href="${pageScope.basePath}/CSS/help.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="main_page">
		<div id="head">
			<jsp:include page="head.jsp" />
		</div>
		<div id="content">
			<div id="main_left">
				<jsp:include page="main_left.jsp" />
			</div>
			<div id="main_right">
				<jsp:include page="help.jsp" />
			</div>
		</div>
	</div>
	
</body>
</html>