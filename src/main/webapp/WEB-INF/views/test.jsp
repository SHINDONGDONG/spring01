<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/menu.jsp" %>
<script>
function doF(){
	$.ajax({
		type : "post",
		url : "${path}/test/doF",
		success : function(result){
			$("#result").html("상품명:"+result.name+"가격 : "+result.price);
		}
	})
}
</script>


<h1>링크테스트</h1>

<a href="${path}/test/doA.do">doA</a><br>
<a href="${path}/test/doB.do">doB</a><br>
<a href="${path}/test/doC.do">doC</a><br>
<a href="javascript:doF()">doF</a><br>
<div id="result"></div>
</body>
</html>