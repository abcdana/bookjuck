package com.test.bookjuck.admin.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.AuthorDAO;
import com.test.bookjuck.dao.BookDAO;
import com.test.bookjuck.dao.CategoryDAO;
import com.test.bookjuck.dto.AuthorDTO;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.CategoryDTO;


@WebServlet("/admin/book/bookedit.do")
public class BookEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(seqSCategory)
		//2. DB 작업 -> select
		//3. 결과 + JSP 호출
		
		//1.
		String seq = req.getParameter("seq");
		String page = req.getParameter("page");
		
		//2.
		BookDAO dao = new BookDAO();
		BookDTO dto = dao.getAdminBookDetail(seq);
		
		//모달에 필요한 데이터 넘기기
		
		//1. 카테고리별 번호, 카테고리명
		CategoryDAO cdao = new CategoryDAO();
		ArrayList<CategoryDTO> lCategoryList = cdao.getLCategoryList();
		ArrayList<CategoryDTO> mCategoryList = cdao.getMCategoryList();
		ArrayList<CategoryDTO> sCategoryList = cdao.getSCategoryList();
		
		//2. 작가번호, 작가명, 작가소개
		AuthorDAO adao = new AuthorDAO();
		ArrayList<AuthorDTO> alist = adao.getAuthorList();
		
		//2.3 작가소개 엔터 변환
		for (AuthorDTO adto : alist) {
			adto.setIntro(adto.getIntro().replace("\r\n", "<br>"));
			adto.setIntro(adto.getIntro().replace("\n", "<br>"));
		}
		
		
		//편의
		
		//날짜 데이터 자르기 -> 시간 삭제
		dto.setPubDate(dto.getPubDate().substring(0, 10));
		
		
		cdao.close();
		adao.close();

		dao.close();
		
		req.setAttribute("lCategoryList", lCategoryList);
		req.setAttribute("mCategoryList", mCategoryList);
		req.setAttribute("sCategoryList", sCategoryList);
		req.setAttribute("alist", alist);
		
		req.setAttribute("dto", dto);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/book/bookedit.jsp");
		dispatcher.forward(req, resp);
	}
	
}