<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>我的电子书</title>
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
    <style type="text/css">
		body{
			text-align: center;
		}
		select{
			width:173px;
		}
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>
  </head>
  
  <body style="background-color: #f0f9fd;">
  	
  	<div style="text-align:center ;font-size:18px">欢迎：${user.nickname }，您的电子书如下</div><hr/>
  	
		<div class="book_c_04">
			<c:forEach var="book" items="${books }">
				<div class="second_d_wai">
					<div class="img">
						<a href="${pageContext.request.contextPath }/FrontEbook/findChapter?id=${book.id}" target='_blank'>
							<img style="width:90px;height:160px" class="aa" src="${pageContext.request.contextPath }${book.cover}" border=0 /> 
						</a>
					</div>
					<div class="shuming">
						<a href="${pageContext.request.contextPath }/FrontEbook/findChapter?id=${book.id}" target="_blank">${book.name }</a><a href="#" target="_blank"></a>
					</div>
				</div>
				<div class="book_c_xy_long"></div>
			</c:forEach>
		</div>
		
		<input class="button btn-p" type="button" value="返回上级" onclick="history.go(-1);"/>
  
    	
  </body>
</html>
