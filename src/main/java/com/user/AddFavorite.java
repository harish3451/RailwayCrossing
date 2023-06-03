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

public class AddFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession(false);
		PrintWriter out = response.getWriter();
		int Uid = (int) session1.getAttribute("user");
		String cid = request.getParameter("added");
		int id = Integer.parseInt(cid);
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
		Favorite fav = new Favorite(Uid,id);
		session.save(fav);
		transaction.commit();
		}catch(Exception e) {
			
		}finally {
		response.sendRedirect("favoriteCrossing");
		}
		}

	
}
