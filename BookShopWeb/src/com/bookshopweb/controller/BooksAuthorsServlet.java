package com.bookshopweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshopweb.dao.Database;
import com.bookshopweb.model.Author;
import com.bookshopweb.model.Book;
import com.bookshopweb.model.BookWithAuthor;

@WebServlet("/books/authors")
public class BooksAuthorsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			String bookIdStr = request.getParameter("bId");
			String query = request.getParameter("q");
			
			List<BookWithAuthor> bookAuthors = null;
			try (Database db = new Database())
			{
				int bookId = Integer.parseInt(bookIdStr);
				
				bookAuthors = db.getBooks().searchAuthors(bookId, query);
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("bookId", bookIdStr);
			request.setAttribute("bookWithAuthors", bookAuthors);
			request.setAttribute("query", query);
			getServletContext().getRequestDispatcher("/jsp/BooksAuthorsList.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String bookIdStr = request.getParameter("bId");
		String authorIdStr = request.getParameter("aId");
		String operation = request.getParameter("op");
		
		try (Database db = new Database())
		{
			int bookId = Integer.parseInt(bookIdStr);
			int authorId = Integer.parseInt(authorIdStr);
			
			Book book = db.getBooks().read(bookId);
			Author author = db.getAuthors().read(authorId);
			
			if (operation.equals("add"))
			{
				// add the relationship
				book.getAuthors().add(author);
			}
			else if (operation.equals("remove"))
			{
				// remove relationship
				book.getAuthors().remove(author);
			}
			
			db.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./authors?bId=" + bookIdStr);
	}
}
