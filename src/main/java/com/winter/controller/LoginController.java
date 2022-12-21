package com.winter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.service.UserService;
import com.winter.to.UserTO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("inside doPost of LoginController...");
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		System.out.println(username+", "+password);
		
		UserService service = new UserService();
		
		UserTO to = service.validate(username, password);
		
		if(to != null) {
			
			request.setAttribute("userData", to);
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			
			dispatcher.forward(request, response);
		}
		
		
	}

}
