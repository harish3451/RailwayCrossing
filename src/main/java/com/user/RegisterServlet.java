package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
		UserDetails u = new UserDetails(request.getParameter("name"), request.getParameter("mail"),request.getParameter("password"));
		session.save(u);
		transaction.commit();
		
		}catch(Exception e) {
			out.print("Already registered<br>");
			out.print("logIn Please go to logIn page");
		}
		response.sendRedirect("login.jsp");
			}
}
