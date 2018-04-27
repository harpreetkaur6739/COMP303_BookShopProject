package com.bookshopweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshopweb.dao.Database;
import com.bookshopweb.model.User;

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("userName");
		if(username != null) {
			String password = request.getParameter("password");
			String role = "customer";
			
			try (Database db = new Database()){
				User user = new User();
				user.setUserName(username);
				user.setPassword(password);
				user.setRole(role);
				User registeredUser = db.getUsers().create(user);
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", registeredUser.getUserName());
				httpSession.setAttribute("role", registeredUser.getRole());
				getServletContext().getRequestDispatcher("/jsp/Home.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			getServletContext().getRequestDispatcher("/jsp/Registration.jsp").forward(request, response);
		}
		
		
	}
	
}
