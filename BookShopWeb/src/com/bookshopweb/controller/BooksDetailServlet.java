package com.bookshopweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookshopweb.dao.*;
import com.bookshopweb.model.Author;
import com.bookshopweb.model.Book;
import com.bookshopweb.model.Genre;
import com.bookshopweb.model.History;

@WebServlet("/books/detail")
public class BooksDetailServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			String bookStr = request.getParameter("id");
			
			if(bookStr != null) {
				Integer bookId = Integer.parseInt(bookStr);
				Book book = null;
				try (Database db = new Database())
				{
					book = db.getBooks().read(bookId);			

<<<<<<< HEAD
				// record the view into the history table
				java.util.Date now = new java.util.Date();
			    java.sql.Timestamp historyDate = new java.sql.Timestamp(now.getTime());
				
				History history = new History();
				history.setBook(book);
				history.setDate(historyDate);
				history.setIp(request.getRemoteAddr());
				db.getHistory().create(history);
				
				// copy the lists because they are lazy loaded
				ArrayList<Author> authors = new ArrayList<Author>(book.getAuthors());
				Collections.sort(authors); // sort so the order isn't random
				
				ArrayList<Genre> genres = new ArrayList<Genre>(book.getGenres());
				Collections.sort(genres);
				
				request.setAttribute("book", book);
				request.setAttribute("authors", authors);
				request.setAttribute("genres", genres);
				
				db.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
=======
					request.setAttribute("book", book);
					request.setAttribute("authors", new ArrayList<Author>(book.getAuthors()));
					request.setAttribute("genres", new ArrayList<Genre>(book.getGenres()));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
>>>>>>> buybook

				getServletContext().getRequestDispatcher("/jsp/BookDetail.jsp").forward(request, response);
			}
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
		
	}
}
