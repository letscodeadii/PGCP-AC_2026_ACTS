package in.sp.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","Adii#@24aug");
		
		PreparedStatement ps=con.prepareStatement("Select * from register");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			String name1=rs.getString("name");
			System.out.println("Name : "+name1);
			
			String email1=rs.getString("email");
			System.out.println("Email : "+email1);
			
			String password1=rs.getString("password");
			System.out.println("Password : "+password1);
			
			String gender1=rs.getString("gender");
			System.out.println("Gender : "+gender1);
			
			String city1=rs.getString("city");
			System.out.println("City : "+city1);
			
//			System.out.println("Name :"+rs.getString("name"));
		}
		
		
		
	}

}
