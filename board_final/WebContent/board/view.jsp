<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<link href="images/favicon.ico" rel="icon">
<title>게시판</title>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>
<section>
	<table class="common-tbl board-tbl board-tbl-view">
		<caption>게시판</caption>
		<tbody>
		<tr>
		
			<th>제목</th>
			<td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
			<th>작성일</th>
			<td>${board.regdate}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.count}</td>
			<th>추천수</th>
			<td>${board.reco}</td>
		</tr>
		<tr>
			<td colspan="4">${board.content}</td>
		</tr>
		</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<a href="list"><button type="button">목록</button></a>
				<c:if test="${member.admin || member.idx == board.writerIdx}">
				<a href="update?idx=${board.idx}"><button type="button" onclick="alert('준비중입니다.'); return false;">수정</button></a>
				<a href="remove?idx=${board.idx}"><button type="button" onclick="return confirm('삭제하시겠습니까?')">삭제</button></a>
				</c:if>
			</td>
		</tr>
	</tfoot>
	
	</table>
	
	<!-- 댓글 -->

	<form method="post" >
	<input type="hidden" name="boardIdx" value="${board.idx }">
	<input type="hidden" name="writer" value="${member.idx }">
	<table class="reply-tbl" id="comment">
		<c:forEach items="${replys}" var="i">
		<tr>	
			<td>${i.writer } </td>
			<td class="reply-content">${i.content} </td>
			<td>${i.regdate } </td>
			<c:if test="${member.admin || member.idx == board.writerIdx || member.idx == i.writerIdx}">
			<td>
				<a href="replyDelete?idx=${i.idx}&boardIdx=${board.idx}" onclick="return confirm('삭제하시겠습니까?')"> 
					<img src="images/Cancel.png" class="reply-del-btn">
				</a>
			</td>
			</c:if>
		</tr>	
		</c:forEach>
		<c:if test="${not empty member }">
		
			<tr class="reply-writer-form">
				<td>${member.name}</td>
				<td colspan="3">
					<textarea name="content"> </textarea>
				</td>
				<td colspan="2">
					<button class="rebtl">답글 작성</button>
				</td>
			</tr>
		</c:if>
	</table>
	</form>
	
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>