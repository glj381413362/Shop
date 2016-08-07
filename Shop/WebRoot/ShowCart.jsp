<%@ page language="java" import="java.util.*,cn.com.bean.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
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
    <th >操作</th>
  </tr>
   <c:forEach var="cart" items="${cart}">
      <tr><td align='center'>${cart.key}</td>
      <td align='center'><img src="${cart.value.bface}"/></td>
      <td align='center'>${cart.value.bname}</td>
      <td align='center'>${cart.value.bprice}</td>
      <td align='center'>${cart.value.binfo}</td>
      <td align='center'>${cart.value.cartnum}</td>
       <td align='center'><a href="cartServlet.action?op=delete&id=${cart.key}">删除</a></td></tr>
   </c:forEach>
  </body>
</html>
