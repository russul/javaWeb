<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<font color="red"><b>
  	<h1>
  		<%
  		Cookie[] c=request.getCookies();
  		String username="";
  		if(c!=null){
  			for(Cookie cc:c){
  	  			if("username".equals(cc.getName())){
  	  				username=cc.getValue();
  	  			}
  	  		}
  		}
  		
  		String msg=(String)request.getAttribute("msg");
  			if(msg!=null){
  				out.print(msg);
  			}
  		%>
  	</h1></b>
  	</font>
    <form action="/JavaWeb/LoginServlet" method="post">
    	用户名：<input type="text" name="username" value=<%=username %>><br>
    	密    码：<input type="password" name="password"><br>
    	<input type="submit" name="info" value="登录"><br>
    </form> <br>
  </body>
</html>
