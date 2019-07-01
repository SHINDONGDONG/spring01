<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<div style="text-align:center">
	<a href="${path }/">main</a>
	<a href="${path }/gugu.do?dan=3">구구단</a> |
	<a href="${path }/test.do">테스트</a> |
	<a href="${path }/member/list1.do">회원관리</a> |
	<a href="${path }/upload/uploadForm">파일업로드 테스트</a> |
	<a href="${path }/shop/product/list.do">상품목록</a>
	<div style="text-align:right;">
	<a href="${path }/member1/login.do">로그인</a>
	<a href="${path }/member1/login.do">로그아웃</a>
	</div>
</div>
<hr>