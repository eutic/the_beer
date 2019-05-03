function loginCheck(){
	if(document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value.length == "") {
		alert("비밀번호는 반드시 입력해야합니다");
		frm.pwd.focus();
		return false;
	}
}


function idCheck(){
	if(document.frm.userid.value ==''){
		alert("아이디를 입력해주세요");
		document.frm.userid.focus();
		return false;
	}
	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url,"", "width=450,height=200");
}


function idok(){
	opener.document.frm.userid.value = document.frm.userid.value;
	opener.document.frm.reid.value = document.frm.userid.value;
	self.close();
}


function joinCheck(){

	if(document.frm.email.value.length < 4) {
		alert("아이디는 4글자 이상이어야 합니다.");
		frm.email.focus();
		return false;
	}
	if(document.frm.pw.value =="") {
		alert("비밀번호는 반드시 입력해야 합니다.");
		frm.pw.focus();
		return false;
	}
	if(document.frm.pw.value != document.frm.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		frm.pw.focus();
		return false;
	}
/*	if(document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}*/
}

function updateCheck(){
	if(document.frm.name.value.length == 0) {
		alert("이름을 써주세요");
		frm.name.focus();
		return false;
	}
	if(document.frm.pwd.value =="") {
		alert("비밀번호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}

}