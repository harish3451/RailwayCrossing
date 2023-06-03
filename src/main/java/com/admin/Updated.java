package com.admin;
import com.user.CrossingDetails;
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
import org.hibernate.query.Query;

import com.user.Hibernateutil;


public class Updated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String landmark = request.getParameter("landmark");
		String schedule = request.getParameter("schedule");
		String person = request.getParameter("person");
		String status = request.getParameter("status");
		HttpSession s = request.getSession(false);
		
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query cd =  (Query) session.createQuery("update CrossingDetails set Address='"+ address +"', CrossingName='"+name+"',CrossingStatus='"+status+"',PersonIncharge='"+person+"',TrainSchedule='"+schedule+"',Landmark='"+landmark+"' where id="+id);
		cd.executeUpdate();
		transaction.commit();
		response.sendRedirect("home");
		
	}

}
