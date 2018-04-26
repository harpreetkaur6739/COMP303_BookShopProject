package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Book;

@WebServlet("/books/detail")
public class BooksDetailServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String bookStr = request.getParameter("id");
		
		if(bookStr != null) {
			Integer bookId = Integer.parseInt(bookStr);
			Book book = null;
			try (Database db = new Database())
			{
				book = db.getBooks().read(bookId);			
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("book", book);
			getServletContext().getRequestDispatcher("/jsp/BookDetail.jsp").forward(request, response);
		}
		
	}
}
