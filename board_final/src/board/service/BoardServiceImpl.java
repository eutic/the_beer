package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.vo.Board;
import board.vo.FileVo;
import board.vo.ReplyVo;

public class BoardServiceImpl implements BoardService {

	static BoardService service = new BoardServiceImpl();
	private BoardServiceImpl() {}
	public static BoardService getInstance() {
		return service;
	}
	@Override
	public Board selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return BoardDao.getInstance().selectByIdx(idx);
	}

	@Override
	public List<Board> select(String cate) {
		// TODO Auto-generated method stub
		return BoardDao.getInstance().select(cate);
	}
	

	@Override
	public List<Board> select() {
		// TODO Auto-generated method stub
		return BoardDao.getInstance().select();
	}
	@Override
	public void insert(Board vo, List<FileVo> list) {
		// TODO Auto-generated method stub
		BoardDao.getInstance().insert(vo, list);
	}

	@Override
	public void update(Board vo) {
		// TODO Auto-generated method stub
		BoardDao.getInstance().update(vo);
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		BoardDao.getInstance().delete(idx);
	}
	@Override
	public List<ReplyVo> replySelect(int boardIdx) {
		// TODO Auto-generated method stub
		return BoardDao.getInstance().replySelect(boardIdx);
	}
	@Override
	public void replyInsert(ReplyVo vo) {
		// TODO Auto-generated method stub
		BoardDao.getInstance().replyInsert(vo);
	}
	@Override
	public void replyDelete(int idx) {
		// TODO Auto-generated method stub
		BoardDao.getInstance().replyDelete(idx);
	}

	
	
}
