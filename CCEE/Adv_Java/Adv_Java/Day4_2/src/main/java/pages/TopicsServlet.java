package pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
			//3. how to retrieve user details from a cookie ?
			//API of HttpServletRequest : Cookie[] getCookies()
			Cookie[] cookies = request.getCookies();
			//null chking
			if(cookies != null) 
			{
				for(Cookie c:cookies)
					if(c.getName().equals("user_details")) {
						pw.print("<h5> Validated  User Details retrieved from a cookie : "+c.getValue()+"</h5>");
						break;
					}
				//
			}else {
				pw.print("<h5> Session Tracking Failed : No Cookie!!!!!!</h5>");
			}
			
		}
	}

}
