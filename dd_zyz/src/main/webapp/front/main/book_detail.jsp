<%@page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/front/css/book_detail.css"/>
		<link href="${pageContext.request.contextPath }/front/css/public_footer.css" rel="stylesheet" type="text/css" />
		 
		 
	<style>
		
		.grade{
			text-indent:30px;
			/* text-align:justify; */
			letter-spacing:3px;
			font-size:15px;
		}
		
	</style>
	</head>
	<body>
		<br/>
		<div>
			<h1>
				丛书名：${book.name }
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${pageContext.request.contextPath }${book.cover}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${book.author }</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${book.press }</td>
			</tr>
			<tr>
				<td>字数：${book.wordNum }</td>
			</tr>
			<tr>
				<td>版次：${book.edition }</td>
				<td></td>
			</tr>
			<tr>
				<td>印次：${book.printDate }</td>
				<td></td>
			</tr>
			<tr>
				<td>ISBN：${book.isbn }</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${book.price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">本站价格：￥${book.ddprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${book.price - book.ddprice }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath }/CartAction/cart?id=${book.id}">
						<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
					</a>
				</td>
				
				<td>
					<button onclick="location.href='${pageContext.request.contextPath }/CartAction/cart?id=${book.id }&type=e'" >购买电子版</button>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>&nbsp;&nbsp;${book.editorRecommend }</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>&nbsp;&nbsp;${book.contentAbstract }</p>
		<hr style="border:1px dotted #666"/>
		<h2>精彩内容</h2>
		<div>
			<c:forEach var="map" items="${map }">
				<div id="${map.key }">
					
						<c:forEach var="list" items="${map.value }">
							<p align="left">
								${list }
							</p>
						</c:forEach>
					
				</div>
			</c:forEach>
		</div>
		<hr style="border:1px dotted #666"/>
		<!-- <h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p> -->
		<!--页尾开始 -->
		<%--<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="${pageContext.request.contextPath }/front/images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>--%>
		<!--页尾结束 -->
	</body>
</html>
