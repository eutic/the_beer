<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="css/main.css" rel="stylesheet">
<link href="images/favicon.ico" rel="icon">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

</script>
<script>
$(function(){
	//$("#isMember").click(function(){
	$("#email").keyup(function(){	
		if($(this).val().length < 5) {
			$("#text").html("아이디가 4글자 이하입니다").addClass("red");	
		
		}
		else {
			$.ajax("isMember?id=" + $("#email").val(), {
				type : "post",
				success : function(data){
					if(data.trim()-0) {
						$("#text").html("이미 가입된 회원입니다.").addClass("red");
					} 
					else{
						$("#text").html("가입 가능한 아이디입니다.").removeClass();
					}
				}
			});
		}
	})
	$("#pw").keyup(function(){
		if($(this).val().length < 7){
			$("#text2").html("비밀번호가 6글자 이하입니다.").addClass("red");
		} else {
			$("#text2").html("").removeClass();
		}
	});
	$("#pw_check").keyup(function(){
		if($(this).val() != $("#pw").val()){
			$("#text3").html("비밀번호가 일치하지 않습니다.").addClass("red");
		} else {
			$("#text3").html("").removeClass();
		}
	});
	
	
});
</script>
<style>
	  .red{color:red;}
      * {box-sizing: border-box}
      input[type=text], input[type=password] {width: 99%; padding: 15px; margin: 5px 0 7px 0; display: inline-block; border: none;background: #f1f1f1; }
      input[type=text]:focus, input[type=password]:focus {background-color: #ddd;outline: none;}
      button {background-color: black; color: white; padding: 14px 20px; margin: 8px 0; border: none; cursor: pointer; width: 75.5%; opacity: 0.9; }
      button:hover { opacity:1; }
      .cancelbtn { padding: 14px 20px; background-color: darkred; }
      .cancelbtn, .signupbtn { float: left; width: 50%; }
      .container { padding: 16px;}
      .modal { display: none; position: fixed;  z-index: 1; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: darkgray; padding-top: 50px; }
      .modal-content { background-color: #fefefe; margin: 5% auto 15% auto; border: 1px solid #888; width: 80%; }
      hr { border: 1px solid #f1f1f1; margin-bottom: 25px; }
      .close { position: absolute; right: 35px; top: 15px; font-size: 40px; font-weight: bold; color: #f1f1f1; }
      .close:hover, .close:focus { color: red; cursor: pointer; }
      .clearfix::after { content: ""; clear: both; display: table; }
      @media screen and (max-width: 300px) { 
      	.cancelbtn, .signupbtn {  width: 100%; } }
      a {color: white;}
      .img{text-align: center;}
      h1 {padding: 10px 10px; margin: 0 auto;}
      p {padding: 10px 10px; margin: 0 auto;}
      label b{text-align: left;}
      .container span { margin-bottom: 10px;}
    </style>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>
<section class="img">

	  <h1>회원 가입</h1>
	  <!-- <p>The Beer의 방문을 환영합니다.</p> -->
	<img alt="signup" src="images/4.jpg" >
	<button onclick="document.getElementById('id01').style.display='block'">가입</button>
</section>
<section>
	<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">닫기</span>
  <form class="modal-content" method="post" name="frm" >
    <div class="container">
      <p>빈 항목들을 채워주세요.</p>
      <hr>
      <label for="email"><b>이메일</b></label>
      <input type="text" placeholder="이메일을 입력해주세요"  name="email" class="email" id="email" required>
      <span id="text"></span>
      <br>
      <label for="pw"><b>비밀번호</b></label>
      <input type="password" placeholder="비밀번호를 입력해주세요" name="pw" id="pw" required>
      <span id="text2"></span>
      <br>
      <label for="pw_check"><b>비밀번호 확인</b></label>
      <input type="password" placeholder="비밀번호를 입력해주세요" name="pw_check" id="pw_check" required>
      <span id="text3"></span>
      <br>
      <label for="name"><b>이름</b></label>
      <input type="text" placeholder="이름" name="name" id="name" required>
      
      <label>
        <input type="checkbox" checked="checked" name="agree" style="margin-bottom:15px"> 약관동의
      </label>

      <p>이용 약관 동의 시 가입 가능합니다. <a href="#" style="color:navy">이용 약관</a></p>

      <div class="clearfix">
        <a href="index">
        	<button onclick="return confirm('돌아가시겠습니까?')" class="cancelbtn">취소</button>
        </a>
        <button type="submit" class="signupbtn" onsubmit="return joinCheck()">가입</button>
      </div>
    </div>
  </form>
</div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>