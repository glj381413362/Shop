<%@ page language="java" import="java.util.*,cn.com.bean.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="../index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li><a href="user.html">用户</a></li>
			<li class="current"><a href="product.html">商品</a></li>
			<li><a href="order.html">订单</a></li>
			<li><a href="guestbook.html">留言</a></li>
			<li><a href="news.html">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
管理</dt>
				<dd><em><a href="user-add.html">新增</a></em><a href="user.html">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="productClass-add.html">新增</a></em><a href="productClass.html">分类管理</a></dd>
				<dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.html">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.html">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
<table width="750" border="1">
  <tr>
    <th>ID</th>
    <th >商品图片</th>
    <th >商品名称</th>
    <th >商品价格</th>
    <th >商品详情</th>
    <th >商品数量</th>
    <th>操作</th>
  </tr>
   <c:forEach var="buycard" items="${product}">
     <tr><td align='center'>${buycard.bid}</td>
     <td align='center'><img src="${buycard.bface}" alt="" /></td>
     <td align='center'>${buycard.bname}</td>
     <td align='center'>${buycard.bprice}</td>
     <td align='center'>${buycard.binfo}</td>
     <td align='center'>${buycard.bnumber}</td>
     <td align='center'><a href='buyCardServlet.action?op=update&opp=select&id=${buycard.bid}'>修改</a>&nbsp;<a href='buyCardServlet.action?op=delete&id=${buycard.bid}'>删除</a><a href='cartServlet.action?op=add&id=${buycard.bid}'>购买</a></td>
     </tr>
   </c:forEach>
</table>
	<!-- 分页前台代码 -->
		<table align="center" width="1000">
		<tr>
			<td align="center">
			<c:if test="${curPage > 1}">
					<a href="buyCardServlet.action?op=select&jumpPage=1">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="buyCardServlet.action?op=select&jumpPage=${curPage - 1}">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="buyCardServlet.action?op=select&jumpPage=${curPage + 1}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="buyCardServlet.action?op=select&jumpPage=${maxPage}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</td>
		</tr>
	</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
