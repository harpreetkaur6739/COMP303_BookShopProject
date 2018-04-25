package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshopweb.dao.Database;
import com.bookshopweb.model.Book;

@WebServlet("/books/delete")
public class BooksDeleteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Book book = null;
		try (Database db = new Database())
		{
			book = getBook(db, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("book", book);
		getServletContext().getRequestDispatcher("/jsp/BooksDelete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try (Database db = new Database())
		{
			Book book = getBook(db, request);
			db.getBooks().delete(book);
			db.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		response.sendRedirect("../books");
	}
	
	private Book getBook(Database db, HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		return db.getBooks().read(id);
	}
}
