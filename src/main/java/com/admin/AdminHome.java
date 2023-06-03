package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.user.CrossingDetails;
import com.user.Hibernateutil;


public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		
		List<CrossingDetails> cd = session.createQuery("from CrossingDetails").list();
		request.getRequestDispatcher("AdminHome.jsp").include(request, response);
		response.setContentType("text/html");
		out.print("<center><table style=padding-top:10px;width:90%;text-align:left;border-collapse:collapse;>");
		out.print("<tr style=border-bottom:solid;border-color:grey><th><b>Sr.No</b></th><th><b>Name</b></th><th><b>Address</b></th><th><b>Landmark</b></th><th><b>Train Schedule</b></th><th><b>Person In-charge</b></th><th><b>Status</b></th><th><b>Action</b></th></tr>");
		int i=1;
		
		for(CrossingDetails c:cd) {
			out.print("<tr style=padding-top: 10px;border-bottom:solid;border-color:grey>");
			out.print("<td>"+(i++)+"<td>"+c.getCrossingName()+"<td>"+c.getAddress()+"<td>"+c.getLandmark()+"<td>"+c.getTrainSchedule()+"<td>"+c.getPersonIncharge()+"<td>"+c.getCrossingStatus());
			out.print("<td>");
			out.print("<form action='UpdateCrossing' style=float:left>");
			out.print("<input type='hidden' name='update' value="+(c.getId())+">");
			out.print("<input type='submit' value='Update' style=border:none;border-radius:5px;height:25px>");
			out.print("</form>");
			out.print("<form action='deleteCrossing' style=margin-left:10px>");
			out.print("<input type='hidden' name='delete' value="+(c.getId())+">");
			out.print("<input type='submit' value='Delete' style=margin-left:5px;border:none;border-radius:5px;height:25px>");
			out.print("</form>");
			out.print("<td>");
			out.print("</tr>");
			
		}
		out.print("</table></center>");
	}

}
