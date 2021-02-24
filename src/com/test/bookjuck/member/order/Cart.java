package com.test.bookjuck.member.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.BookCartDAO;
import com.test.bookjuck.dto.BookCartDTO;

@WebServlet("/member/order/cart.do")
public class Cart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//임시로 회원번호 21번 지정
		String seqMember = "21";
		
		BookCartDAO dao = new BookCartDAO();
		
		ArrayList<BookCartDTO> list = dao.list(seqMember);
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/order/cart.jsp");
		dispatcher.forward(req, resp);

	}
}