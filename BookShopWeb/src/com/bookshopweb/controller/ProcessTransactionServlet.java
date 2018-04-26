package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;

@WebServlet("/success")
public class ProcessTransactionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int bookId = Integer.parseInt(request.getParameter("id"));		
		int qty = Integer.parseInt(request.getParameter("qty"));
		try (Database db = new Database())
		{
			db.getBooks().updateInventory(bookId, qty);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String message="Your order has been successfully placed. Thank you for shopping with us.";
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
	}
}
