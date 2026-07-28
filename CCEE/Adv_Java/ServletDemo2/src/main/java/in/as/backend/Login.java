package in.as.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("pass1");

		PrintWriter out = resp.getWriter();

		if (myemail.equals("aditya123@gmail.com") && mypass.equals("aditya123")) {
			
			//req.setAttribute("name_key", "Aditya Singh");
			
			HttpSession session =req.getSession();
			session.setAttribute("name_key","Aditya Singh");
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, resp);
		
		
		} else {
			resp.setContentType("text/html");
			out.println("<h3 Style='color:red'> Email id and password didnt matched </h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
		}

	}

}
