<%@page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>欢迎光临</title>
		<link href="${pageContext.request.contextPath }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script>
			$(function(){
					$(".aa").mouseover(function(e) {
						//1.获取当前的图片
						var width = this.width * 3;
						var height = this.height * 3;
						//2.获取鼠标当前位置
						var x = e.pageX;
						var y = e.pageY;
						//3.创建一个div
						var div = $("<div id='bigDiv'/>").css({
							"position" : "absolute",
							"display" : "none",
							"width" : width,
							"height" : height,
							"top" : y + 10,
							"left" : x + 10,
							"border" : "1px solid red"
						});
						//4.创建一个img
						var img = $("<img/>").css({
							"width" : width,
							"height" : height,
						}).attr({
							"src" : this.src
						});
						//5.将img放到div中
						div.append(img);
						//6.将div放到body中
						$("body").append(div);
						div.show(1000);
					}).mousemove(function(e) {
						//1.获取鼠标当前位置
						var x = e.pageX;
						var y = e.pageY;
						//改变div的位置
						$("#bigDiv").css({
							"top" : y + 10,
							"left" : x + 10
						});
					}).mouseout(function(e) {
						$("#bigDiv").remove();
					});
				});
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<%-- <div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div> --%>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath }/FrontFirstView/frontFirstView'>首页</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${FirstCategory.name }</strong> </font>
			<c:if test="${SecoundCategory ne null }">
				&gt;&gt;
				<font style='color: #cc3300'><strong>${SecoundCategory.name }</strong> </font>
			</c:if>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;全部&nbsp;(${FirstCategory.books.size() })
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach var="s" items="${secound }">
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<div class=second_fenlei>
											<a href="${pageContext.request.contextPath }/frontSecoundView/findBookBySecound?id=${FirstCategory.id}&sid=${s.id}">
											<c:if test="${s.name eq SecoundCategory.name }">
												<font style="color:red">${s.name }</font>
											</c:if>
											<c:if test="${s.name ne SecoundCategory.name }">
												${s.name }
											</c:if>
											&nbsp;(${s.books.size() })
											</a>
										</div>
									</div>
								</li>
							    <div class="clear"></div>
							</c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							分页导航
						</div>
						<!--  <select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>-->
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<c:if test="${SecoundCategory eq null }">
							<c:if test="${page > 1 }">
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath }/frontSecoundView/findFirstAndSecoundAndBook?page=${page - 1}&id=${FirstCategory.id}">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' /> 
								</a>
							</div>
							</c:if>
							</c:if>
							
							<c:if test="${SecoundCategory ne null }">
								<c:if test="${page > 1 }">
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="${pageContext.request.contextPath }/frontSecoundView/findBookBySecound?page=${page - 1}&id=${FirstCategory.id}&sid=${SecoundCategory.id }">
										<img src='${pageContext.request.contextPath }/front/images/page_up.gif' /> 
									</a>
								</div>
								</c:if>
							</c:if>
							
							<div class='list_r_title_text3b'>
								第${page }页/共${total }页
							</div>
							
							<c:if test="${SecoundCategory eq null }">
								<c:if test="${page < total }">
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="${pageContext.request.contextPath }/frontSecoundView/findFirstAndSecoundAndBook?page=${page + 1}&id=${FirstCategory.id}">
										<img src='${pageContext.request.contextPath }/front/images/page_down.gif' /> 
									</a>
								</div>
								</c:if>
							</c:if>
							
							<c:if test="${SecoundCategory ne null }">
								<c:if test="${page < total }">
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="${pageContext.request.contextPath }/frontSecoundView/findBookBySecound?page=${page + 1}&id=${FirstCategory.id}&sid=${SecoundCategory.id }">
										<img src='${pageContext.request.contextPath }/front/images/page_down.gif' /> 
									</a>
								</div>
								</c:if>
							</c:if>
							
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<c:forEach var="b" items="${pageBooks }">
							<div class="list_r_line"></div>
							<div class="clear"></div>
								<div class="list_r_list">
									<span class="list_r_list_book">
										<a name="link_prd_img" href='${pageContext.request.contextPath }/FrontFirstView/findOneById?id=${b.id}'>
											<img class="aa" src="${pageContext.request.contextPath }${b.cover}" /> 
										</a>
									</span>
									<h2>
										<a name="link_prd_name" href='${pageContext.request.contextPath }/FrontFirstView/findOneById?id=${b.id}'>${b.name }</a>
									</h2>
						
									<h4 class="list_r_list_h4">
										作 者:
										<a href='#' name='作者'>${b.author }</a>
									</h4>
									<h4>
										出版社：
										<a href='#' name='出版社'>${b.press }</a>
									</h4>
									<h5>
										简介：
										${b.contentAbstract }
									</h5>
									<div class="clear"></div>
									<h6>
										<span class="del">￥${b.price }</span>
										<span class="red">￥${b.ddprice }</span>
										节省：￥${b.price - b.ddprice }
									</h6>
									<span class="list_r_list_button"> 
									<a href="${pageContext.request.contextPath }/CartAction/cart?id=${b.id}"> 
										<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' /> 
									</a>
									
									<span id="cartinfo"></span>
									<button onclick="location.href='${pageContext.request.contextPath }/CartAction/cart?id=${b.id }&type=e'" >购买电子版</button>
								</div>
							<div class="clear"></div>
						</c:forEach>
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%-- <%@include file="../common/foot.jsp"%> --%>
		<!--页尾结束 -->
	</body>
</html>
