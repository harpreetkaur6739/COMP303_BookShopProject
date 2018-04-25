package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshopweb.dao.Database;
import com.bookshopweb.model.Author;

@WebServlet("/authors/delete")
public class AuthorsDeleteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Author author = null;
		try (Database db = new Database())
		{
			author = getAuthor(db, request);
		} catch (Exception e) { }
		
		request.setAttribute("author", author);
		getServletContext().getRequestDispatcher("/jsp/AuthorsDelete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Author author = null;
		try (Database db = new Database())
		{
			author = getAuthor(db, request);
			db.getAuthors().delete(author);
			db.commit();
		} catch (Exception e) { }
				
		response.sendRedirect("../authors");
	}
	
	private Author getAuthor(Database db, HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		return db.getAuthors().read(id);
	}
}
