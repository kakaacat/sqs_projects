<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<title>商场VIP管理系统</title>
<link href="${pageScope.basePath}/CSS/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<s:form action="login.action" >
		<div class="box">
	        <h2>管理员登录</h2>
	        <form>
	            <div class="inputBox">
	                <input type="text" name="username" required="required">
	                <label>用户名</label>
	            </div>
	            <div class="inputBox">
	                <input type="password" name="password" required="required">
	                <label>密码</label>
	            </div>
	            <input type="submit" value="登录">
	        </form>
	    </div>
	</s:form>
</body>
</html>