package tester;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
	
	public static void main(String[] args) {
		try {
			//load MySQL Connector(JDBC Driver Class in Method Area ): OPTIONAL
			//Class.forName("com.mysql.cj.jdbc.Driver");	
			String url="jdbc:mysql://localhost:3306/pgcpac26?useSSL=false&allowPublicKeyRetrieval=true";
		    //API of java.sql.DriverManager class
			//public static Connection getConnection(String url, String userName,String pwd )throws SQLException
		    try(Connection cn=DriverManager.getConnection(url,"root","Adii#@24aug")) {
		    	
		    	System.out.println("Connected to DB "+cn);//
		    	
		    }

		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
