package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("list", BoardServiceImpl.getInstance().select(req.getParameter("cate")));
		req.getRequestDispatcher("board/list.jsp").forward(req, resp);
		/*BoardServiceImpl.getInstance().select().forEach(action);*/
	}

}
