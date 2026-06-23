package pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojos.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import dao.UserDaoImpl;

@WebServlet( value = "/authenticate",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	public void init() throws ServletException {
		// User Dao Instance
		try {
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
			// To inform WC that init() has failed: re throw the exception , wrapped in
			// ServletException
			// ServletException(String errMsg,Throwable e)
			throw new ServletException("err in init of" + getClass(), e);
		}
	}

	public void destroy() {
		// invoke dao's cleanup
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			// how to tell WC that destroy method failed?
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type
		response.setContentType("text/html");
		// get PW to send response
		try (PrintWriter pw = response.getWriter()) {
			// read req params:email n pwd
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			// LoginServlet invoke dao's CRUD method
			User user = userDao.ValidateUser(email, pwd);
			// chk null => invalid --retry link
			if (user == null)
				pw.print("<h5>Invalid Login Please <a href='login.html'>Retry</a></h5>");
			  //not null => successful login : send validate user details to clnt
			else {
				//=>Login success
				//create a cookie to store, validate user details 
				//javax.servlet.http.Cookie(String name, String value)
				Cookie c1=new Cookie("user_details",user.toString());
				//send cookie from server to client , in the resp header
				//method of HttpServletResponse:public void addCookie(Cookie c)
				response.addCookie(c1);
     //pw.print("<h5>Login Successful, User Details from login servlet " + user + "</h5>");
	//pw.flush();//explicitly committing the response : un comment this line to understand IllegalStateException 
			    //automatically redirect the client to the topics page 
				//API of HttpServletResponse 
				//Method :public void sendRedirect(String redirectLocation) throws IOException
				response.sendRedirect("topics");
			    //WC: sends temp redirect response
				//resp : SC 302 | header : location = topics, set-cookie : user_details : toString | body : EMPTY
				//web browser : send NEW request 
				//URL: http://host:port/day4.1/topics
				//HTTP method: GET 
				//request header: cookie user_details : tostring
				//add a TopicServlet : with / topics  
		
			}
		} catch (Exception e) {
			// re throw the exception to caller(WC)
			throw new ServletException("err in do-post of " + getClass(), e);
		}
		// TODO: handle exception
	}

}
