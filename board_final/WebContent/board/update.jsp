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
<form method="post">
	<input type="hidden" name="idx" value="${board.idx}">
	<table class="common-tbl board-tbl board-tbl-view">
		<caption>게시판</caption>
		<tbody>
		<tr>
			<th>제목</th>
			<td colspan="3"><input name="title" value="${board.title}"></td>
		</tr>
	
		
		<tr>
			<td colspan="4">
			<textarea name="content">${board.content}</textarea>
			</td>
		</tr>
		</tbody>
	<tfoot>
		<tr>
			<td colspan="4">
				<button type="submit">수정</button>
				<button type="reset">취소</button>
				<a href="list"><button type="button">목록</button></a>
			</td>
		</tr>
	</tfoot>
	</table>
	</form>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>