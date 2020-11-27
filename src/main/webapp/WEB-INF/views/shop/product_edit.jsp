<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="${path }/summernote/summernote.css" rel="stylesheet">
<script src="${path }/summernote/summernote.js"></script>
<title>Insert title here</title>
<script>
$(function(){
	$("#description").summernote({
		height: 300,
		width: 800
	});
});
function product_update(){
	document.form1.action="${path}/shop/product/update.do";
	document.form1.submit();
}
function product_delete(){
	if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/shop/product/delete.do";
		document.form1.submit();
	}
}
</script>
</head>
<jsp:include page="../include/menu.jsp" />
<body>
<h2>상품 정보 편집</h2>
<form id="form1" name="form1" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>상품명</td>
			<td><input name="product_name" value="${dto.product_name }"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input name="price" type="number" value="${dto.price}"></td>
		</tr>
		<tr>
			<td>상품설명</td>
			<td><textarea rows="5" cols="60" name="description" id="description">${dto.description }</textarea></td>
		</tr>
		<tr>
			<td>상품이미지</td>
			<td>
				<img src="${path }/images/${dto.picture_url}" width="300px" height="300px">
				<br>
				<input type="file" name="file1">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="hidden" name="product_id" value="${dto.product_id }">
				<input type="button" value="수정" onclick="product_update()">
				<input type="button" value="삭제" onclick="product_delete()">
				<input type="button" value="목록" onclick="location.href='${path}/shop/product/list.do'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>