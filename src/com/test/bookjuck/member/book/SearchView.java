package com.test.bookjuck.member.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/book/searchview.do")
public class SearchView extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String sv = req.getParameter("sv"); //검색창 입력값
		String sk = req.getParameter("sk");	//검색 카테고리 입력값
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		if (!(sv == null || sv.equals(""))) {
			map.put("sv", sv);
			map.put("sk", sk);		
		}
		
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		if (!(sv == null || sv.equals(""))) {
			BookDAO dao = new BookDAO();
			list = dao.list(map);
			System.out.println(list);
		
		  for (BookDTO dto : list) {//선생님 sv검색창 입력값이 if문에 걸려 해쉬맵에 put이 안되어 null값이 발생하는 것같은데..
			  						//(검색어 입력안하고 검색버튼 누를시 검색값이 안뜨게 하기위함)
			  						//아래와 같이 dto 서브스트링을 적용하려면 어떻게 해야할까요?
		  
		  //날짜에서 시간 잘라내기 
		  dto.setPubdate(dto.getPubdate().substring(0,10));
		  
		  //제목, 카피 너무 길면 자르기 
		  if (dto.getTitle().length() > 30) {
			  dto.setTitle(dto.getTitle().substring(0, 30) + ".."); }
		  
		  if (dto.getCopy().length() > 40) {
			  dto.setCopy(dto.getCopy().substring(0, 40) + ".."); }
		  
		  }
		
		
		
		req.setAttribute("sk", sk);
		req.setAttribute("sv", sv);
		
		}
		req.setAttribute("list", list);//***
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/book/searchview.jsp");
		dispatcher.forward(req, resp);

	}

}
