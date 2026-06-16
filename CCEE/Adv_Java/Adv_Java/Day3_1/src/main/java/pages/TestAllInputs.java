package pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Servlet implementation class TestAllInputs
 */
@WebServlet("/test_input")
public class TestAllInputs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set resp content type;
		response.setContentType("text/html");
		//open PW: To Send resp from servlet---clnt
		try(PrintWriter pw=response.getWriter())
		{
			//read request parameters n  response 
			pw.print("<h4>Hello,"+request.getParameter("f1")+"</h4>");
			pw.print("<h4>Favorite Colors "+Arrays.toString(request.getParameterValues("clr"))+"</h4>");
			pw.print("<h4> Selected Browser "+request.getParameter("f1")+"</h4>");
			pw.print("<h4>Selected City "+request.getParameter("myselect")+"</h4>");
			pw.print("<h4> About "+request.getParameter("info")+"</h4>");


		}
		
	}

}
