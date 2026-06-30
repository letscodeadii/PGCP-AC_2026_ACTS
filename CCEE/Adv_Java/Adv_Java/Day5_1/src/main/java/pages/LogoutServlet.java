package pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import pojos.User;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type
		response.setContentType("Text/html");
		//pw
		try(PrintWriter pw=response.getWriter())
		{
			//1. get HttpsSession from WC
			HttpSession session = request.getSession();
			System.out.println("from logout page session is new "+session.isNew());//false
			System.out.println("Jsession id "+session.getId());
	
			//2. Get user Details from the session scope 
			User user=(User) session.getAttribute("clnt_details");
			if(user!=null) 
			{ 
				pw.print("<h5> Hello , "+user.getName()+"</h5>");
				pw.print("<h5> You logged out... </h5>");
				//invalidate
				
			}
			else 
			{
				pw.print("<h5> Session Tracking based upon HttpSession Failed : No Cookies !!!!!</h5>");
				//invalidate the session
				session.invalidate();
				//send log out link to the clnt
				pw.print("<h5> <a href='login.html'>Visit Again</a></h5>");
				
			}
		}
	}

}
