package dao;

import java.sql.SQLException;

public interface IAccountDao {
	//add a method to transfer funds from src--> dest a/c
	String tranferFunds(int srcAcctNo,int destAcctNo, double amount)throws SQLException;
}
