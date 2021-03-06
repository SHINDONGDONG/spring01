<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(function(){
		$("#btnLogin").click(function(){
			var userid =$("#userid").val();
			var passwd =$("#passwd").val();
			if(userid=""){
				alert("아이디를 입력하세요.");
				$("#userid").focus();
				return;
			}
			if(passwd==""){
				alert("비밀번호를 입력하세요.");
				$("#passwd").focus();
				return;
			}
			document.form1.action="${path}/member/login_check.do";
			document.form1.submit(); 
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>

<h1>로그인화면</h1>
<form name="form1" method="post" action="">
	<table border="1" width="400">
		<tr>
			<td>아이디</td>
			<td><input id="userid" name="userid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input id="passwd" type="password" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="button" id="btnLogin">로그인</button>
			<c:if test="${message =='nologin'}">
				<div style="color:red;">
					먼저 로그인하세요.
				</div>
			</c:if>
			<c:if test="${message == 'error'}">
				<div style="color:red;">
					비밀번호 혹은 아이디가 일치하지 않습니다.
				</div>
			</c:if>
			<c:if test="${message == 'logout'}">
				<div style="color:red;">
					로그아웃되었습니다.
				</div>
			</c:if>
			</td>
		</tr>
	</table>
</form>

</body>
</html>