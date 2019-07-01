<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>

<!-- <script>
	$(function(){
	
		$("#btnUpdate").click(function(){
			document.form1.action="${path}/member/update1.do";
			document.form1.submit();
			});
		$("#btnDelete").click(function(){
			if(confirm("삭제헐꺼여??")){
				document.form1.action="${path}/member/delete1.do";
				document.form1.submit();
			}
		});
	});
</script> -->

<script>
	$(function(){
		$("#btnUpdate").click(function(){
			document.form1.action="${path}/member/update1.do";
			document.form1.submit();
		});
		$("#btnDelete").click(function(){
			if(confirm("삭제할꺼양?")){
			document.form1.action="${path}/member/delete1.do";
			document.form1.submit();
			}
		});
	});
</script>

</head>
<body>
<%@ include file="../include/menu.jsp" %>

<h1>회원 상세화면 06/27일</h1>
<form name="form1" method="post">
<table border="1" width="300">
	<tr>
		<td>아이디</td>
		<td><input name="userid" value="${dto.userid}" readonly></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input name="name" value="${dto.name}"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input name="email" value="${dto.email}"></td>
	</tr>
	<tr>
		<td>생성날짜</td>
		<td><input name="join_date" value="${dto.join_date}" readonly></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="수정" id="btnUpdate">
			<input type="button" value="삭제" id="btnDelete">
			<div style="color:red;">${message}</div>
		</td>
	</tr>
</table>
</form>




<%-- <form name="form1" method="post">
<table border="1" width="400">
	<tr>
		<td>아이디</td>
		<td><input name="userid" value="${dto.userid}" readonly></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input name="name" value="${dto.name}"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input name="email" value="${dto.email}"></td>
	</tr>
	<tr>
		<td>회원가입일자</td>
		<td><fmt:formatDate value="${dto.join_date}"
		 pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="수정" id="btnUpdate">
		<input type="button" value="삭제" id="btnDelete">
		<div style="color:red;">${message}</div>
		</td>
		
	</tr>
</table>

</form> --%>



</body>
</html>