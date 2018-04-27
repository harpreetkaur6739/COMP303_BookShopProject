package com.bookshopweb.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Book;
import com.bookshopweb.model.Detail;
import com.bookshopweb.model.Inventory;

/**
 * Servlet implementation class BooksCreateServlet
 */
@WebServlet("/books/create")
public class BooksCreateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			getServletContext().getRequestDispatcher("/jsp/BooksCreate.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null) {
			try (Database db = new Database())
			{
				String title = request.getParameter("title");
				SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy");
				Date date = dateFmt.parse(request.getParameter("publishDate"));
				String isbn = request.getParameter("isbn");
				int rating = Integer.parseInt(request.getParameter("rating"));
				String summary = request.getParameter("summary");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				Float price = Float.parseFloat(request.getParameter("price"));
				
				Book book = new Book();
				book.setTitle(title);
				book.setPublishDate(new java.sql.Date(date.getTime())); // converting to SQL date
				book.setIsbn(isbn);
				book.setRating(rating);
				
				Detail detail = new Detail();
				detail.setSummary(summary);
				book.setDetail(detail);
				
				Inventory inventory = new Inventory();
				inventory.setQuantity(quantity);
				inventory.setPrice(price);
				
				book.setInventory(inventory);
				
				db.getBooks().updateOrCreate(book);
				db.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("../books");
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
	}
}
