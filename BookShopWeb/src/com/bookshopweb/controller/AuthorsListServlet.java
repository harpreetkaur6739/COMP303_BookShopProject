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

@WebServlet("/authors")
public class AuthorsListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String query = request.getParameter("q");
		
		List<Author> authors = null;
		try (Database db = new Database())
		{
			if (query != null && query.length() != 0)
			{
				authors = db.getAuthors().search(query);
			}
			else
			{
				authors = db.getAuthors().list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("query", query);
		request.setAttribute("authors", authors);
		getServletContext().getRequestDispatcher("/jsp/AuthorsList.jsp").forward(request, response);
	}
}
