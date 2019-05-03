<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>The Beer</title>
<link rel="stylesheet" href="css/main.css">
<link href="images/favicon.ico" rel="icon">
<style>
	section {text-align: center;}
	article {width: 280px; border: 2px solid black; display: inline-block;
		text-align: left; padding: 5px;
	}
	article h3 {padding : 5px; background: #333; color: #ddd; }
	article h3 a {color: white; }
	article li {list-style: none; padding-left: 10ox; 
				white-space: nowrap; overflow: hidden; text-overflow: ellipsis;
				height: 20px;}
	article li a {font-size: 14px;}
</style>
</head>
<body>
<div id="wrapper">
<jsp:include page="common/header.jsp"></jsp:include>
<section>
 <img alt="beer" src="images/2.jpg">
<h2>시원한 맥주 한잔 하고 가세요!</h2>
         <div class="b">
	
<br>
         <p>맥주 좋아하시나요?</p>  
         </div>  
    
<%--     <c:forEach begin="0" end="3" var="i">
		<article>
			<h3><a href="list?cate=${i}">${bbs[i]}</a></h3>
			<ul>
				<c:forEach begin="0" end="4" var="j"> 
					<li><a href="view?idx=${list[j+i*5].idx}">${list[j+i*5].title}</a></li>
				</c:forEach>
			</ul>
		</article>
	</c:forEach> --%>
</section>
<jsp:include page="common/footer.jsp"></jsp:include>
</div>
</body>
</html>