package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.user.Hibernateutil;
import com.user.*;


public class AddCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		CrossingDetails cd = new CrossingDetails(request.getParameter("name"),request.getParameter("status"),request.getParameter("person"),request.getParameter("schedule"),request.getParameter("landmark"),request.getParameter("address"));
		session.save(cd);
		transaction.commit();
		response.sendRedirect("home");
	}

	
	
}
