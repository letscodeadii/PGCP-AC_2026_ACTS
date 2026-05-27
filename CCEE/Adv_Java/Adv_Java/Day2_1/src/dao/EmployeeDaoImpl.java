package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Employee;
import static utils.DBUtils.openConnection;

public class EmployeeDaoImpl implements IEmployeeDao {
	//STATE :instance vars
	private Connection cn;
	private PreparedStatement pst1;
	
	public EmployeeDaoImpl() throws SQLException {
		//get fix db connection from DBUtils
		cn=openConnection();
		pst1=cn.prepareStatement("select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?");
		System.out.println("emp dao created...");
	}

	@Override
	public List<Employee> getSelectedEmpDetails(String dept, Date beginDate, Date endDate) throws SQLException {
		List<Employee> emps=new ArrayList<Employee>();
		// set IN Params
		pst1.setString(1, dept);
		pst1.setDate(2, beginDate);
		pst1.setDate(3, endDate);
		try(ResultSet rst=pst1.executeQuery()){
			while(rst.next())
				emps.add(new Employee(rst.getInt(1),rst.getString(2),0,beginDate));
			
			
		}
		return null;
	}
	
	//add a method to clean up db resources 
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		if(cn!=null)
			cn.close();
		System.out.println("emp dao cleanup up !");
	}

}
