package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberServiceImpl implements MemberService {

	static MemberService service = new MemberServiceImpl();
	public MemberServiceImpl() {}
	public static MemberService getInstance() {
		return service;
	}
	
	@Override
	public Member login(String email, String pw) {
		// TODO Auto-generated method stub
		return MemberDao.getInstance().login(email, pw);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void join(Member vo) {
		// TODO Auto-generated method stub
		MemberDao.getInstance().join(vo);
	}

	@Override
	public void modify(Member vo) {
		// TODO Auto-generated method stub
		MemberDao.getInstance().modify(vo);
	}

	@Override
	public void resign(String email) {
		// TODO Auto-generated method stub
		MemberDao.getInstance().resign(email);
	}
	@Override
	public boolean isMember(String email) {
		// TODO Auto-generated method stub
		return MemberDao.getInstance().isMember(email);
	}

}
