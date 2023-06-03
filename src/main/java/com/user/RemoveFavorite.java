package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.cj.Query;


public class RemoveFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		int t =(int) s.getAttribute("user");
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		PrintWriter out = response.getWriter();
		String str = request.getParameter("remove");
		Transaction transaction = session.beginTransaction();
		org.hibernate.query.Query q = session.createQuery("delete Favorite where user_id="+t+" and crossing_id ="+"'"+str+"'");
		q.executeUpdate();
		transaction.commit();
		request.getRequestDispatcher("favoriteCrossing").include(request, response);
	}

}
