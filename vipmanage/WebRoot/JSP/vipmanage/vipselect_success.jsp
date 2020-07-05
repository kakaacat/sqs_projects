<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>FindVip_success</title>
<link href="../../CSS/main.css" rel="stylesheet" type="text/css" />
<link href="../../CSS/head.css" rel="stylesheet" type="text/css" />
<link href="../../CSS/main_left.css" rel="stylesheet" type="text/css" />
<link href="../../CSS/vipselect_success.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.Content-Main{
    max-width: 500px;
    margin: auto;
    margin-top: 50px;
    margin-left: 480px;
    padding: 20px 30px 20px 30px;
    font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
    text-shadow: 1px 1px 1px #FFF;
    border: 1px solid #DDD;
    border-radius: 5px;
    color: #888;
    background: #FFF;
}
.Content-Main h1{
    display: block;
    padding: 0px 0px 10px 40px;
    margin: -10px -30px 30px -30px;
    font: 25px "Helvetica Neue", Helvetica, Arial, sans-serif;
    border-bottom: 1px solid #DADADA;
    color: #888;
}
.Content-Main h1>span{
    display: block;
    font-size: 11px;
}
.Content-Main a{
	text-decoration:none
}
.Content-Main label{
    display: block;
    margin: 0px 0px 5px;
}
.Content-Main label>span{
    float: left;
    width: 20%;
    padding-right: 10px;
    margin-top: 10px;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-weight: bold;
    text-align: right;
    color: #333;
}
.Content-Main input[type="text"]{
    width: 70%;
    height: 20px;
    padding: 5px 0px 5px 5px;
    margin-bottom: 16px;
    margin-right: 6px;
    margin-top: 2px;
    line-height: 15px;
    border-radius: 4px;
    border: 1px solid #CCC;
    color: #888;
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
}
</style>
</head>
<body>
	<s:form>
		<div class="Content-Main" id="main_right">
			<s:set name="vip" value="#request.user" />
			    <div class="Content-Main1" id="vipselect_success">
			        <h1><s:property value="#vip.getName()" />的详情信息如下：</h1>
			   	</div>
		        <label>
		            <span>VIPID：</span>
		            <input type="text" readonly="readonly" value="<s:property value="#vip.getVipId()" />"/>
		        </label><br>
		         <label>
		            <span>密码：</span>
		            <input type="text" readonly="readonly" value="<s:property value="#vip.getPassword()" />"/>
		        </label>
		         <label>
		            <span>性别：</span>
		            <input type="text" readonly="readonly" value="<s:property value="#vip.getGender()" />"/>
		        </label>
		        <label>
		            <span>电话：</span>
		            <input type="text" readonly="readonly" value="<s:property value="#vip.getTelphone()" />"/>
		        </label>
		        <label>
		            <span>生日：</span>
		            <input type="text" readonly="readonly" value="<s:property value="#vip.getBirthday()" />"/>
		        </label>
		        <label>
		            <span>等级：</span>
		            <input type="text" readonly="readonly" value="<s:property value="#vip.getLevel()" />"/>
		        </label>
		        <label>
		            <span>消费次数：</span>
		            <input type="text" readonly="readonly" value="<s:property value="#vip.getExp()" />"/>
		        </label>
		        <label>
		            <span>积分：</span>
		            <input type="text" readonly="readonly" value="<s:property value="#vip.getPoint()" />"/>
		        </label>
		        <label>
		            <a style="margin-left: 50px" href="./JSP/vipmanage/findVip.jsp">返回</a>&nbsp;
		            <a style="margin-left: 80px" href="vipDeleted.action?vipID=<s:property value="#vip.getVipId()" />">删除</a>
		        </label>
			</div>
	</s:form>
</body>
</html>