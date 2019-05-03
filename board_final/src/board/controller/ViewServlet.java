package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.vo.ReplyVo;

@WebServlet("/view")
public class ViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(req.getParameter("idx"));
		req.setAttribute("board", BoardServiceImpl.getInstance().selectByIdx(idx));
		req.setAttribute("replys", BoardServiceImpl.getInstance().replySelect(idx));
		req.getRequestDispatcher("board/view.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String writer = req.getParameter("writer");
		int idx = Integer.parseInt(req.getParameter("boardIdx"));
		String content = req.getParameter("content");
		
		ReplyVo vo = new ReplyVo();
		vo.setBoardIdx(idx);
		vo.setWriter(writer);
		vo.setContent(content);
		BoardServiceImpl.getInstance().replyInsert(vo);
		
		resp.sendRedirect("view?idx="+req.getParameter("boardIdx")+"#comment");
	}

}
