package com.bookshopweb.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Author;
import com.bookshopweb.model.Book;

@WebServlet("/books")
public class BooksListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			String query = request.getParameter("q");
			
			List<Book> books = null;
			try (Database db = new Database())
			{
				if (query != null && query.length() != 0)
				{
					books = db.getBooks().search(query);
				}
				else
				{
					books = db.getBooks().list();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("query", query);
			request.setAttribute("books", books);
			getServletContext().getRequestDispatcher("/jsp/BooksList.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
	}
}
