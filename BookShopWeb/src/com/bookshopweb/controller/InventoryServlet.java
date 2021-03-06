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

@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			List<Book> books = null;
			try (Database db = new Database())
			{
				books = db.getBooks().list();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("books", books);
			getServletContext().getRequestDispatcher("/jsp/ViewInventory.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
	}
}
