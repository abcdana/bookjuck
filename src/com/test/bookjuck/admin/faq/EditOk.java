package com.test.bookjuck.admin.faq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.FAQDAO;
import com.test.bookjuck.dto.FAQDTO;

@WebServlet("/admin/faq/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩!
		req.setCharacterEncoding("UTF-8");
		
		String seq=req.getParameter("seq");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String qCategory=req.getParameter("qcategory");
		
		FAQDAO dao=new FAQDAO();
		FAQDTO dto=new FAQDTO();
		
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setqCategory(qCategory);
		
		int result=dao.edit(dto);
		
		if (result==1) {
			// 자주하는 질문 수정 성공 -> 게시판 목록으로 이동
			resp.sendRedirect("/bookjuck/admin/faq/list.do");
		} else {
			// 자주하는 질문 실패 -> 경고 + 뒤로 가기
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