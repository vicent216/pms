<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>教师信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center;">
   <h1>教师信息管理系统</h1><hr /><br />
   <table width="88%">
   <tr>
   <td align="left">[<a href="${pageContext.request.contextPath}">首页</a>]</td>
   <td align="right">
   <form action="${pageContext.request.contextPath}/servlet/TeacherController?operation=find" method="post">
   [<a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=add&first=1">添加</a>]
	   <select name="attr">
	   <option value="num">编号</option>
	   <option value="name">姓名</option>
	   <option value="gender">性别</option>
	   <option value="birth">出生日期</option>
	   <option value="job">职务</option>
	   <option value="depart">部门</option>
	   </select>
	   <input type="text" name="str" value=""/>
	   <input type="submit" value="查找"/>
   </form></td>
   </tr>
   </table>
   <table border="1" width="88%">
   	  <tr>
   	  	<th><a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=sort&attr=num">编号</a></th>
   	  	<th><a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=sort&attr=name">姓名</a></th>
   	  	<th><a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=sort&attr=gender">性别</a></th>
   	  	<th><a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=sort&attr=birth">出生日期</a></th>
   	  	<th><a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=sort&attr=idCard">身份证号</a></th>
   	  	<th><a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=sort&attr=job">职务</a></th>
   	  	<th><a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=sort&attr=depart">部门</a></th>
   	  	<th>操作</th>
   	  </tr>
   	  <c:forEach items="${teachers}" var="stu" varStatus="vs">
    	<tr bgcolor="${vs.index%2==0?'#CCCCCC':'#6081A3'}">
	 		<td align="center">${stu.num}</td>
	    	<td align="center">${stu.name}</td>
	    	<td align="center">${stu.gender}</td>
	    	<td align="center">${stu.birth}</td>
	    	<td align="center">${stu.idCard}</td>
	    	<td align="center">${stu.job}</td>
	    	<td align="center">${stu.depart}</td>
	    	<td align="center">
	  		[<a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=update&num=${stu.num}&first=1">修改</a>]
	  		[<a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=delete&num=${stu.num}">删除</a>]
	    	</td>
	   	</tr>
    </c:forEach>
   
   </table>
   <table width="88%"><tr><td align="right">[<a href="${pageContext.request.contextPath}/servlet/TeacherController?operation=save">保存</a>]</td></tr></table>
  </body>
</html>
