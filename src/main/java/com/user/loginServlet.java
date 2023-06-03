package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		boolean flag=false;
		
		String mail=request.getParameter("mail");
		String pswd = request.getParameter("password");
		
		List<UserDetails> up =  session.createQuery("from UserDetails where mail="+"'"+mail+"'").list();	
		for(UserDetails u:up) {
			flag=true;
			if(u.getPassword().equals(pswd)) {
				out.println("logged in");
				HttpSession session1 = request.getSession();
				session1.setAttribute("user", u.getId());
				request.getRequestDispatcher("allcrossing").forward(request, response);
				
			}
			else {
				HttpSession session1=request.getSession();
				session1.setAttribute("us", "Invalid Password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		}
		if(flag==false) {
			HttpSession session1=request.getSession();
			session1.setAttribute("us", "Invalid Mail ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		session.close();
	}
}
