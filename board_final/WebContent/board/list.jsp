<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<link href="images/favicon.ico" rel="icon">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script>
$(function() {
	$("#chkMaster").change(function(){
		$("input:checkbox").prop("checked",$(this).prop("checked"));
	})
	$(".chk").change(function(){
		if($(this).prop("checked")) {
			$(".del-all").show();
		}
	});
	
});
</script>
<title>게시판</title>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>

<section>
	<table class="common-tbl board-tbl">
		<caption>게시판</caption>
		<thead>
		<tr>
		
		<th><input type="checkbox" id="chkMaster" class="chk"></th>
			<th>no</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
		</thead>
		<tbody>
					<c:if test="${fn:length(list)==0}">
						<td colspan="6">게시글이 없습니다.</td>
					</c:if>
					<c:forEach items="${list}" var="i">
						<tr>
							<td><input type="checkbox" class="chk" name="code"
								value="${i.idx}"></td>
							<td>${i.idx}</td>
							<td><a href="view?idx=${i.idx}">${fn:escapeXml(i.title)}</a>
								<a href="view?idx=${i.idx} #comment">[${i.commentCount}]</a> 
								<c:if
									test="${ i.fileCount > 0}">
									<img src="images/Folder.png" class="attached">
								</c:if></td>
							<td>${i.writer}</td>
							<td>${i.regdate}</td>
							<td>${i.count}</td>
							<td>${i.reco}</td>
						</tr>
					</c:forEach>
				</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<input type="hidden" name="boardIdx" value="${board.idx}">
				<input type="hidden" name="writer" value="${member.idx}">
					<c:if test="${not empty member}">
						<a href="write"><button type="button">글작성</button></a>
					</c:if>
					<c:if test="${member.admin}">
						<a onclick="cinfirm('정말 전체 삭제하시겠습니까?')" href="remove?idx=${board.idx}">
							<button class="del-all" >삭제</button>
						</a>
					</c:if>
			</td>
		<td colspan="6">
		</td>
		</tr>
	</tfoot>
	</table>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>