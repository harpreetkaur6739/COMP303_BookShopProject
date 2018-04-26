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

@WebServlet("/books/shop")
public class ViewShopBooksController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String bookId = request.getParameter("id");
			
		if(bookId != null && bookId.length() >0) { //Buy a Book
			int id = Integer.parseInt(bookId);
			Book book = new Book();
			try (Database db = new Database())
			{		
				book = db.getBooks().read(id);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("book", book);
			getServletContext().getRequestDispatcher("/jsp/BuyBook.jsp").forward(request, response);
		}else {
			List<Book> books = null;
			try (Database db = new Database())
			{		
				books = db.getBooks().searchAvailableBooks();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("books", books);
			getServletContext().getRequestDispatcher("/jsp/ShopBooks.jsp").forward(request, response);
		}
		
	}
	

}