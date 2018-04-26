package com.bookshopweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Author;
import com.bookshopweb.model.Book;
import com.bookshopweb.model.Genre;
import com.bookshopweb.model.History;

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

				java.util.Date now = new java.util.Date();
			    java.sql.Timestamp historyDate = new java.sql.Timestamp(now.getTime());
				
				History history = new History();
				history.setBook(book);
				history.setDate(historyDate);
				history.setIp(request.getRemoteAddr());
				db.getHistory().create(history);
				
				request.setAttribute("book", book);
				request.setAttribute("authors", new ArrayList<Author>(book.getAuthors()));
				request.setAttribute("genres", new ArrayList<Genre>(book.getGenres()));
				
				db.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			getServletContext().getRequestDispatcher("/jsp/BookDetail.jsp").forward(request, response);
		}
		
	}
}
