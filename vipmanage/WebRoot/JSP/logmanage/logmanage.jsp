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
<link href="../../CSS/logManage.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
table
{
    border-collapse: collapse;
    margin: 0 auto;
    text-align: center;
}
table td, table th
{
    border: 1px solid #cad9ea;
    color: #666;
    height: 30px;
}
table thead th
{
    background-color: #CCE8EB;

}
table tr:nth-child(odd)
{
    background: #fff;
}
table tr:nth-child(even)
{
    background: #F5FAFA;
}
</style>
<body>
	<s:form id="logManage">
		<div >
			<table width="70%" class="table">
		       <caption><h2>日志管理</h2></caption>
		       <thead>
		       	<tr>
		       		<th width="10%">ID</th>
		       		<th width="15%">用户</th>
					<th width="20%">时间</th>
					<th width="20%">动作</th>
					<th width="5%"></th>
				</tr>
		       </thead>
		       <s:iterator id="log" value="logs">
					<tr>
						<td><s:property value="#log.getId()" /></td>
						<td><s:property value="#log.getUserName()" /></td>
						<td><s:property value="#log.getTime()" /></td>
						<td><s:property value="#log.getAction()" /></td>
						<td><a href="logDeleted.action?id=<s:property value="#log.getId()" />" >删除</a></td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="5" align="left"><a href="./JSP/home/main.jsp">返回</a></td>
				</tr>
	    	</table>
		</div>
	</s:form>
</body>
</html>