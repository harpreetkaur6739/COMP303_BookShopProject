package com.bookshopweb.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopjpa.dao.AuthorDAO;
import com.bookshopjpa.model.Author;

@WebServlet("/authors")
public class AuthorsListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Author> authors = AuthorDAO.getAuthors();
		getServletContext().getRequestDispatcher("/jsp/AuthorsList.jsp").forward(request, response);
	}
}
