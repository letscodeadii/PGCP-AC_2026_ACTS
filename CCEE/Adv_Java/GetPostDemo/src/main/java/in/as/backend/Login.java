package in.as.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mylogin")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String myemail = request.getParameter("name1");
		String mypass = request.getParameter("pass1");
		
		
		if(myemail.equals("aditya123@gmail.com") && mypass.equals("aditya123")) {
			System.out.println("success");
		}else {
			System.out.println("failed");
		}

	}

}
