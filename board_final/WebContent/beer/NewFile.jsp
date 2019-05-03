<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>file_name::2019. 4. 19.</title>
<script language="JavaScript">

if (window.focus) self.focus(); 

//총 문제수를 설정합니다(예제는 5문제)
var numQues = 5;

//★아래에 각 문제의 정답을 순서대로 나열해 넣습니다
var answers = new Array(numQues)
answers[0] = "사이버 휴게소";
answers[1] = "최 우환";
answers[2] = "문제 1 번 정답";
answers[3] = "문제 1 번 정답";
answers[4] = "문제 1 번 정답";

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
 //**스코어 계산(문항수에 따라 계산식을 수정하세요(하단 가이드 참조) **//
  score = Math.round(score*2*10);
  form.yourscore.value = score +"점";

  var correctAnswers = "";
  for (i=1; i<=numQues; i++) {
    correctAnswers += i +  answers[i-1] + "\r\n";
  }
  form.solutions.value = correctAnswers;
}

</script>

</head>
<body>
<table border=0 cellpadding=5 cellspacing=0>
<tr><td colspan=2><br><br><br><font face="Arial, Helvetica" size=-1>
</font><hr color=red></td></tr>

<FORM name="quiz">
<tr><td><font face="Arial, Helvetica" size=-1>
<b>1.</b> 지금 방문하신 이 카페 이름은 몰까요 ?
</font></td>
<td><font face="Arial, Helvetica" size=-1>
<SELECT name="q1">
<OPTION value="">선택 하세요
<OPTION value="사이버 휴게소">사이버 휴게소
<OPTION value="인터넷 휴게소">인터넷 휴게소
<OPTION value="언양 휴게소">언양 휴게소
<OPTION value="오대산 휴게소">오대산 휴게소

</SELECT>
</font></td></tr>

<tr><td><font face="Arial, Helvetica" size=-1>
<b>2.</b> 휴게소 쥔장 이름은 ?
</font></td>
<td><font face="Arial, Helvetica" size=-1>
<SELECT name="q2">
<OPTION value="">선택 하세요
<OPTION value="김 대중">김 대중
<OPTION value="김 혜수">김 혜수
<OPTION value="최 우환">최 우환
<OPTION value="전 지현">전 지현
</SELECT>
</font></td></tr>

<tr><td><font face="Arial, Helvetica" size=-1>
<b>3.</b> 휴게소 첫 느낌은 ?
</font></td>
<td><font face="Arial, Helvetica" size=-1>
<SELECT name="q3">
<OPTION value="">선택 하세요
<OPTION value="별로다">별로다
<OPTION value="느낌같은것 안 키운다">느낌같은것 안 키운다
<OPTION value="넘 조아 죽겠다">넘 조아 죽겠다
<OPTION value="모르겠다">모르겠다
</SELECT>
</font></td></tr>

<tr><td><font face="Arial, Helvetica" size=-1>
<b>4.</b> 운영자 상판때기는 ?
</font></td>
<td><font face="Arial, Helvetica" size=-1>
<SELECT name="q4">
<OPTION value="">선택 하세요
<OPTION value="잘 생겼다">잘 생겼다
<OPTION value="슬프다">슬프다
<OPTION value="배고프게 생겼다">배고프게 생겼다
<OPTION value="묻지마 짜증난다">묻지마 짜증난다
</SELECT>
</font></td></tr>

<tr><td><font face="Arial, Helvetica" size=-1>
<b>5.</b> 운영자 성격은 어떨까 ?
</font></td>
<td><font face="Arial, Helvetica" size=-1>
<SELECT name="q5">
<OPTION value="">선택 하세요
<OPTION value="착하고 순진덩어리다">착하고 순진덩어리다
<OPTION value="얍샵하다">얍샵하다
<OPTION value="드럽다">드럽다
<OPTION value="묻지마 짜증난다">묻지마 짜증난다
</SELECT>
</font></td></tr>
<tr><td colspan=2><font face="Arial, Helvetica" size=-1>
<b><INPUT TYPE="button" value="내 점수" onClick="getScore(this.form)">
<INPUT TYPE="reset" value="다시시작"></b>
<p>

<b>당신의 득점율은 ▶ =</b> <INPUT TYPE=text SIZE=15 name="yourscore"><br>
<b>퀴즈정답 :</b><br>
<TEXTAREA name="solutions" WRAP="virtual" ROWS="4" COLS="40"></TEXTAREA>
</td></tr>
</table>
</FORM>
</body>
</html>