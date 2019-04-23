<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>index.html</title>
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
  	
  	<div style="text-align:center ;font-size:18px">${book.name }</div><hr/>
  	
  	<form action="${pageContext.request.contextPath }/backebook/addEbook" method="post" enctype="multipart/form-data">
		第${chapter }章:
		<br/>
		<input style="display:none" name="id" value="${book.id }"/>
		<input type="number" style="display:none" name="chapter" value="${chapter }"/>
		<c:forEach var="map" items="${map }">
			${map.key }:<input type="file" name="para"><br/>
		</c:forEach>
		
  		<br/>
  		<input name="sub" class="button btn-p" type="submit" value="提交"/>&emsp;
  		<input name="sub" class="button btn-p" type="submit" value="提交且结束添加" />&emsp;
  		<input  class="button btn-p"  onclick="location.href='${pageContext.request.contextPath}/book/queryAll'" value="放弃此次添加" />&emsp;
		<input class="button btn-p" type="button" value="返回上级" onclick="history.go(-1);"/>
  	</form>
  
    	
  </body>
</html>
