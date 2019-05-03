<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Answer</title>
<link rel="stylesheet" href="css/main.css">
<link href="images/favicon.ico" rel="icon">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
article{padding: 50px ; margin: 10px auto;}
article a {padding: 10px ;margin: 0 auto;}
/* .widget h1{padding: 20px ; margin: 10px auto; text-align: center;} */
.widget h3 {padding: 10px ; margin: 10px auto;}
.widget b {padding: 10px ; margin: 10px auto; color: blue;}
.widget a{padding: 10px ; margin: 10px auto;}
.widget {text-align: center; line-height:150%;}
#quizScore{text-align: center;}
</style>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>
<section>
	<div class="widget">

				<article>
				  	<div id="question1" >
						<h3>1.다음 중 종류가 다른 한가지는?</h3>
				   			<b>밀러는 라거입니다. </b><br>
							<p>a) 파울라너</p><br>
							<p >b) 바이엔슈테판</p><br>
							<p style="color: red;">c) 밀러</p><br>
							<p>d) 에딩거</p><br>
					</div>
					<div id="question2" >
						<h3>2.다음 중 종류가 다른 한가지는?</h3>
							<b>블랑은 에일입니다.</b><br>
							<p>a) 카스</p><br>
							<p>b) 버드와이저</p><br>
							<p>c) 아사히</p><br>
							<p style="color: red;">d) 블랑</p><br>
					</div>
				<div id="question3" >
					<h3>3.다음 중 종류가 다른 한가지는?</h3>
						<b>트라피스트 맥주 인증을 받은 수도원은 전 세계 11곳 입니다.</b><br>
							<p style="color: red;">a) 보통 맥주보다 3배의 몰트가 필요하다고 해서 지어진 이름이다.</p><br>
							<p>b) 트라피스트 수도회에서 만들어 마시던 맥주이다.</p><br>
							<p>c) 트라피스트 맥주 인증을 받은 수도원은 전 세계 10개 뿐이다.</p><br>
							<p>d) 고유한 향과 맛을 즐기기 위해 레드와인 온도에서 마시는 것이 가장 좋다.</p><br>
				</div>
				<div id="question4" >
					<h3>4.카스의 특징으로 틀린 것은?</h3>
						<b>고든 램지가 극찬하며 CF 찍었습니다.</b><br>
							<p style="color: red;">a) 고든 램지가 비하한 맥주이다.</p><br>
							<p>b) 우리나라의 대표적인 라이트 라거이다.</p><br>
							<p>c) 1994년 5월에 진로가 미국의 쿠어스 맥주와 제휴한 '진로쿠어스맥주'에서 출시하였다.</p><br>
							<p>d) 비열처리공법으로 맥주의 신선하고 톡 쏘는 맛을 더욱 향상한 특징이 있다.</p><br>
				</div>
				<div id="question5" >
					<h3>5. 맥주의 역사 중 틀린 것은?</h3>
						<b>현재와 같은 맥주 제조방법은 12세기경 독일 수도원에서 호프를 처음 사용하면서 시작되었습니다. </b><br>
							<p>a) 맥주는 B.C 4000년경 중동 지방의 수메르 민족이 최초로 제조하였던 것으로 알려져 있다.</p><br>
							<p style="color: red;">b) 현재와 같은 맥주 제조방법은 12세기경 벨기에 수도원에서 호프를 처음 사용하면서부터 시작되었다.</p><br>
							<p>c) 19세기에 파스퇴르에 의해 살균법이 개발됨으로써 오랫동안 보관할 수 있게 되었고, 
							이후 덴마크의 한센은 효모의 순수 배양법을 발명하여 맥주의 질을 한 차원 더 높였다.</p><br>
							<p>d) 80년대 이후 맥주 고유의 신선도를 유지하면서 장기 유통을 할 수 있는 첨단 비열처리 공법이 개발되면서 
							소비자들은 더욱 신선한 맥주를 즐길 수 있게 되었다.</p><br>
				</div>
				</article> 
			
	</div>

</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>