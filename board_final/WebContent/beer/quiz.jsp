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
/*  $( function() {
    $( "input" ).checkboxradio({
      icon: false
    });
  } );  */
 
 if (window.focus) self.focus(); 

//총 문제수 설정
var numQues = 3;

//아래에 각 문제의 정답과 순서
var answers = new Array(numQues)
answers[0] = "밀러";
answers[1] = "블랑";
answers[2] = "트라피스트 맥주 인증을 받은 수도원은 전 세계 10개 뿐이다.";
/* answers[3] = "문제 1 번 정답";
answers[4] = "문제 1 번 정답";
answers[5] = "문제 1 번 정답";
answers[6] = "문제 1 번 정답";
answers[7] = "문제 1 번 정답";
answers[8] = "문제 1 번 정답";
answers[9] = "문제 1 번 정답"; */

function getScore(form) {
 var score = 0;
 var currElt;
 var currSelection;

 for (i=0; i<numQues; i++) {
   currElt = form.elements[i];
   currSelection = currElt.selectedIndex;
   if (currElt.options[currSelection].value == answers[i]) {
     score++;
   }
 }
//**스코어 계산 (문항수에 따라 계산식 수정 필요
 score = Math.round(score*3*10);
 form.yourscore.value = score +"점";

 var correctAnswers = "";
 for (i=1; i<=numQues; i++) {
   correctAnswers += i +  answers[i-1] + "\r\n";
 }
 form.solutions.value = correctAnswers;
}

</script>
<script type="text/javascript">
function check(val){ //crabz

    if(document.quiz1.elements[3].checked == true){ // 두번째 값에 체크가 되있으면
  alert('정답입니다.');
        //window.open('good.htm','',''); //다음문제나 정답페이지로 이동 
        // good.htm 정답페이지나 다음문제.

    }else{
  alert('틀렸습니다.');
        //location.href='wrong.htm'; //오답페이지로 이동
        // wrong.htm 오답페이지
    } 
    if(document.quiz2.elements[4].checked == true){ // 두번째 값에 체크가 되있으면
  alert('정답입니다.');
        //window.open('good.htm','',''); //다음문제나 정답페이지로 이동 
        // good.htm 정답페이지나 다음문제.

    }else{
  alert('틀렸습니다.');
        //location.href='wrong.htm'; //오답페이지로 이동
        // wrong.htm 오답페이지
    } 
    if(document.quiz3.elements[3].checked == true){ // 두번째 값에 체크가 되있으면
  alert('정답입니다.');
        //window.open('good.htm','',''); //다음문제나 정답페이지로 이동 
        // good.htm 정답페이지나 다음문제.

    }else{
  alert('틀렸습니다.');
        //location.href='wrong.htm'; //오답페이지로 이동
        // wrong.htm 오답페이지
    } 
}
</script>
<style>
article{padding: 20px ; margin: 10px auto;}
article p {padding: 10px ;margin: 0 auto;}
.widget h1{padding: 20px ; margin: 10px auto;}
.widget legend {padding: 10px ; margin: 0 auto;}
.widget input{padding: 10px ; margin: 0 auto;}
</style>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>
<section>
	<div class="widget">
  		<h1>Quiz</h1>
			<br>
			<form name="quiz1">
				<article>
				<h4>다음 중 종류가 다른 한가지는?</h4>
					<fieldset>
					    <legend>힌트 : 바이젠 비어 </legend>
					    <input type="radio" name="radio-1" id="radio-1">파울라너
					    <!-- <label for="radio-1"></label> -->
					    <input type="radio" name="radio-1" id="radio-2">바이엔슈테판
					    <!-- <label for="radio-2"></label> -->
					    <input type="radio" name="radio-1" id="radio-3">밀러
					   <!--  <label for="radio-3"></label> -->
					    <input type="radio" name="radio-1" id="radio-4">에딩거
					    <!-- <label for="radio-4"></label> -->
					</fieldset>
				</article>
			</form>
			<form name="quiz2">	 
				<article>
				<h4>다음 중 종류가 다른 한가지는?</h4>
					<fieldset>
					    <legend>힌트 : 라거 </legend>
					    <input type="radio" name="radio-1" id="radio-1">
					    <label for="radio-1">카스</label>
					    <input type="radio" name="radio-1" id="radio-2">
					    <label for="radio-2">버드와이저</label>
					    <input type="radio" name="radio-1" id="radio-3">
					    <label for="radio-3">아사히</label>
					    <input type="radio" name="radio-1" id="radio-4">
					    <label for="radio-4">블랑</label>
					  </fieldset>
				</article> 
			</form>
			<form name="quiz3">		
				<article>
				<h4>트라피스트에 대한 설명으로 옳지 않은 것은?</h4>
					<fieldset>
					    <legend>만점 방지용 문제: </legend>
					    <input type="radio" name="radio-1" id="radio-1">
					    <label for="radio-1">보통 맥주보다 3배의 몰트가 필요하다고 해서 지어진 이름이다.</label>
					    <input type="radio" name="radio-1" id="radio-2">
					    <label for="radio-2">트라피스트 수도회에서 만들어 마시던 맥주이다.</label>
					    <input type="radio" name="radio-1" id="radio-3">
					    <label for="radio-3">트라피스트 맥주 인증을 받은 수도원은 전 세계 10개 뿐이다.</label>
					    <input type="radio" name="radio-1" id="radio-4">
					    <label for="radio-4">고유한 향과 맛을 즐기기 위해 레드와인 온도에서 마시는 것이 가장 좋다.</label>
					</fieldset>
				</article> 
			</form>


<table width="50" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td><a href= "javascript:check();" >정답</a></td>
  </tr>
</table>
</div>
	
	
	
	
	
<tr><td colspan=2><font face="Arial, Helvetica" size=-1>
<b><INPUT TYPE="button" value="내 점수" onClick="getScore(this.form)">
<INPUT TYPE="reset" value="다시시작"></b>
<p>

<b>당신의 득점율은 ▶ =</b> <INPUT TYPE=text SIZE=15 name="yourscore"><br>
<b>퀴즈정답 :</b><br>
<TEXTAREA name="solutions" WRAP="virtual" ROWS="4" COLS="40"></TEXTAREA>
</td></tr>
</table>
	
	
	
	
	

</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>