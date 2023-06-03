package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.user.Hibernateutil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		boolean flag=false;
		
		String mail=request.getParameter("mail");
		String pswd = request.getParameter("password");
		
		List<AdminDetails> up =  session.createQuery("from AdminDetails where mail like "+"'"+mail+"'").list();	
		for(AdminDetails u:up) {
			flag=true;
			if(u.getPassword().equals(pswd)) {
				out.println("logged in");
				HttpSession session1 = request.getSession();
				session1.setAttribute("admin", u.getMail());
				request.getRequestDispatcher("home").forward(request, response);
				
			}
			else {
				HttpSession session1=request.getSession();
				session1.setAttribute("us", "Invalid Password");
				request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
			}
		}
		if(flag==false) {
			HttpSession session1=request.getSession();
			session1.setAttribute("us", "Invalid Mail ");
			request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
		}
		session.close();
	}

	

}
