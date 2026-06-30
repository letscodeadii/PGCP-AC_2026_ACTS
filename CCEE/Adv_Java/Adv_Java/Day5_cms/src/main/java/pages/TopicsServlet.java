package pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.User;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h5>Login Successful, from topics page...<h5>");
	     	//Steps 1: Get HttpSession objects from WC (existing object, provided cookies are enabled!)
			HttpSession hs=request.getSession();
			System.out.println("from topics page session is new "+hs.isNew());//false
			System.out.println("Session id "+hs.getId());//will display SAME JSESSIONID for the SAME Client
			//2.Retrieve user details from the session scope 
			//HttpSession API : public Object getAttribute(String attributeName)
			User retrievedUser=(User)hs.getAttribute("clnt_details");
			if(retrievedUser!=null) {
				pw.print("<h5> Retrieved user details from HttpSession "+retrievedUser+"</h5>");
			}else {
				pw.print("<h5> Session Tracking based upon HttpSession Failed : No Cookie!!!!!!</h5>");
			}
			//send add log out link 
			pw.print("<h5> <a href = 'logout'> Log Me Out </a></h5>");
			
		}
	}

}
