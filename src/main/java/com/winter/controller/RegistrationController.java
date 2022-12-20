package com.winter.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.service.UserService;
import com.winter.to.UserTO;


@WebServlet("/registrationPage")
public class RegistrationController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("registration_page.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println("inside doPost() of RegistrationServlet");

			PrintWriter writer = response.getWriter();

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String completeName = request.getParameter("name");
			String email = request.getParameter("email");

			System.out.println(username + ", " + password + ", " + completeName + ", " + email);

			UserTO to = new UserTO(username, password, completeName, email);
			
			UserService service = new UserService();
			
			service.addUser(to);

			writer.println("<html><body>Thanks for Registering with us...</body></html>");
		} catch (Exception e) {
			System.out.println("inside catch");
			e.printStackTrace();
		}
	}
}


//@WebServlet("/registrationPage")
//public class RegistrationPageServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("registration_page.jsp");
//
//		dispatcher.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//			System.out.println("inside doPost() of RegistrationServlet");
//
//			PrintWriter writer = response.getWriter();
//
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			String completeName = request.getParameter("name");
//			String email = request.getParameter("email");
//
//			System.out.println(username + ", " + password + ", " + completeName + ", " + email);
//
//			UserRepository repository = new UserRepository();
//			
//			UserTO to = new UserTO(username, password, completeName, email);
//			
//			repository.saveuser(to);
//
////			repository.saveuser(username, password, completeName, email);
//
//			writer.println("<html><body>Thanks for Registering with us...</body></html>");
//		} catch (Exception e) {
//			System.out.println("inside catch");
//			e.printStackTrace();
//		}
//	}
//}


//@WebServlet("/registrationPage")
//public class RegistrationPageServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("registration_page.jsp");
//
//		dispatcher.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//			System.out.println("inside doPost() of RegistrationServlet");
//
//			PrintWriter writer = response.getWriter();
//
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			String completeName = request.getParameter("name");
//			String email = request.getParameter("email");
//
//			System.out.println(username + ", " + password + ", " + completeName + ", " + email);
//
//			UserRepository repository = new UserRepository();
//
//			repository.saveuser(username, password, completeName, email);
//
//			writer.println("<html><body>Thanks for Registering with us...</body></html>");
//		} catch (Exception e) {
//			System.out.println("inside catch");
//			e.printStackTrace();
//		}
//	}
//}

//@WebServlet("/registrationPage")
//public class RegistrationPageServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("registration_page.jsp");
//
//		dispatcher.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//			System.out.println("inside doPost() of RegistrationServlet");
//
//			PrintWriter writer = response.getWriter();
//
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			String completeName = request.getParameter("name");
//			String email = request.getParameter("email");
//
//			System.out.println(username + ", " + password + ", " + completeName + ", " + email);
//
//			Connection conn = DBConnection.getConnection();
//			
//			
//			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?)");
//			
//			statement.setString(1, username);
//			statement.setString(2, password);
//			statement.setString(3, completeName);
//			statement.setString(4, email);
//			
//			statement.executeUpdate();
//
//			writer.println("<html><body>Thanks for Registering with us...</body></html>");
//		} catch (Exception e) {
//			System.out.println("inside catch");
//			e.printStackTrace();
//		}
//	}
//}

//@WebServlet("/registrationPage")
//public class RegistrationPageServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("registration_page.jsp");
//
//		dispatcher.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//			System.out.println("inside doPost() of RegistrationServlet");
//
//			PrintWriter writer = response.getWriter();
//
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			String completeName = request.getParameter("name");
//			String email = request.getParameter("email");
//
//			System.out.println(username + ", " + password + ", " + completeName + ", " + email);
//
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/winter", "root", "root");
//			
//			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?)");
//			
//			statement.setString(1, username);
//			statement.setString(2, password);
//			statement.setString(3, completeName);
//			statement.setString(4, email);
//			
//			statement.executeUpdate();
//
//			writer.println("<html><body>Thanks for Registering with us...</body></html>");
//		} catch (Exception e) {
//			System.out.println("inside catch");
//			e.printStackTrace();
//		}
//
//	}

//}
