package common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;

@WebServlet("/index.html")
public class Index extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String [] bbs = {"HOME", "History", "Ale", "Lager" , "Beer Map", "Quiz", "자유게시판", "답글형"    };
		req.setAttribute("list", BoardServiceImpl.getInstance().select());
		req.setAttribute("bbs", bbs);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
 
}
