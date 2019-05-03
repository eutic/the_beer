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
<link href="css/main.css" rel="stylesheet">
<link href="images/favicon.ico" rel="icon">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<c:if test="${param.message =='fail'}">
<script>
	alert("로그인에 실패했습니다.");
</script>
</c:if>
<script>
$(function(){
	$("input").keyup(function(){
		var flag = true;
		$("input").each(function(){
			if(!$(this).val().length) flag = false;				
		});
		
		if(flag) $("button").addClass("btn-active")
		else $("button").removeClass("btn-active")
	});


document.frm.onsubmit = function(){
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
		/* alert("로그인 완료"); */
	}
}
});
</script>

</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>
<section>
	<form method="post" name="frm" action="login">
		<table class="common-tbl login-tbl">
		<caption>로그인</caption>
		<tr>
			
			<td><input name="email"  placeholder="이메일을 입력하세요" autofocus="autofocus" required="required"></td>
		</tr>
		<tr>
			
			<td><input name="pw" placeholder="비밀번호를 입력하세요" type="password" required="required"></td>
		</tr>
		<tr>
			<td >
				<button class="btn-active">로그인</button>
			</td>
		</tr>
	</table>
	</form>
</section>

<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>