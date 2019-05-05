<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>我的电子书</title>
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/back.css">
    <style type="text/css">
		body{
			text-align: center;
		}
		select{
			width:173px;
		}
		p{
			text-indent:30px;
			/* text-align:justify; */
			letter-spacing:3px;
			font-size:15px;
		}
		.my_div{
			width:300px; height:100px; background:#CC9933; display:none;
		}
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>
     <script src="${pageContext.request.contextPath}/boot/js/bootstrap.min.js"></script>
     <script>
     	
     	function del(e){
     		var id = $(e).parent().attr("id");
     		$.post("${pageContext.request.contextPath}/FrontEbook/addLikeNum",{id:id});
     		alert("点赞成功！");
     	}

     	function changesize(size) {
            document.getElementById("").style.font = size + "px";
        }
     </script>
  </head>
  
  <body style="background-color: #f0f9fd;">
  	
  	<div style="text-align:center ;font-size:18px">书名：${book.name }&nbsp;&nbsp;&nbsp;&nbsp;第${strChap }/${maxStrChap }章</div><hr/>
  	<div class="container-fluid">
    <div class="row">

        <!--左边-->
        <div class="col-sm-3"  ></div>
        <!--中间-->
        <div class="col-sm-6">
			<c:forEach var="map" items="${map }">
				<div id="${map.key }">
					<p align="left"  onclick="del(this);" title="觉得本段精彩？单击即可点赞">
						<c:forEach var="list" items="${map.value }">
							${list }
						</c:forEach>
					</p>
				</div>
			</c:forEach>
		</div>
		<div class="col-sm-3" ></div>
	</div>
	</div>
	<c:if test="${strChap ne '1' }">
		<input  class="button"  onclick="location.href='${pageContext.request.contextPath }/FrontEbook/updateChapter?id=${book.id }&strChap=${strChap }&mark=del'" value="上一章" />
	</c:if>
	<c:if test="${strChap ne maxStrChap }">
		<input  class="button"  onclick="location.href='${pageContext.request.contextPath }/FrontEbook/updateChapter?id=${book.id }&strChap=${strChap }&mark=add'" value="下一章" />
	</c:if>
		<input class="button btn-p" type="button" value="返回目录" onclick="location.href='${pageContext.request.contextPath}/FrontEbook/showChapter?id=${book.id}'"/>
		<input class="button btn-p" type="button" value="返回上级" onclick="history.go(-1);"/>
  </body>
</html>








