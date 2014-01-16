<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改教师</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/TeacherController?operation=update" method="post">
    	<table border="1" width="58%">
    		<tr>
    			<td>编号:</td>
    			<td>
    				<input type="text" name="num" value="${formBean.num}"/>${formBean.errors.num }
    			</td>
    		</tr>
    		<tr>
    			<td>姓名:</td>
    			<td>
    				<input type="text" name="name" value="${formBean.name}"/>${formBean.errors.name }
    			</td>
    		</tr>
    		<tr>
    			<td>性别:</td>
    			<td>
    				<input type="text" name="gender" value="${formBean.gender }"/>${formBean.errors.gender }
    			</td>
    		</tr>
    		<tr>
    			<td>出生日期:</td>
    			<td>
    				<input type="text" name="birth" value="${formBean.birth }"/>${formBean.errors.birth }
    			</td>
    		</tr>
    		<tr>
    			<td>身份证号:</td>
    			<td>
    				<input type="text" name="idCard" value="${formBean.idCard }"/>${formBean.errors.idCard }
    			</td>
    		</tr>
    		<tr>
    			<td>职务:</td>
    			<td>
    				<input type="text" name="job" value="${formBean.job }"/>${formBean.errors.job }
    			</td>
    		</tr>
    		<tr>
    			<td>部门:</td>
    			<td>
    				<input type="text" name="depart" value="${formBean.depart }"/>${formBean.errors.depart }
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="保存"/>
    			</td>
    		</tr>
    	</table>
     </form>
  </body>
</html>