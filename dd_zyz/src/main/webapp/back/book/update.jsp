<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<form action="${pageContext.request.contextPath }/book/updateOneBook" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>id：</td>
					<td><input type="text" name="book.id" class="el-input__inner" value="${book.id }" readonly></td>
					<td></td>
				</tr>
				<tr>
					
					<td>名称：</td>
					<td><input type="text" name="book.name" class="el-input__inner" value="${book.name }"></td>
					<td rowspan="14" style="width: 300px">
					<td>版次：</td>
					<td><input type="text" name="book.edition" class="el-input__inner" value="${book.edition }"></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="book.categoryId" class="el-select__inner inner2">
							<c:forEach var="category" items="${listCategory }">
								<c:if test="${book.categoryId eq category.id }">
									<option value="${category.id }" selected="selected">${category.name }</option>
								</c:if>
								<c:if test="${book.categoryId ne category.id }">
									<option value="${category.id }" >${category.name }</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="book.wordNum" class="el-input__inner" value="${book.wordNum }" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="book.price" class="el-input__inner" value="${book.price }"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="${pageContext.request.contextPath }${book.cover}" alt="" width="120" height="145" />
						</label> 
						<input type="file" name="cover" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>本站价格：</td>
					<td><input type=number name="book.ddprice" class="el-input__inner" value="${book.ddprice }"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="book.stock" class="el-input__inner" value="${book.stock }"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="book.author" class="el-input__inner" value="${book.author }"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.editorRecommend">${book.editorRecommend }</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="book.press" class="el-input__inner" value="${book.press }"></td>
					<td></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="book.printDate" class="el-input__inner" value="${book.printDate }"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.contentAbstract" >${book.contentAbstract }</textarea></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="book.isbn" class="el-input__inner" value="${book.isbn }"></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

