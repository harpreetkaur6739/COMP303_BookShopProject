package com.bookshopweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshopweb.dao.BookDaoImpl;
import com.bookshopweb.model.Book;

@WebServlet("") // index
public class HomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Get list of books
		List<Book> authors = new BookDaoImpl().listAllBooks();
		request.setAttribute("books", authors);
		getServletContext().getRequestDispatcher("/jsp/Home.jsp").forward(request, response);
	}
}
