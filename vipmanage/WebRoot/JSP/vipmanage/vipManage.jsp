<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>vipManage</title>
<link href="../../CSS/main.css" rel="stylesheet" type="text/css" />
<link href="../../CSS/head.css" rel="stylesheet" type="text/css" />
<link href="../../CSS/main_left.css" rel="stylesheet" type="text/css" />
<link href="../../CSS/CvipManage.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="main_page">
		<div id="head">
			<jsp:include page="../home/head.jsp" />
		</div>
		<div id="content">
			<div id="main_left">
				<jsp:include page="../home/main_left.jsp" />
			</div>
			<div id="main_right">
				<s:form action="../../vipAdd.action" id="vipManage">
					<div class="Content-Main">
					    <div class="Content-Main1">
					        <h1>VIP信息录入</h1>
					    </div>
				        <label>
				            <span>vipID:</span>
				            <input type="text" name="vipID" >
				        </label>
				        <label>
				            <span>VIP姓名:</span>
				            <input type="text" name="username" >
				        </label>
				        <label>
				            <span>密码:</span>
				            <input type="text" name="password" >
				        </label>
				        <label>
				            <span>性别:</span>
				            <input type="text" name="gender" value="男/女">
				        </label>
				        <label>
				            <span>电话:</span>
				            <input type="text" name="telphone">
				        </label>
				        <label>
				            <span>邮箱:</span>
				            <input type="text" name="email">
				        </label>
				        <label>
				            <span>生日:</span>
				            <input type="text" name="birthday" value="yyyy-MM-dd">
				        </label>
				        <label>
				            <input type="submit" class="button" value="确定" id="submit">
				        </label>
					</div>
				</s:form>
			</div>
		</div>
	</div>
	
 </body>
</html>