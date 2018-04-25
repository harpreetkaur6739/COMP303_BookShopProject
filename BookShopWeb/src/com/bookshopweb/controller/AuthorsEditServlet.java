package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Author;

@WebServlet("/authors/edit")
public class AuthorsEditServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Author author = null;
		try (Database db = new Database())
		{
			author = getAuthor(db, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("author", author);
		getServletContext().getRequestDispatcher("/jsp/AuthorsEdit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try (Database db = new Database())
		{
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			Author author = getAuthor(db, request);
			
			author.setFirstName(firstName);
			author.setLastName(lastName);
			
			db.getAuthors().updateOrCreate(author);
			db.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		response.sendRedirect("../authors");
	}
	
	private Author getAuthor(Database db, HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		return db.getAuthors().read(id);
	}
}
