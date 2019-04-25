<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>我的电子书</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/back.css">
    <style type="text/css">
        .chapter{
            font-size: 30px;
            float: left;
            text-align: center;
            width: 400px;
        }
    </style>
</head>
<body style="background-color: #f0f9fd;">
    <div style="text-align:center ;font-size:18px">书名：${book.name }</div><hr/>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                <c:forEach items="${list}" var="chapter">
                    <div class="chapter">
                        <a href="${pageContext.request.contextPath}/FrontEbook/saveChapter?id=${book.id}&chapter=${chapter}" >第${chapter}章</a>
                    </div>
                </c:forEach>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </div>
</body>
</html>