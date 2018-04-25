package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Genre;

@WebServlet("/genres/edit")
public class GenresEditServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Genre genre = null;
		try (Database db = new Database())
		{
			genre = getGenre(db, request);
		} catch (Exception e) { }
		
		request.setAttribute("genre", genre);
		getServletContext().getRequestDispatcher("/jsp/GenresEdit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("name");
		
		Genre genre = null;
		try (Database db = new Database())
		{
			genre = getGenre(db, request);
			
			genre.setName(name);
			
			db.getGenres().updateOrCreate(genre);
			db.commit();
		} catch (Exception e) { }
				
		response.sendRedirect("../authors");
	}
	
	private Genre getGenre(Database db, HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		return db.getGenres().read(id);
	}
}
