package com.bookshopweb.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Book;
import com.bookshopweb.model.Genre;

@WebServlet("/genres")
public class GenresListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			String query = request.getParameter("q");
			
			List<Genre> genres = null;
			try (Database db = new Database())
			{
				if (query != null && query.length() != 0)
				{
					genres = db.getGenres().search(query);
				}
				else
				{
					genres = db.getGenres().list();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("query", query);
			request.setAttribute("genres", genres);
			getServletContext().getRequestDispatcher("/jsp/GenresList.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
	}
}
