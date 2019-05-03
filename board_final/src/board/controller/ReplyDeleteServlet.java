package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;

@WebServlet("/replyDelete")
public class ReplyDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(req.getParameter("idx"));
		BoardServiceImpl.getInstance().replyDelete(idx);
		resp.sendRedirect("view?idx="+req.getParameter("boardIdx")+"#comment");
	}
	
}
