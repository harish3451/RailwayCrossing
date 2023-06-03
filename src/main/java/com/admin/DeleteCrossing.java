package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.user.Hibernateutil;


public class DeleteCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		String cid = request.getParameter("delete");
		int id = Integer.parseInt(cid);
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		org.hibernate.query.Query q = session.createQuery("delete CrossingDetails where id ="+id);
		org.hibernate.query.Query q1 = session.createQuery("delete Favorite where crossing_id ="+id);
		q.executeUpdate();
		q1.executeUpdate();
		transaction.commit();
		request.getRequestDispatcher("home").include(request, response);
	}

	

}
