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

import com.test.bookjuck.dtosave.BookDTO;

@WebServlet("/member/book/newbook.do")
public class NewBook extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String yearStart = req.getParameter("yearStart");
		String monthStart = req.getParameter("monthStart");
		String dayStart = req.getParameter("dayStart");
		
		
		String yearEnd = req.getParameter("yearEnd");
		String monthEnd = req.getParameter("monthEnd");
		String dayEnd = req.getParameter("dayEnd");
		
		
		//System.out.println(yearStart + monthStart + dayStart);
		
		//System.out.println(yearEnd + monthEnd + dayEnd);
		
		HashMap<String,String> map = new HashMap<String,String>();
		/*
		if (!(yearStart == null || yearStart.equals("")) 
			&& (monthStart == null || monthStart.equals(""))
			&& (dayStart == null || dayStart.equals(""))
			&& (yearEnd == null || yearEnd.equals(""))
			&& (monthEnd == null || monthEnd.equals(""))
			&& (dayEnd == null || dayEnd.equals("")))  
		{
		
		}
		*/
			map.put("yearStart", yearStart);
			map.put("monthStart", monthStart);
			map.put("dayStart", dayStart);
			map.put("yearEnd", yearEnd);
			map.put("monthEnd", monthEnd);
			map.put("dayEnd", dayEnd);
								
		
		System.out.println(map.get("yearStart"));
		System.out.println(map.get("yearEnd"));
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		if (!(yearStart == null || yearStart.equals("")) 
				&& !(monthStart == null || monthStart.equals(""))
				&& !(dayStart == null || dayStart.equals(""))
				&& !(yearEnd == null || yearEnd.equals(""))
				&& !(monthEnd == null || monthEnd.equals(""))
				&& !(dayEnd == null || dayEnd.equals("")))  
		{
			
			BookDAO dao = new BookDAO();
			list = dao.bestSeller(map);
					
			
			for (BookDTO dto : list) {
	
				// 날짜에서 시간 잘라내기
				dto.setPubdate(dto.getPubdate().substring(0, 10));
	
				// 제목, 카피 너무 길면 자르기
				if (dto.getTitle().length() > 30) {
					dto.setTitle(dto.getTitle().substring(0, 30) + "..");
				}
	
				if (dto.getCopy().length() > 40) {
					dto.setCopy(dto.getCopy().substring(0, 40) + "..");
				}
	
			}
			 
			
			req.setAttribute("yearStart", yearStart);
			req.setAttribute("monthStart", monthStart);
			req.setAttribute("dayStart", dayStart);
			req.setAttribute("yearEnd", yearEnd);
			req.setAttribute("monthEnd", monthEnd);
			req.setAttribute("dayEnd", dayEnd);
			
			
			
			ArrayList<BookDTO> list1 = new ArrayList<BookDTO>(); //1위
			ArrayList<BookDTO> list2 = new ArrayList<BookDTO>(); //2~4위
			ArrayList<BookDTO> list3 = new ArrayList<BookDTO>(); //5~10위
			
			/*
			 for (int i=0; i<=0; i++) { list1.add(list.get(i)); }
			 */

			System.out.println("size: " + list.size());
			
			list1.add(list.get(0));
			
			for (int i=1; i<=3; i++) {
				list2.add(list.get(i));
			}
			
			for (int i=4; i<=9; i++) {
				list3.add(list.get(i));
			}
			
			req.setAttribute("list1", list1);
			req.setAttribute("list2", list2);
			req.setAttribute("list3", list3);
		
				
		} 
		
	
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/book/newbook.jsp");
		dispatcher.forward(req, resp);

	}

}