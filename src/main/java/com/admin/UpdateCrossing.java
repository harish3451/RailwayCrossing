package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.user.CrossingDetails;
import com.user.Hibernateutil;


public class UpdateCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		PrintWriter out = response.getWriter();
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		String str = request.getParameter("update");
		List<CrossingDetails> cd = session.createQuery("from CrossingDetails where id="+str).list();
		request.getRequestDispatcher("Update.jsp").include(request, response);
		response.setContentType("text/html");
		
		out.print("<center><form action='Updated'>");
		
		for(CrossingDetails c:cd) {
			out.print("<input type='hidden' name = 'id' value="+c.getId()+">");
			out.print("<h4>Enter Name: </h4>");
			out.print("<input type='text' name ='name' value="+"'"+c.getCrossingName()+"'><br>");
			out.print("<h4>Enter Address: </h4>");
			out.print("<input type='text' name ='address' value="+"'"+c.getAddress()+"'><br>");
			out.print("<h4>Enter Landmark: </h4>");
			out.print("<input type='text' name ='landmark' value="+"'"+c.getLandmark()+"'><br>");
			out.print("<h4>Enter Train Schedule: </h4>");
			out.print("<input type='text' name ='schedule' value="+"'"+c.getTrainSchedule()+"'><br>");
			out.print("<h4>Enter Person In Charge: </h4>");
			out.print("<input type='text' name ='person' value="+"'"+c.getPersonIncharge()+"'><br>");
			out.print("<h4>Crossing Status: </h4>");
			out.print("Currenty:"+c.getCrossingStatus()+"<br>");
			out.print("<input type='radio' name ='status' value='OPEN' checked='checked'>OPEN<br>");
			out.print("<input type='radio' name ='status' value='CLOSE'>CLOSE<br>");
			
			
			out.print("<input type='submit' value='Update'>");
			
		}
		out.print("</form></center>");
		
	}

	
}
