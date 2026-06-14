package pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test2")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init() throws ServletException {
		System.out.println("in init");
	}

	public void destroy() {
		System.out.println("in destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get");
		//1.set cont type
		response.setContentType("text/html");
		//2.pw: chat buffered o/p strm connected from servlet ---->clnt
		try(PrintWriter pw=response.getWriter())
		{
			//3.
			pw.print("<h5>Welcome to servlet again...."+new java.util.Date()+"</h5>");
		}
	}

}
