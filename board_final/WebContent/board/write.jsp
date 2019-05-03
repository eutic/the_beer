<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="css/main.css">
<link href="images/favicon.ico" rel="icon">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script>
		/* 	if(src) {
				$(this).next().html(function(i, html){
					return html + "<img id = 'cancelImg' src = 'images/Cancel.png>'"
				})
			$("#cancelImg").click(function(e){
				e.stopPropagation();
				$(file).val()
			}) 
			}	*/		
	$(function(){
		$("input:file").change(function(){
			var file  = this;
			var src = $(this).val();
			$(this).next().text(src.slice(src.lastIndexOf("\\")+1));
		});
	});
</script>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>

<section>
 	<form method="post" enctype="multipart/form-data">
	<table class="common-tbl board-tbl board-tbl-write">
		<caption>게시판</caption>
		<tbody>
		<tr>
			<th>제목</th>
			<td colspan="3"><input name="title"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td colspan="3">
				<label>
					<input type="file" name="file1" >
					<span class="fileRepl">파일첨부</span>
				</label>
				<label>
					<input type="file" name="file2" >
					<span class="fileRepl">파일첨부</span>
				</label>
				<label>
					<input type="file" name="file3" >
					<span class="fileRepl">파일첨부</span>
				</label>
		</tr>
		<tr>
			<td colspan="4">
			<textarea name="content"></textarea>
			</td>
		</tr>
		</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<button >작성</button>
				<a href="list"><button>취소</button></a>
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