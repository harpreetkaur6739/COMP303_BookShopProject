package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Genre;

@WebServlet("/genres/create")
public class GenresCreateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		getServletContext().getRequestDispatcher("/jsp/GenresCreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try (Database db = new Database())
		{
			String name = request.getParameter("name");
			
			Genre genre = new Genre();
			genre.setName(name);
			
			db.getGenres().updateOrCreate(genre);
			db.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("../genres");
	}
}
