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
<div id="firstpaneDiv" class="menu_list">
		<h3 class="menu_head">VIP管理</h3>
		<div style="display:block" class="menu_nva">
			<a href="${pageScope.basePath}JSP/vipmanage/vipManage.jsp">VIP信息录入</a>
			<a href="${pageScope.basePath}JSP/vipmanage/buymanage.jsp">VIP购物登记</a>
			<a href="${pageScope.basePath}JSP/vipmanage/findVip.jsp">VIP信息查询</a>
			<a href="${pageScope.basePath}allVip.action">VIP信息一览</a>
		</div>
		<h3 class="menu_head">店面管理</h3>
		<div style="display:block" class="menu_nva">
		<a href="${pageScope.basePath}JSP/storemanage/storeManage.jsp">店面信息录入</a>
		<a href="${pageScope.basePath}JSP/storemanage/findStore.jsp">店面信息查询</a>
		<a href="${pageScope.basePath}allStores.action">店面信息一览</a>
		</div>
		<h3 class="menu_head">日志管理</h3>
		<div style="display:block" class="menu_nva">
		<a href="${pageScope.basePath}logManage.action">日志管理</a>
		</div>
</div>
