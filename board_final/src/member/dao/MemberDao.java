package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBManager;
import member.vo.Member;

public class MemberDao {
	
	private static MemberDao dao = new MemberDao();
	private PreparedStatement pstmt;
	private	ResultSet rs;
	private Connection conn;
	private MemberDao() {}
	public static MemberDao getInstance() {
		return dao;
	}
	
	public Member login(String email, String pw) {
		Member vo = null;
		String sql = "SELECT idx, email, name , admin FROM MEMBER_f WHERE email = ? and pw =?";
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, common.SecurityUtil.encryptSHA256(pw));
			rs = pstmt.executeQuery();
			if(rs.next()) { // 행이 있을 때
				vo = new Member();
				int idx = 0;
				vo.setIdx(rs.getInt(++idx));
				vo.setEmail(rs.getString(++idx));
				vo.setName(rs.getString(++idx));
				vo.setAdmin(rs.getBoolean(++idx));
				
		} 
			DBManager.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public void join(Member vo) {
		String sql = "insert into member_f VALUES (member_f_seq.nextval, ?, ?, ?,0)";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			int idx=0;
			pstmt.setString(++idx, vo.getEmail());
			pstmt.setString(++idx, common.SecurityUtil.encryptSHA256(vo.getPw()));
			pstmt.setString(++idx, vo.getName());
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modify(Member vo) {
		// TODO Auto-generated method stub
		String sql = "update member_f set email=?, pw=?, name=? where idx=?";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			int idx=0;
			pstmt.setString(++idx, vo.getEmail());
			pstmt.setString(++idx, vo.getPw());
			pstmt.setString(++idx, vo.getName());
			pstmt.setInt(++idx, vo.getIdx());
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void resign(String email) {
		// TODO Auto-generated method stub
		String sql = "DELETE member_f WHERE email=?";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			int idx=0;
			pstmt.setString(++idx, email);
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isMember(String email) {
		String sql = "SELECT EMAIL, NAME, PW FROM MEMBER_F WHERE EMAIL = ?";
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,email);
			
			rs = pstmt.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
