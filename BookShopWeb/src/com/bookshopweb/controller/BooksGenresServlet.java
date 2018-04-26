package com.bookshopweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshopweb.dao.Database;
import com.bookshopweb.model.Book;
import com.bookshopweb.model.BookWithGenre;
import com.bookshopweb.model.Genre;

@WebServlet("/books/genres")
public class BooksGenresServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String bookIdStr = request.getParameter("bId");
		String query = request.getParameter("q");
		
		List<BookWithGenre> bookGenres = null;
		try (Database db = new Database())
		{
			int bookId = Integer.parseInt(bookIdStr);
			
			bookGenres = db.getBooks().searchGenres(bookId, query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("bookId", bookIdStr);
		request.setAttribute("bookWithGenres", bookGenres);
		request.setAttribute("query", query);
		getServletContext().getRequestDispatcher("/jsp/BooksGenresList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String bookIdStr = request.getParameter("bId");
		String genreIdStr = request.getParameter("gId");
		String operation = request.getParameter("op");
		
		try (Database db = new Database())
		{
			int bookId = Integer.parseInt(bookIdStr);
			int genreId = Integer.parseInt(genreIdStr);
			
			Book book = db.getBooks().read(bookId);
			Genre genre = db.getGenres().read(genreId);
			
			if (operation.equals("add"))
			{
				// add the relationship
				book.getGenres().add(genre);
			}
			else if (operation.equals("remove"))
			{
				// remove relationship
				book.getGenres().remove(genre);
			}
			
			db.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./genres?bId=" + bookIdStr);
	}
}
