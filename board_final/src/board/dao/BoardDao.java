package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.vo.Board;
import board.vo.FileVo;
import board.vo.ReplyVo;
import common.DBManager;

public class BoardDao {
	
	private static BoardDao dao = new BoardDao();
	private Connection conn;
	private PreparedStatement pstmt;
	private	ResultSet rs;
	
	private BoardDao() {}
	public static BoardDao getInstance() {
		return dao;
	}
	public Board selectByIdx(int idx) {
		// TODO Auto-generated method stub
		Board vo = null;
		String sql = "SELECT IDX, TITLE, "
				+ "(select name from member_f m where m.idx=b.writer) WRITER, "
				+ "content, TO_CHAR(REGDATE, 'YYYY/MM/DD HH24:MI:SS') REGDATE, COUNT, RECO, writer as writeridx FROM BOARD_F b WHERE IDX = ?";
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) { // 행이 있을 때
				vo = new Board();
				int idx2 = 0;
				vo.setIdx(rs.getInt(++idx2));
				vo.setTitle(rs.getString(++idx2));
				vo.setWriter(rs.getString(++idx2));
				vo.setContent(rs.getString(++idx2));
				vo.setRegdate(rs.getString(++idx2));
				vo.setCount(rs.getInt(++idx2));
				vo.setReco(rs.getInt(++idx2));
				vo.setWriterIdx(rs.getInt(++idx2));
		} 
			sql = "UPDATE BOARD_f SET count = (SELECT count+1 FROM BOARD_f WHERE idx = ?) WHERE idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public List<Board> select(String cate) {
		// TODO Auto-generated method stub
		List<Board> list = new ArrayList<>();
		String sql = "SELECT IDX, TITLE, "
				+ "(select name from member_f m where m.idx=b.writer) writer ,"
				+ "  CASE WHEN SYSDATE-REGDATE < 1 THEN TO_CHAR(REGDATE, 'HH24:MI:SS') " + 
				"             WHEN SYSDATE-REGDATE >= 1 THEN TO_CHAR(REGDATE, 'YY/MM/DD') " + 
				"    END REGDATE, COUNT, RECO, category "
				+ " ,  (select count(*) from file_F F WHERE F.BOARD_IDX = B.IDX) AS F_COUNT "
				+ " ,  (select count(*) from COMMENT_F F WHERE F.BOARD_IDX = B.IDX) AS C_COUNT "
				+ " FROM BOARD_F b ";
				if(cate != null && !cate.equals("0")) {
					sql += " where category = " + cate;
					
				}
				sql += " ORDER BY 1 desc";
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { // 행이 있을 때
				Board vo = new Board();
				int idx = 0;
				vo.setIdx(rs.getInt(++idx));
				vo.setTitle(rs.getString(++idx));
				vo.setWriter(rs.getString(++idx));
				vo.setRegdate(rs.getString(++idx));
				vo.setCount(rs.getInt(++idx));
				vo.setReco(rs.getInt(++idx));
				vo.setCategory(rs.getInt(++idx));
				vo.setFileCount(rs.getInt(++idx));
				vo.setCommentCount(rs.getInt(++idx));
				
				list.add(vo);
		} 
			DBManager.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Board> select() {
		// TODO Auto-generated method stub
		String sqltemp = "select b.idx, b.title from " + 
					"    (select rownum num from all_objects where ROWNUM <=5) a " + 
					" left join " + 
					"    (select idx, rownum num, category , board_f.title from board_f) B " + 
					" on a.num = b.num ";
			String sql = sqltemp;
		for(int i = 0; i < 7 ; i++) {
				sql += " union all ";
				sql += sqltemp ;
				sql += " and b.category = " + i;
			}
			List<Board>list = new ArrayList<>();
			
			conn = DBManager.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) { // 행이 있을 때
					Board vo = new Board();
					int idx2 = 0;
					vo.setIdx(rs.getInt(++idx2));
					vo.setTitle(rs.getString(++idx2));
					
					list.add(vo);
			} 
				DBManager.close(conn, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}
	

