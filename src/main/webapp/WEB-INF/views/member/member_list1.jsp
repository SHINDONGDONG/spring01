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

<h1>회원리스트 06/27일</h1>

<input type="button" value="회원가입" 
onclick="location.href='${path}/member/write1.do'">

<form name="form1" method="post">
<table border="1" width="700">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>생성날짜</td>
	</tr>
	<c:forEach var="row" items="${list }">
	<tr>
		<td>${row.userid}</td>
		<td><a href="${path}/member/view1.do?userid=${row.userid}">${row.name }</a></td>
		<td>${row.email }</td>
		<td>${row.join_date }</td>
	</tr>
	</c:forEach>
</table>
</form>


<%-- 
<h1>회원목록</h1>
<input type="button" value="회원등록"
onclick="location.href='${path}/member/write1.do'">
<table border="1" width="700">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일자</td>
	</tr>
	<c:forEach var="row" items="${list}">
	<tr>
		<td>${row.userid}</td>
		<td><a href="${path}/member/view1.do?userid=${row.userid}">${row.name}</a></td>
		<td>${row.email}</td>
		<td><fmt:formatDate value="${row.join_date}"
		pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	</c:forEach>
	
	
</table>
 --%>
</body>
</html>