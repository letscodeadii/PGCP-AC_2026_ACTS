package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.DBUtils.openConnection;

import pojos.User;

public class UserDaoImpl implements IUserDao {
	private Connection cn;
	private PreparedStatement pst1;
	
	public UserDaoImpl() throws SQLException{
		//get cn
		cn=openConnection();
		pst1=cn.prepareStatement("Select * from users where email=? and password=?");
		System.out.println("User Dao Created !!");
	}

	@Override
	public User ValidateUser(String email, String pwd) throws SQLException {
		//set in params
		pst1.setString(1,email);
		pst1.setString(2,pwd);
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next())//Valid Login
				//int userId, String  name, String email, String password, double reg Amt
				//Date regDate, String role
				return new User(rst.getInt(1),rst.getString(2),email,pwd,rst.getDouble(5),rst.getDate(6),rst.getString(7));
				
		}
		return null;//Invalid login
	}
	public void cleanUp() throws SQLException{
		if(pst1!=null)
			pst1.close();
		if(cn!=null)
			cn.close();
		System.out.print("User Dao Cleanup !!");
	}
	

}
