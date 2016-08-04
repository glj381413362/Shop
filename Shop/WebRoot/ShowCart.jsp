<%@ page language="java" import="java.util.*,cn.com.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowCart.jsp' starting page</title>
    
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
  <table width="750" border="1">
  <tr>
    <th>ID</th>
    <th >商品图片</th>
    <th >商品名称</th>
    <th >商品价格</th>
    <th >商品详情</th>
    <th >商品数量</th>
  </tr>
  <% 
  Object obj = request.getAttribute("carts");
  if(obj!=null)
  {
     Map<Integer, BuyCard> carts = (Map<Integer, BuyCard>)obj;
      //向页面输出
      for(Integer key : carts.keySet())
         out.println("<tr><td align='center'>"+carts.get(key).getBid()
         +"</td><td align='center'><img src='"+carts.get(key).getBface()
         +"'></td><td align='center'>"+carts.get(key).getBname()
         +"</td><td align='center'>"+carts.get(key).getBprice()
         +"</td><td align='center'>"+carts.get(key).getBinfo()
         +"</td><td align='center'>"+carts.get(key).getCartnum()
         +"</td><td align='center'>");
  }
   %>
  </body>
</html>
