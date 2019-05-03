<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<link href="css/main.css" rel="stylesheet">
<link href="images/favicon.ico" rel="icon">
<c:if test="${empty member}">
<script>
	alert("세션정보가 만료되었습니다. 다시 로그인 진행해주세요");
	location.href = "login";
</script>
</c:if>
<script>
window.onload = function(){
	var frm = document.frm;
	frm.onsubmit = function(){
		if(frm.email.value == '') {
			alert("이메일이 입력되지 않았습니다.");
			frm.email.focus();
			return false;
		} 
		if(frm.pw.value == '') {
			alert("비밀번호가 입력되지 않았습니다.");
			frm.pw.focus();
			return false;
		} 
		if(frm.name.value == '') {
			alert("이름이 입력되지 않았습니다.");
			frm.phone.focus();
			return false;
		} 
		alert("수정이 완료 되었습니다.");
	}
}
</script>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>
<section>
	<form method="post" name="frm" action="modify">
	<input type="hidden" name="idx" value="${member.idx}">
		<table class="common-tbl join-tbl">
		<caption>회원 정보 수정</caption>
		
		<tr>
			<th><span>이메일</span></th>
			<td><input name="email"  placeholder="이메일을 입력하세요" readonly="readonly" value="${member.email}"></td>
		</tr>
		<tr>
			<th><span>비밀번호</span></th>
			<td><input name="pw" placeholder="4자 이상 입력하세요" type="password"></td>
		</tr>
		<tr>
			<th><span>이름</span></th>
			<td><input name="name" placeholder="이름을 입력하세요" value="${member.name}"></td>
		</tr>
				<tr>
			<td colspan="2">
				<button onclick="return confirm('수정하시겠습니까?')">수정</button>
			</td>
			<td colspan="2">
				<a href="resign">
					<button type="button" class="resign-btn" onclick="return confirm('진정 탈퇴하시겠습니까?')">
						회원탈퇴
					</button>
				</a>
			</td>
		</tr>
	</table>
	</form>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>