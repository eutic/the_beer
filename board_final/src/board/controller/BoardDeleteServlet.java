package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;

@WebServlet("/remove")
public class BoardDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(req.getParameter("idx"));
		BoardServiceImpl.getInstance().delete(idx);
		resp.sendRedirect("list");
		
	
	}
}
