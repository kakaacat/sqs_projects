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
			<table width="74%" class="table">
		       <caption><h2>VIP信息一览表</h2></caption>
		       <thead>
		       	<tr>
		       		<th width="8%">VIPID</th>
		       		<th width="10%">姓名</th>
					<th width="6%">性别</th>
					<th width="10%">电话</th>
					<th width="10%">E-mail</th>
					<th width="5%">等级</th>
					<th width="8%">消费次数</th>
					<th width="10%">积分</th>
					<th width="20%">账号过期时间</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
		       </thead>
		       <s:iterator id="vip" value="users">
					<tr>
						<td><s:property value="#vip.getVipId()" /></td>
						<td><s:property value="#vip.getName()" /></td>
						<td><s:property value="#vip.getGender()" /></td>
						<td><s:property value="#vip.getTelphone()" /></td>
						<td><s:property value="#vip.getEmail()" /></td>
						<td><s:property value="#vip.getLevel()" /></td>
						<td><s:property value="#vip.getExp()" /></td>
						<td><s:property value="#vip.getPoint()" /></td>
						<td><s:property value="#vip.getEndTime()" /></td>
						<td><a href="vipDeleted.action?vipID=<s:property value="#vip.getVipId()" />" >删除</a></td>
						<td><a href="margeVip.action?id=<s:property value="#vip.getVipId()" />" >修改</a></td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="11" align="left"><a href="./JSP/home/main.jsp">返回</a></td>
				</tr>
	    	</table>
		</div>
	</s:form>
</body>
</html>