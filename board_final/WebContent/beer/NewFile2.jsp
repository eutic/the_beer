<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Quiz</title>
<script>
var delay=10; //시간설정
var correctAnswers=new Array("a","b","c","d","e");  //정답

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
		document.all.quizScore.innerHTML="당신은 "+(q_num-1)+"문제중 "+score+"개를 맞췄습니다.";
		document.all.quizScore.style.display="inline";
	}
}

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
		document.all.answerBoard.innerHTML="<font color=blue><b>정답입니다.</b></font>";
	} else {
		document.all.answerBoard.innerHTML="<font color=red><b>땡! 틀렸습니다.</b></font>";
	}
	clock=0;
	clearTimeout(timer);
	timer=setTimeout("hide_question()",700);
}

window.onload=show_question;
</script>
</head>
<body>

제한시간 : <B><span id="timeLeft"></span></B> 초<br>
<br>
<div id="answerBoard"> </div>
<br>

<div id="question1" style="display:none">
	<b>1. 블루비 운영진과 닮은 연예인은 ?</b><br>
	<a href="javascript:void(0)" onclick="check_answer('a')">a) 장동건</a><br>
	<a href="javascript:void(0)" onclick="check_answer('b')">b) 마빡이</a><br>
	<a href="javascript:void(0)" onclick="check_answer('c')">c) 강호동</a><br>
	<a href="javascript:void(0)" onclick="check_answer('d')">d) 영구</a><br>
</div>

<div id="question2" style="display:none">
<b>2. 다음중 광역시가 아닌곳은?</b><br>
<a href="javascript:void(0)" onclick="check_answer('a')">a) 전주</a><br>
<a href="javascript:void(0)" onclick="check_answer('b')">b) 광주</a><br>
<a href="javascript:void(0)" onclick="check_answer('c')">c) 울산</a><br>
<a href="javascript:void(0)" onclick="check_answer('d')">d) 인천</a><br>
</div>

<div id="question3" style="display:none">
<b>3. 블루비 도메인이 아닌것은?</b><br>
<a href="javascript:void(0)" onclick="check_answer('a')">a) www.naver.com</a><br>
<a href="javascript:void(0)" onclick="check_answer('b')">b) www.blueb.co.kr</a><br>
<a href="javascript:void(0)" onclick="check_answer('c')">c) blueb.co.kr</a><br>
<a href="javascript:void(0)" onclick="check_answer('d')">d) blueb.kr</a><br>
</div>

<div id="question4" style="display:none">
<b>4. 블루비에서 제공하는 포인트 이름은 ?</b><br>
<a href="javascript:void(0)" onclick="check_answer('a')">a) 루비</a><br>
<a href="javascript:void(0)" onclick="check_answer('b')">b) 다이아몬드</a><br>
<a href="javascript:void(0)" onclick="check_answer('c')">c) 아덴</a><br>
<a href="javascript:void(0)" onclick="check_answer('d')">d) 도토리</a><br>
</div>

<div id="question5" style="display:none">
<b>5. 블루비를 설명한 것 중 맞는것은?</b><br>
<a href="javascript:void(0)" onclick="check_answer('a')">a) 웹개발자를 위한 사이트</a><br>
<a href="javascript:void(0)" onclick="check_answer('b')">b) 성인사이트</a><br>
<a href="javascript:void(0)" onclick="check_answer('c')">c) 게임사이트</a><br>
<a href="javascript:void(0)" onclick="check_answer('d')">d) 쇼핑몰</a><br>
</div>

<div id="quizScore" style="display:none">
</div>

</body>
</html>