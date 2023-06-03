package com.user;

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


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession(false);
		int a = 0;
		if(session1.getAttribute("user")!=null) {
			
			 a =  (int) session1.getAttribute("user");
		}
		String b = (String) session1.getAttribute("admin");
		request.getRequestDispatcher("searchcrossing.jsp").include(request, response);
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		PrintWriter out = response.getWriter();
		String str = request.getParameter("find");
		List<CrossingDetails> cd = session.createQuery("from CrossingDetails where CrossingName like '%"+str+"%'").list();
		int t = 0;
		if(a != 0) {
		for(CrossingDetails c:cd) {
			t=1;
			out.print("<center><div style=text-align:left;border-width:1px;border:solid;border-radius:10px;margin-top:20px;width:95%;padding-left:20px;padding-bottom:20px>");
			out.print("<h3>"+c.getCrossingName()+"</h3>");
			out.print("Crossing Status :");
			if(c.getCrossingStatus().equalsIgnoreCase("open")) {
				out.print("<span style=color:white;background-color:green;border-radius:80px;>&nbsp; OPEN &nbsp;&nbsp;</span><br>");
			}
			if(c.getCrossingStatus().equalsIgnoreCase("Close")) {
				out.print("<span style=color:white;background-color:red;border-radius:80px;>&nbsp; CLOSE &nbsp;&nbsp;</span><br>");
			}
			out.print("Person In-charge: <b>"+c.getPersonIncharge()+"</b><br>");
			out.print("Train Schedule : <b>"+c.getTrainSchedule()+"</b><br>");
			out.print("Landmark <b>"+c.getLandmark()+"</b><br>");
			out.print("Address: <b>"+c.getAddress()+"<b><br><br>");
			out.print("<form action='addfavorite'>");
			out.print("<input type='hidden' name='added' value="+(c.getId())+">");
			out.print("<input type='submit' value='Add to favorite' style=color:grey;background-color:transparent;border:solid;border-color:grey;border-radius:50px;height:30px;width:150px>");
			out.print("</form>");
			out.print("</div></center>");
		}
		if(t ==0) {
			out.print("No crossing found");
		}}
		if(b != null) {
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
				out.print("<input type='submit' value='Update' style=float:left;border:none;border-radius:5px;height:25px>");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
