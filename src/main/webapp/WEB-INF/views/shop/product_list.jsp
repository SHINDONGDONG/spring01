<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h1>상품목록</h1>
<button type="button" id="btnAdd">상품등록</button>
<table border="1" width="500">
	<tr>
		<td>상품ID</td>
		<td>&nbsp;</td>
		<td>상품명</td>
		<td>가격</td>
	</tr>
	<c:forEach var="row" items="${list}">
	<tr align="center">
		<td>${row.product_id}</td>
		<td><img src="${path}/images/${row.picture_url}"
		width="100" height="100"></td>
		<td><a href="${path}/shop/product/detail/${row.product_id}">
		${row.product_name}</a>
		</td>
		<td><fmt:formatNumber value="${row.price}" pattern="#,###" /></td>
	</tr>
	</c:forEach>
	
</table>


</body>
</html>