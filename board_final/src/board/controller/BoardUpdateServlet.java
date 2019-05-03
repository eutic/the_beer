package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;

@WebServlet("/update")
public class BoardUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(req.getParameter("idx"));
		req.setAttribute("board", BoardServiceImpl.getInstance().selectByIdx(idx));
		req.getRequestDispatcher("board/update.jsp").forward(req, resp);
		
	}

}
