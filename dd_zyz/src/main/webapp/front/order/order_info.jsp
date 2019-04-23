<%@page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 </title>
		<link href="${pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤:
			<span class="red_bold">1.确认订单</span> > 2.填写送货地址 > 3.订单成功
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>小计</b>
					</td>
				</tr>

				<!-- 订单开始 -->
				<c:forEach var="cart" items="${cart }">
					<c:forEach var="vl" items="${cart.value}" varStatus="v">
					<tr>
						<td valign="top">
							${v.index + 1 }
						</td>
						<td valign="top">
							${vl.key.name }(${cart.key})
						</td>
						<td valign="top">
							${vl.key.ddprice }
						</td>
						<td valign="top">
							${vl.value }
						</td>
						<td valign="top">
							${vl.key.ddprice * vl.value }
						</td>
					</tr>
					</c:forEach>
				</c:forEach>
				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>
							总价￥
							<c:forEach var="cart" items="${cart }">
								<c:forEach var="vl" items="${cart.value}">
									<c:set var="total" value="${total + vl.key.ddprice * vl.value }"/>
								</c:forEach>
							</c:forEach>
							${total }
						</b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				<a href="${pageContext.request.contextPath }/front/cart/cart_list.jsp">
					<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="取消" />
				</a>		
				<a href="${pageContext.request.contextPath }/address/selectAll?total=${total}">
					<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</a>		
			</div>

		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