	public void insert(Board vo, List<FileVo> list) {
		// TODO Auto-generated method stub
		String sql = "insert INTO BOARD_F(IDX, TITLE, CONTENT, WRITER) VALUES (BOARD_F_SEQ.NEXTVAL, ?, ?, ?)";
		
		conn = DBManager.getConnection();
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			pstmt.setString(++idx, vo.getTitle());
			pstmt.setString(++idx, vo.getContent());
			pstmt.setString(++idx, vo.getWriter());
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = conn.prepareStatement("SELECT MAX(IDX) FROM BOARD_F");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int boardIdx = rs.getInt(1);
			pstmt.close();
			
			sql = "INSERT INTO FILE_F VALUES(FILE_F_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			for(FileVo file : list ) {
				pstmt.setInt(1, boardIdx);
				pstmt.setString(2, file.getOrigin());
				pstmt.setString(3, file.getRealName());
				
				pstmt.executeUpdate();
			}
				conn.commit();
			DBManager.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Board vo) {
		// TODO Auto-generated method stub
		String sql = "UPDATE BOARD_F SET TITLE = ?, CONTENT = ?, REGDATE = SYSDATE WHERE IDX = ?";
		
		conn = DBManager.getConnection();
		try {
			rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			pstmt.setString(idx++, vo.getTitle());
			pstmt.setString(idx++, vo.getContent());
			pstmt.setString(idx++, vo.getRegdate());
			pstmt.setInt(idx++, vo.getIdx());
			pstmt.executeUpdate();
			
			DBManager.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int idx) {
		// TODO Auto-generated method stub
		String sql = "DELETE board_f WHERE idx=?";
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			DBManager.close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} 
	}
	
	public List<ReplyVo> replySelect(int boardIdx) {
		// TODO Auto-generated method stub
		List<ReplyVo> list = new ArrayList<>();
		String sql = "select idx, board_idx, content, "
				+ " (select name from member_f m where m.idx = c.writer) writer, "
				+ " CASE WHEN SYSDATE-REGDATE < 1 THEN TO_CHAR(REGDATE, 'HH24:MI') " +  
				"  WHEN SYSDATE-REGDATE >= 1 THEN TO_CHAR(REGDATE, 'YY/MM/DD') " + 
				"  END regdate ,"
				+ " writer as writerIdx "
				+ "from comment_f c where board_idx =? order by 1";
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardIdx);
			rs = pstmt.executeQuery();
			while(rs.next()) { // 행이 있을 때
				ReplyVo vo = new ReplyVo();
				int idx = 0;
				vo.setIdx(rs.getInt(++idx));
				vo.setBoardIdx(rs.getInt(++idx));
				vo.setContent(rs.getString(++idx));
				vo.setWriter(rs.getString(++idx));
				vo.setRegdate(rs.getString(++idx));
				vo.setWriterIdx(rs.getInt(++idx));
				list.add(vo);
		} 
			DBManager.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void replyInsert(ReplyVo vo) {
		// TODO Auto-generated method stub
				String sql = "insert into comment_f values(comment_f_seq.nextval, ? , ?, ?, sysdate)";
				
				conn = DBManager.getConnection();
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, vo.getBoardIdx());
					pstmt.setString(2, vo.getContent());
					pstmt.setString(3, vo.getWriter());
					pstmt.executeUpdate();
					
					DBManager.close(conn, pstmt, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void replyDelete(int idx) {
		// TODO Auto-generated method stub
		String sql = "delete comment_f where idx = ?";
		
		conn = DBManager.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,idx);
			pstmt.executeUpdate();
			
			DBManager.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteAll(int idx) {
		// TODO Auto-generated method stub
		String sql = "drop table board_f";
		
		conn = DBManager.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,idx);
			pstmt.executeUpdate();
			
			DBManager.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
