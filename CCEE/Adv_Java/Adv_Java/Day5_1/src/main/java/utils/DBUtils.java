package utils;
import java.sql.*;

public class DBUtils {
	//add a static method to return DB Connection instance
	//modify the code below , to ensure SINGLEton instance of the DB Connection 
	//(not a scalable solution , will be replace by connection pool , from hibernate onwards)
	
	private static Connection cn;
	public static Connection openConnection() throws SQLException{
		if(cn==null) {
			String url="jdbc:mysql://localhost:3306/pgcpac26?useSSL=false&allowPublicKeyRetrieval=true";
			cn= DriverManager.getConnection(url,"root","Adii#@24aug");
		}
		return cn;

		
	}

}