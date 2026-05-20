package tester;
import static utils.DBUtils.openConnection;
import java.sql.*;

public class TestStatement {

	public static void main(String[] args) {
		try(Connection conn=openConnection();
				//create empty Statement object , to hold query)
				Statement st=conn.createStatement();
				//execute the select query : Public ResutSet executeQuery(String sql) throws SQLExc
		      ResultSet rst=st.executeQuery("select * from my_empy");)
		{
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
