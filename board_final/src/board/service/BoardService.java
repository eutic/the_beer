package board.service;

import java.util.List;

import board.vo.Board;
import board.vo.FileVo;
import board.vo.ReplyVo;

public interface BoardService {
	// CRUD
	
	// 글작성
	// 글삭제
	// 수정
	
	Board selectByIdx(int idx);
	List<Board> select(String cate);
	void insert(Board vo, List<FileVo> list);
	void update(Board vo);
	void delete(int idx);
	
	List<ReplyVo> replySelect(int boardIdx);
	void replyInsert(ReplyVo vo);
	void replyDelete(int idx);
	List<Board> select();
}
