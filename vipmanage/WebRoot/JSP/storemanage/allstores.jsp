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
		       <caption><h2>店面信息一览表</h2></caption>
		       <thead>
		       	<tr>
		       		<th width="10%">地址</th>
		       		<th width="10%">BOSS</th>
					<th width="10%">电话</th>
					<th width="10%">备注</th>
					<th width="5%"></th>
				</tr>
		       </thead>
		       <s:iterator id="store" value="stores">
					<tr>
						<td><s:property value="#store.getAddress()" /></td>
						<td><s:property value="#store.getBoss()" /></td>
						<td><s:property value="#store.getBossTel()" /></td>
						<td><s:property value="#store.getRemark()" /></td>
						<td><a href="storeDeleted.action?id=<s:property value="#store.getId()" />" >删除</a></td>
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