<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ERROR</title>
	<style type="text/css">
	* {
    padding: 0;
    margin: 0;
}

html,body {
    height: 100%;
}

body {
    /* 修改背景色调 */
    background: rgba(223, 223, 255, 0.39);
    display: flex;
    justify-content: center; /*body内容水平居中显示*/
    align-items: center;     /*body内容垂直居中显示*/
}

.main-container {
    width: 80%;
    max-width: 1000px;
    max-height: 500px;
    min-width: 600px;
    background-color: white;
    font-size: 0;
    border-radius: 20px;
    box-shadow: 0 0 50px 0 rgba(146, 146, 146, 0.63);
}
.main-container .container-item {
    display: inline-block;
    vertical-align: middle;
    width: 50%;
}
.main-container .text-container .code {
    font-size: clamp(150px,20vw,200px);
    font-family: 'Arial Narrow';
    color: rgb(86, 86, 253);
    font-weight: bolder;
    text-align: center;
}

.main-container .text-container .msg {
    font-size: 18px;
    text-align: center;
    font-weight: bold;
    margin-bottom: 20px;
}

.main-container .text-container .action {
    color: #0f0f0f;
    font-size: 15px;
    font-weight: 600;
    text-align: center;
    text-decoration-line: none;
}
.main-container .text-container a:hover{
    color: #5bc0de;
}
	</style>
  </head>
  <body>
    <div class="main-container">
        <div class="text-container container-item">
            <div class="code">ERROR</div>
            <div class="msg">你查看的页面貌似丢失了呢...</div>
            <a class="action" href="./JSP/home/main.jsp"><div>返回首页,查看更多内容.</div></a>
        </div>
    </div>
    <s:debug></s:debug>
  </body>
</html>
