package pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class Servlet
 */
//@WebServlet(value="/test2",loadOnStartup=1)
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init of "+getClass());
	}

	/**
	 * @see Servlet2#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of "+getClass());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get of "+getClass());
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("Testing lazy/eager loading policies"+new Date());
			
		}

	}

}
