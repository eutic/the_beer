<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>file_name::2019. 4. 19.</title>
<script language=javascript>
function check(val){ //crabz

    if(document.form1.elements[1].checked == true){ // 두번째 값에 체크가 되있으면
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
</head>
<body>
<form name="form1" method="post" action="">
  <table width="300" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr><td>다음 중 과일은?</td></tr>
  <tr>
    <td>
        <input type="radio" name="radiobutton" value="right">1. 당근 
        <input type="radio" name="radiobutton" value="right">2. 사과
        <input type="radio" name="radiobutton" value="right">3. 배추
        <input type="radio" name="radiobutton" value="right">4. 무 
      </td>
  </tr>
</table>
</form>
<table width="50" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td><a href= "javascript:check();" >정답</a></td>
  </tr>
</table>
</body>
</html>