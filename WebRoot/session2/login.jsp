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
	<script type="text/javascript">
	function _change(){
		var ele=document.getElementById("v");
		ele.src="/JavaWeb/VertifyCodeServlet?a=" + new Date().getTime();
	}//不断的请求验证码图片，后面加时间参数是为了防止客户端直接将缓冲的图片返回而不访问服务器，造成两次图片一致
	//而这个参数是不会影响服务器端处理验证码请求的程序的，因为服务器在解析路径是是不包含请求参数的（？后面的）
	</script>
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
    	验证码：<input type="text" name="vertify" ><br>
    	<img id="v" src="/JavaWeb/VertifyCodeServlet" >
    	<a href="javascript:_change()">换一张</a><br>
    	<input type="submit" name="info" value="登录"><br>
    </form> <br>
  </body>
</html>
