package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.service.BoardServiceImpl;
import board.vo.Board;
import board.vo.FileVo;
import member.vo.Member;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if(session.getAttribute("member") == null) {
			resp.sendRedirect("index.html");
		}
		else {req.getRequestDispatcher("board/write.jsp").forward(req, resp);}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("member") == null) {
			resp.sendRedirect("index.html");
		}
		
		MultipartRequest multi = new MultipartRequest(req, getServletContext().getRealPath("/upload"), 5 * 1024 * 1024,
				"utf-8", new DefaultFileRenamePolicy());
		// 작업1
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		String writer = ((Member)session.getAttribute("member")).getIdx()+"";
		
		Board vo = new Board();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
	
		
		// 작업2
		List<FileVo> list = new ArrayList<>();
		
		for(int i = 1; i <= 3; i++) {
			String origin = multi.getOriginalFileName("file"+i);
			String real = multi.getFilesystemName("file"+i);
			if(!(origin == null || real == null)) {
				list.add(new FileVo(origin, real));
			}
			
		}
		
		System.out.println(vo);
		System.out.println(list);
		BoardServiceImpl.getInstance().insert(vo, list);
		resp.sendRedirect("list");
	}
}
