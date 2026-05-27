package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import pojos.Employee;
import static utils.DBUtils.openConnection;

public class EmployeeDaoImpl implements IEmployeeDao {
	//STATE :instance vars
	private Connection cn;
	private PreparedStatement pst1;
	
	public EmployeeDaoImp() throws SQLException {
		//get fix db connection from DBUtils
		cn=openConnection();
		pst1=cn.prepareStatement("sle");
	}
	
	
	

	@Override
	public List<Employee> getSelectedEmpDetails(String dept, Date beginDate, Date endDate) throws SQLException {
		// TODO Auto-generated method stub 
		return null;
	}

}
