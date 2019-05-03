package member.service;

import member.vo.Member;

public interface MemberService {

//	 - 로그인
	public abstract Member login(String email, String pw);
	
//	 - 로그아웃(DAO 미사용)
	void logout();
	
//	 - 회원가입
	void join(Member vo);
	
//	 - 정보수정
	void modify(Member vo);
	
//	 - 회원탈퇴
	void resign(String email);
	
	boolean isMember(String email);
}
