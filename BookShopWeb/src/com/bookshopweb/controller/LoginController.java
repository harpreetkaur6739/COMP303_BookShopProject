package com.bookshopweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshopweb.dao.*;
import com.bookshopweb.model.Author;
import com.bookshopweb.model.User;

/**
 * Servlet implementation class AuthorsCreateServlet
 */
@WebServlet("/authenticate")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(userName != null && password != null) {
			try (Database db = new Database())
			{						
				User user = db.getUsers().authenticate(userName, password);
				if(user != null && user.getUserName()!= null) {
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("user", userName);
					httpSession.setAttribute("role", user.getRole());
					getServletContext().getRequestDispatcher("/jsp/Home.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "Login Failed..");
					getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}
}
