package com.test.bookjuck.search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/common/realtimesearch.do")
public class RealTimeSearch extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		
		
		
		ArrayList<RealTimeSearchDTO> list = new ArrayList<RealTimeSearchDTO>();
		
		RealTimeSearchDAO dao = new RealTimeSearchDAO();
		list = dao.getSearchRank();
		
		System.out.println(list);
		

		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/realtimesearch.jsp");
		dispatcher.forward(req, resp);
		
	}

}