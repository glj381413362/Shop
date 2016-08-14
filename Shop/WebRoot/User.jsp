<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>

<link rel="stylesheet" href="<%=basePath%>css/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="<%=basePath%>css/icon.css" type="text/css"></link>
<link rel="stylesheet" href="<%=basePath%>css/demo.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script><body >
<form action="userServlet.action?op=select" method="post">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li class="current"><a href="user.html">用户</a></li>
			<li><a href="product.html">商品</a></li>
			<li><a href="order.html">订单</a></li>
			<li><a href="guestbook.html">留言</a></li>
			<li><a href="news.html">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
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
		<h2>用户管理</h2>
		<div class="manage">
			<!--<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>密码</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${listuser}">
				<tr>
				    <td>${user.userid }</td>
			        <td>${user.username }</td>
			        <td>${user.userpwd }</td>
			        <td>操作</td>
			    </tr>
				</c:forEach>
			</table>-->
	<table id="dg" title="Custom DataGrid Pager" style="width:700px;height:250px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'userServlet.action?op=select',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'userid',width:80">用户编号</th>
				<th data-options="field:'username',width:100">用户名</th>
				<th data-options="field:'userpwd',width:80,align:'right'">用户密码</th>
			</tr>
		</thead>
	</table>
	
	<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
	</script>
			
			<!-- 分页前台代码 
		<table align="center" width="1000">
		<tr>
			<td align="center">
			<c:if test="${curPage > 1}">
					<a href="userServlet.action?op=select&jumpPage=1">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="userServlet.action?op=select&jumpPage=${curPage - 1}">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="userServlet.action?op=select&jumpPage=${curPage + 1}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="userServlet.action?op=select&jumpPage=${maxPage}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</td>
		</tr>
	</table>-->
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
	</form>
</body>
</html>
