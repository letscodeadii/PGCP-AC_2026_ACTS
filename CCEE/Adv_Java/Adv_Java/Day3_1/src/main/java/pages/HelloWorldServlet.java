package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class HelloWorldServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in do-get : invoked by "+Thread.currentThread());
		//set response content type
		//Method of HttpServletResponse : public void setContentType(String contType)
		resp.setContentType("text/html");//resp pkt header
		//to send resp from server --->clnt(i.e. to set resp body :) get writer instance from Http resp
		try(PrintWriter pw=resp.getWriter())
		{	
			pw.print("Welcome 2 servlets!!!! @ "+LocalDateTime.now());//response body 
		}//pw.close--WC will sends PW's buffer contents to Web Server ----> resp pkt(SC 200 | Header | body)
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("in destroy : invoked by "+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("in init : invoked by "+Thread.currentThread());
	}
	
	
	
}
