package in.as.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {
	public static void main(String[] args) throws Exception {
		//--------user values-------
		String name1="Aditya";
		String email1="Adii@gmail.com";
		String pass1="Aditya123";
		String gender1="male";
		String city1="mumbai";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","Adii#@24aug");
		
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");//Positional Parameters
		ps.setString(1,name1);
		ps.setString(2, email1);
		ps.setString(3, pass1);
		ps.setString(4, gender1);
		ps.setString(5, city1);
		
		int i=ps.executeUpdate();
		
		if(i>0) {
			System.out.println("Success");
		}else {
			System.out.println("Fail");
		}
		
	}

}
