package com.bookshopweb.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Book;

@WebServlet("/books/edit")
public class BooksEditServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			Book book = null;
			try (Database db = new Database())
			{
				book = getBook(db, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("book", book);
			getServletContext().getRequestDispatcher("/jsp/BooksEdit.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null) {
			try (Database db = new Database())
			{
				String title = request.getParameter("title");
				SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy");
				Date date = dateFmt.parse(request.getParameter("publishDate"));
				String isbn = request.getParameter("isbn");
				int rating = Integer.parseInt(request.getParameter("rating"));
				
				Book book = getBook(db, request);
				
				book.setTitle(title);
				book.setPublishDate(new java.sql.Date(date.getTime())); // convert to SQL date
				book.setIsbn(isbn);
				book.setRating(rating);
				
				db.getBooks().updateOrCreate(book);
				db.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
					
			response.sendRedirect("../books");
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
	}
	
	private Book getBook(Database db, HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		return db.getBooks().read(id);
	}
}
