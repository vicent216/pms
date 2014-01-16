<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>管理员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br /><br /><br />
    <form action="${pageContext.request.contextPath}/servlet/CenterController?operation=login" method="post">   
    	${formBean.errors.message}<br/>
    	用户名:<input type="text" name="username" value="${formBean.username}"/>${formBean.errors.username}<br/>
    	密码：<input type="password" name="password">${formBean.errors.password}<br />
    	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="登陆" />
    </form>
  </body>
</html>
