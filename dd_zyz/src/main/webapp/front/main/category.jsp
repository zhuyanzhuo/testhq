<%@page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
		<c:forEach var="parent" items="${allFirst }">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${pageContext.request.contextPath }/frontSecoundView/findFirstAndSecoundAndBook?id=${parent.id}'>${parent.name }</a>]
				</h3>
				<ul class="ul_left_list">

						<!--2级分类开始-->
						<c:forEach var="secound" items="${allSecound }">
							<c:if test="${secound.parent_id == parent.name }">
								<li>
									<a href='${pageContext.request.contextPath }/frontSecoundView/findBookBySecound?id=${parent.id}&sid=${secound.id}'>${secound.name }</a>
								</li>
							</c:if>
						</c:forEach>
						<!--2级分类结束-->

				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		</c:forEach>
		<!--1级分类结束-->
		
		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
