<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>vipSelect</title>
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
			<s:form action="../../inputInfo.action" id="vipManage">
				<div class="Content-Main">
					    <div class="Content-Main1">
					        <h1>VIP购物登记</h1>
					    </div>
					        <label>
					            <span>vipID:</span>
					            <input type="text" name="vipID" >
					        </label>
					        <label>
					            <span>等级:</span>
					            <input type="text" name="level" >
					        </label>
					        <label>
					            <span>消费次数:</span>
					           <input type="text" name="exp" >
					        </label>
					        <label>
					            <span>积分:</span>
					           <input type="text" name="point" >
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