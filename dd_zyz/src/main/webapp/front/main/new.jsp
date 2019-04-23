<%@page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">
	<c:forEach var="book" items="${createTimeBookList }">
		<!--最新图书A开始-->
		<div class="second_d_wai">
			<div class="img">
				<a href="${pageContext.request.contextPath }/FrontFirstView/findOneById?id=${book.id}" target='_blank'>
					<img class="aa" src="${pageContext.request.contextPath }${book.cover}" border=0 /> 
				</a>
			</div>
			<div class="shuming">
				<a href="${pageContext.request.contextPath }/FrontFirstView/findOneById?id=${book.id}" target="_blank">${book.name }</a><a href="#" target="_blank"></a>
			</div>
			<h5>
				上架时间：<br>
				<fmt:formatDate value="${book.createTime }" pattern="yyyy-MM-dd"/>
			</h5>
			<div class="price">
				定价：￥${book.price }
			</div>
			<div class="price">
				本站价格：￥${book.ddprice }
			</div>
			<div class="price">
				销量：<font color="red">${book.sale }</font>
			</div>
		</div>
		<div class="book_c_xy_long"></div>
		<!--最新图书A结束-->
	</c:forEach>
</div>
<div class="clear"></div>