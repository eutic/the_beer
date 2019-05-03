<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Quiz</title>
<link rel="stylesheet" href="css/main.css">
<link href="images/favicon.ico" rel="icon">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
var delay=20; //시간설정
var correctAnswers=new Array("c","d","c","a","b");  //정답

var q_num=1;
var timer;
var layer;
var clock=delay;
var score=0;

function show_question(){
	if (layer=eval("document.all.question"+q_num)){
		layer.style.display="inline";
		document.all.timeLeft.innerHTML=clock;
		hide_question();
	} else {
		document.all.timeLeft.innerHTML=0;
		document.all.quizScore.innerHTML="<h2>당신은 "+(q_num-1)+"문제중 "+score+"개를 맞췄습니다.</h2> <br>" +
											"<a href='answer'><h2>정답 보러 가기<h2></a>";
        
		document.all.quizScore.style.display="inline";
	}
}
/* function go_answer(){
	$(opener.window.location).attr("href","answer");
	 self.close(); 
} */
function hide_question(){
	if (clock>0) {
		document.all.timeLeft.innerHTML=clock;
		clock--;
		timer=setTimeout("hide_question()",1000);
	} else {
		clearTimeout(timer);
		document.all.answerBoard.innerHTML=" ";
		clock=delay;
		layer.style.display="none";
		q_num++;
		show_question();
	}
}

function check_answer(answer){
	if (correctAnswers[q_num-1]==answer){
		score++;
		document.all.answerBoard.innerHTML="<font color=blue size=16px;><b>정답입니다.</b></font>";
	} else {
		document.all.answerBoard.innerHTML="<font color=red size=16px;><b>땡! 틀렸습니다.</b></font>";
	}
	clock=0;
	clearTimeout(timer);
	timer=setTimeout("hide_question()",700);
}

window.onload=show_question;
</script>
<style>
article{padding: 50px ; margin: 10px auto;}
article a {padding: 10px ;margin: 0 auto;}
/* .widget h1{padding: 20px ; margin: 10px auto; text-align: center;} */
.widget h3 {padding: 10px ; margin: 10px auto;}
.widget b {padding: 10px ; margin: 10px auto;}
.widget a{padding: 10px ; margin: 10px auto;}
.widget {text-align: center; line-height:200%;}
#quizScore{text-align: center;}
quizScore a{text-align: center; padding: 10px 10px; margin: 0 auto; background-color: grey;}
</style>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>
<section>
	<div class="widget">
  		<h1>Quiz</h1>
			<br>
			제한시간 : <B><span id="timeLeft" style="color: red"></span></B> 초<br>
						<div id="answerBoard"> </div>
				<article>
				  	<div id="question1" style="display:none">
						<h3>1.다음 중 종류가 다른 한가지는?</h3>
				   			<b>힌트 : 바이젠 비어 </b><br>
							<a href="javascript:void(0)" onclick="check_answer('a')">a) 파울라너</a><br>
							<a href="javascript:void(0)" onclick="check_answer('b')">b) 바이엔슈테판</a><br>
							<a href="javascript:void(0)" onclick="check_answer('c')">c) 밀러</a><br>
							<a href="javascript:void(0)" onclick="check_answer('d')">d) 에딩거</a><br>
					</div>
					<div id="question2" style="display:none">
						<h3>2.다음 중 종류가 다른 한가지는?</h3>
							<b>힌트 : 라거</b><br>
							<a href="javascript:void(0)" onclick="check_answer('a')">a) 카스</a><br>
							<a href="javascript:void(0)" onclick="check_answer('b')">b) 버드와이저</a><br>
							<a href="javascript:void(0)" onclick="check_answer('c')">c) 아사히</a><br>
							<a href="javascript:void(0)" onclick="check_answer('d')">d) 블랑</a><br>
					</div>
				<div id="question3" style="display:none">
					<h3>3.다음 중 종류가 다른 한가지는?</h3>
						<b>만점 방지</b><br>
							<a href="javascript:void(0)" onclick="check_answer('a')">a) 보통 맥주보다 3배의 몰트가 필요하다고 해서 지어진 이름이다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('b')">b) 트라피스트 수도회에서 만들어 마시던 맥주이다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('c')">c) 트라피스트 맥주 인증을 받은 수도원은 전 세계 10개 뿐이다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('d')">d) 고유한 향과 맛을 즐기기 위해 레드와인 온도에서 마시는 것이 가장 좋다.</a><br>
				</div>
				<div id="question4" style="display:none">
					<h3>4.카스의 특징으로 틀린 것은?</h3>
						<b>힌트 없음</b><br>
							<a href="javascript:void(0)" onclick="check_answer('a')">a) 고든 램지가 비하한 맥주이다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('b')">b) 우리나라의 대표적인 라이트 라거이다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('c')">c) 1994년 5월에 진로가 미국의 쿠어스 맥주와 제휴한 '진로쿠어스맥주'에서 출시하였다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('d')">d) 비열처리공법으로 맥주의 신선하고 톡 쏘는 맛을 더욱 향상한 특징이 있다.</a><br>
				</div>
				<div id="question5" style="display:none">
					<h3>5. 맥주의 역사 중 틀린 것은?</h3>
						<b>힌트 : </b><br>
							<a href="javascript:void(0)" onclick="check_answer('a')">a) 맥주는 B.C 4000년경 중동 지방의 
																						수메르 민족이 최초로 제조하였던 것으로 알려져 있다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('b')">b) 현재와 같은 맥주 제조방법은 12세기경 벨기에 수도원에서 호프를
																						처음 사용하면서부터 시작되었다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('c')">c) 19세기에 파스퇴르에 의해 살균법이 개발됨으로써 오랫동안
																						보관할 수 있게 되었고, 이후 덴마크의 한센은 효모의 순수 배양법을
																						발명하여 맥주의 질을 한 차원 더 높였다.</a><br>
							<a href="javascript:void(0)" onclick="check_answer('d')">d) 80년대 이후 맥주 고유의 신선도를 유지하면서 장기 유통을 할 수 있는
																						첨단 비열처리 공법이 개발되면서 소비자들은 더욱 신선한 맥주를 
																						즐길 수 있게 되었다.</a><br>
				</div>
				</article> 
			
	</div>
<div id="quizScore" style="display:none">

</div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>