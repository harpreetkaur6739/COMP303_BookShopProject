package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Author;

/**
 * Servlet implementation class AuthorsCreateServlet
 */
@WebServlet("/authors/create")
public class AuthorsCreateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			getServletContext().getRequestDispatcher("/jsp/AuthorsCreate.jsp").forward(request, response);
		}			
		else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try (Database db = new Database())
		{
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			Author author = new Author();
			author.setFirstName(firstName);
			author.setLastName(lastName);
			
			db.getAuthors().updateOrCreate(author);
			db.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("../authors");
	}
}
