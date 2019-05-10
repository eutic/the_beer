package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import board.service.BoardServiceImpl;
import board.vo.Board;
import member.vo.Member;

@WebServlet("/update")
public class BoardUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(req.getParameter("idx"));
		req.setAttribute("board", BoardServiceImpl.getInstance().selectByIdx(idx));
		req.getRequestDispatcher("board/update.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(req.getParameter("idx"));
		if(req.getSession() != null && req.getSession().getAttribute("member")!= null) {
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			Board vo = new Board();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setIdx(idx);
			
		//	new BoardServiceImpl().update(vo);
			BoardServiceImpl.getInstance().update(vo);
		}
			resp.sendRedirect("view?idx="+idx);
	}

}
