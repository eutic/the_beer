package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberServiceImpl;
import member.vo.Member;
@WebServlet("/modify")
public class ModifyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("member/modify.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer idx = Integer.valueOf(req.getParameter("idx"));
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		Member vo = new Member();
		vo.setIdx(idx);
		vo.setEmail(email);
		vo.setPw(pw);
		vo.setName(name);
		MemberServiceImpl.getInstance().modify(vo);
		req.getSession().setAttribute("member", vo);
		
		resp.sendRedirect("modify");
	}
}
