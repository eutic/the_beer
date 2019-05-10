<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<div>
		<h1><a style="color: white;" href="index.html">The Beer</a></h1>
			<nav id="lnb">
				<ul>
				<c:if test="${empty member }">
					<li><a href="join">회원가입</a></li>
					<li><a href="login">로그인</a></li>
				</c:if>
				<c:if test="${not empty member}">
					<li><a href="modify">${member.name}
					<c:if test="${member.admin}">(관리자)</c:if>
					님 환영합니다.
					</a></li>
					<li><a href="logout">로그아웃</a></li>
				</c:if>
				</ul>
			</nav>
	</div>
	<nav id="gnb">
		<ul>
			<li><a href="index.html" >HOME</a></li> 
			<li><a href="history">History</a></li>
			<li><a href="ale">Ale</a></li> 
			<li><a href="lager">Lager</a></li>
	 	 	<li><a href="#" onclick="alert('준비중입니다.'); return false;">Beer Map</a></li>
			<li><a href="quiz">Quiz</a></li>
			<li><a href="list">자유게시판</a></li>
			<li><a href="list?cate=1"class="gnb-last">답글형</a></li>
		</ul>
	</nav>
</header>