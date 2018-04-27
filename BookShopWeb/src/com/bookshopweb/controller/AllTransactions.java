package com.bookshopweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshopweb.dao.*;
import com.bookshopweb.model.Transaction;

/**
 * Servlet implementation class AuthorsCreateServlet
 */
@WebServlet("/transactionList")
public class AllTransactions extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession() != null && request.getSession().getAttribute("user") != null) {
			List<Transaction> txns = null;
			try (Database db = new Database())
			{				
				txns = db.getTransactions().findAll();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			request.setAttribute("transactions", txns);
			getServletContext().getRequestDispatcher("/jsp/AllTransactions.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
		
	}
}
