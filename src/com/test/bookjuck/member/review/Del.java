package com.test.bookjuck.member.review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.ReviewDAO;

@WebServlet("/member/review/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 쿼리스트링으로 넘어온 seq를 이용해서
		// 삭제
		
		String seq=req.getParameter("seq");
		
		ReviewDAO dao=new ReviewDAO();
		
		int result=dao.del(seq);
		
		if (result==1) {
			// 독후감 삭제 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/member/review/list.do");
		} else {
			// 독후감 삭제 실패 -> 경고 + 뒤로 가기
			PrintWriter writer=resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			return;
			
		}
	}

}