package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import static utils.DBUtils.openConnection;

public class AccountDaoImpl implements IAccountDao {
	
	private Connection cn;
	private CallableStatement cst1;
	
	public AccountDaoImpl()throws SQLException {
		//get DB cn from DBUtils
		cn=openConnection();
		//cst:to represent invocation of a stored procedure 
		cst1=cn.prepareCall("{call transfer_funds(?,?,?,?,?)}");
		//register OYT Parameter
		//API OF CST public void registerOutParameter(int paramsPos,int jdbcTYpe)throws SQLException
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("Account Dao Created...");
	}

	@Override
	public String tranferFunds(int srcAcctNo, int destAcctNo, double amount) throws SQLException {
		//Set in Params
		cst1.setInt(1,srcAcctNo);
		cst1.setInt(2,destAcctNo);
		cst1.setDouble(3,amount);
		//execute stored procedure
		cst1.execute();
		return "Updated Src Balanced"+cst1.getDouble(4)+"Desi Balanced"+cst1.getDouble(5);
	}
	
	//add a method to clean up db resources
	public void cleanUp() throws SQLException{
		if(cst1!=null)
			cst1.close();
		if(cn!=null) {
			cn.close();
		}
		System.out.println("Account Dao Created ");
	}

}
