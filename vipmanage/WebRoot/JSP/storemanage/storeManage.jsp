<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>storeManage</title>
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
				<s:form action="../../storeAdd.action" id="vipManage">
					<div class="Content-Main">
					    <div class="Content-Main1">
					        <h1>店面信息录入</h1>
					    </div>
					        <label>
					            <span>地址:</span>
					            <input type="text" name="address" >
					        </label>
					        <label>
					            <span>BOSS名字:</span>
					            <input type="text" name="boss" >
					        </label>
					        <label>
					            <span>电话:</span>
					           <input type="text" name="bossTel" >
					        </label>
					        <label>
					            <span>备注:</span>
					           <input type="text" name="remark" >
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