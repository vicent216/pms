<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人事管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center;">
    <h2>${user.username}你好！[<a href="${pageContext.request.contextPath}/servlet/CenterController?operation=logout">注销</a>]</h2>
    <h1>欢迎使用人事管理系统</h1>
    <hr />
    <table  border="0" width="98%">
    	<tr><td align="center"><h3>请选择模块</h3></td></tr>
    	<tr><td align="center"><h4><a href="${pageContext.request.contextPath}/servlet/StudentController">学生信息管理</a></h4></td></tr>
    	<tr><td align="center"><h4><a href="${pageContext.request.contextPath}/servlet/PostgraduateController">研究生信息管理</a></h4></td></tr>
    	<%-- <tr><td align="center"><h4><a href="${pageContext.request.contextPath}/servlet/AssistantController">助教信息管理</a></h4></td></tr> --%>
    	<tr><td align="center"><h4><a href="${pageContext.request.contextPath}/servlet/TeacherController">教师信息管理</a></h4></td></tr>
    	
    </table>
  </body>
</html>
