<%@page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<h2 class="t_xsrm">
		新书热卖榜
	</h2>
	<div id="NewProduct_1_o_t" onmouseover="">
		<c:forEach var="book" items="${newAndCreateTimeList }">
			<ul>
				<li>&nbsp;&nbsp;&nbsp;
					<a  target='_blank' href="${pageContext.request.contextPath }/FrontFirstView/findOneById?id=${book.id}">
						${book.name }
					</a>
				</li>
			</ul>
		</c:forEach>
	<h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>