package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshopweb.dao.*;
import com.bookshopweb.model.Book;
import com.bookshopweb.model.Transaction;

@WebServlet("/books/success")
public class ProcessTransactionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int bookId = Integer.parseInt(request.getParameter("id"));		
		int qty = Integer.parseInt(request.getParameter("qty"));
		float price = Float.parseFloat(request.getParameter("price"));
		HttpSession httpSession = request.getSession();
		String user = (String)httpSession.getAttribute("user");
		try (Database db = new Database())
		{
			Transaction txn = new Transaction();
			txn.setAmount(price);
			txn.setUser(user);
			
			Book book = db.getBooks().read(bookId);
			txn.setBook(book);
			txn.setQuantity(qty);
			txn.setDate(new java.util.Date());
			db.getTransactions().updateOrCreate(txn);
			db.getBooks().updateInventory(bookId, qty);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String message="Your order has been successfully placed. Thank you for shopping with us.";
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
	}
}
