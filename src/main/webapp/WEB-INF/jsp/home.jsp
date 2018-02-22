<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>翰林教育</title>
</head>
<body>
<div>登录成功，用户名：<c:out value="${sessionScope.userInfo.username }"></c:out></div>
<div>登录成功，昵称：<c:out value="${sessionScope.userInfo.nickname }"></c:out></div>
</body>
</html>