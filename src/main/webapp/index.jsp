<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>正大cms系统</title>
</head>
<body>
<%  
    Integer count = (Integer) application.getAttribute("counter"); 
    Long history=(Long)application.getAttribute("historytime");
    System.out.println("history==="+history);
    if(count == null)  
    {  
        count=0;  
    }  
    if(history==null)
    {
    	history=System.currentTimeMillis();
    	application.setAttribute("historytime", history);  
    }
    //计数器加1  
    count++;  
    //写入计数器  
    application.setAttribute("counter", count); 
    System.out.println("count==="+count);
    Long time=(System.currentTimeMillis()-history)/1000;
    if(time>50)
    {
    	application.setAttribute("historytime", null);  
    	application.setAttribute("counter", null); 
    }
    if(time!=0)
    System.out.println(time+"===avg count per second==="+count/time);
%>  
<form action="${pageContext.request.contextPath}/login/668/login.do" method="post">
<table>
<tr>
<td>用户名：</td>
<td><input type="text" name="username"/></td>
</tr>
<tr>
<td>密码：</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="登录"/></td>
</tr>
</table>
</form>
</body>
</html>