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


public class FavoriteCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("allCrossing.jsp").include(request, response);
		HttpSession s = request.getSession(false);
		int t =(int) s.getAttribute("user");
		SessionFactory factory = Hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		PrintWriter out = response.getWriter();
		List<Favorite> fav = session.createQuery("from Favorite where user_id="+t).list();
		for(Favorite f:fav) {
			int st = f.getCrossing_id();
			List<CrossingDetails> cd =  session.createQuery("from CrossingDetails where id="+st).list();
			for(CrossingDetails c:cd) {
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
				out.print("Address: <b>"+c.getAddress()+"</b><br><br>");
				out.print("<form action='removefavorite'>");
				out.print("<input type='hidden' name='remove' value="+st+">");
				out.print("<input type='submit' value='Remove favorite' style=color:grey;background-color:transparent;border:solid;border-color:grey;border-radius:50px;height:30px;width:150px>");
				out.print("</form>");
				out.print("</div></center>");
			}
		}
	}

	

}
