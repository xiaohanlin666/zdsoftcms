<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User List</title>
</head>
<body>

<table width="80%" align="center">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>密码</td>
			<td>日期</td>
		</tr>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td>${bean.userid }</td>
			<td>${bean.username }</td>
			<td>${bean.passwd }</td>
			<td><fmt:formatDate value="${bean.createtime }" pattern="yyyy-MM-dd HH:mm:ss SSS"/></td>
		</tr>
		</c:forEach>
	</table>


</body>
</html>