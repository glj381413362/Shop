<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	   function registe()
	   {
	      alert("ok");
	       Window.location.href="Registe.jsp";
	   }
	</script>
  </head>
  
   <body>
    <form action="userServlet.action" method="get">
    <input type="hidden" name="op" value="login"> 
		   <table width="456" height="172" border="1" align="center">
<tr>
  <td colspan="2"><div align="center">用户登录</div>    <div align="center"></div></td>
</tr>
<tr>
  <td><div align="right">用户名：</div></td>
  <td><div align="left">
    <label for="name"></label>
    <input type="text" name="name" id="name" />
  </div></td>
</tr>
<tr>
  <td><div align="right">密&nbsp;&nbsp; 码：</div></td>
  <td><div align="left">
    <input type="password"  name="pwd" id="pwd"/>
  </div></td>
</tr>
<tr>
  <td><div align="right">验证码：</div></td>
  <td><div align="left">
    <input type="text"  name="yzm" id="yzm"/>
  </div></td>
</tr>
<tr>
  <td colspan="2">&nbsp;</td>
</tr>
<tr>
  <td colspan="2"><div align="center">
    <input type="submit" name="save" id="save" value="登录" />
    <!--  <a href="Registe.jsp">注册</a> -->
   <input type="button" name="registe" id="registe" value="注册" onclick="javascript:window.location.href='Registe.jsp'" />

  </div></td>
  </tr>
</table>
    </form>
  </body>
</html>
