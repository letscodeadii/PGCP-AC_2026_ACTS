package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import pojos.Employee;
import static utils.DBUtils.openConnection;

public class EmployeeDaoImpl implements IEmployeeDao {
	//STATE :instance vars
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4,pst5;
	
	public EmployeeDaoImpl() throws SQLException {
		//get fix db connection from DBUtils
		cn=openConnection();
		pst1=cn.prepareStatement("select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?");
		pst2=cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		pst3=cn.prepareStatement("update my_emp set salary=salary+?,dept=? where empId=?");
		pst4=cn.prepareStatement("Delete from my_emp where empId=?");
		pst4=cn.prepareStatement("select deptid,avg(salary) from my_emp group by deptid");
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
				emps.add(new Employee(rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4)));
		}
		return emps; 
	}

	
	
	
	@Override
	public String insertEmpDetails(Employee employee) throws SQLException {
		// set in params
		//name    | addr   | salary | deptid | join_date
		pst2.setString(1,employee.getName());
		pst2.setString(2,employee.getAddress());
		pst2.setDouble(3, employee.getSalary());
		pst2.setString(4, employee.getDeptId());
		pst2.setDate(5, employee.getJoinDate());
		//execute the query : insert : DML : Method of PST : public int executeUpdate() throws SQLException
		int updateCount=pst2.executeUpdate();
		if(updateCount==1)
			return "Emp Details Inserted...";
		return "Emp details insertion failed...";
	}
	
	

	@Override
	public String updateEmpDetails(int empId, double salIncr, String newDept) throws SQLException {
		// set in Params
		pst3.setDouble(1, salIncr);
		pst3.setString(2, newDept);
		pst3.setInt(3, empId);
		int updateCount=pst3.executeUpdate();
		if(updateCount==1)
			return "Emp details Updated";
		return "Emp details Updation failed";
	}
	
	

	@Override
	public String deleteEmpDetails(int empId) throws SQLException {
		pst4.setInt(1,empId);
		int updateCount=pst4.executeUpdate();
		if(updateCount==1)
			return "Emp details deleted";
		return "Emp details deletion failed";
	}
	
	

	@Override
	public Map<String, Double> getAvgSalaryByDept() throws SQLException {
		Map<String,Double> map=new LinkedHashMap<>();
		try(ResultSet rst=pst5.executeQuery())
		{
			while(rst.next())
				map.put(rst.getString(1), rst.getDouble(2));
				
		}
		
		return null;
	}

	//add a method to clean up db resources 
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
		if(pst3!=null)
			pst3.close();
		if(pst4!=null)
			pst4.close();
		
		if(cn!=null)
			cn.close();
		System.out.println("emp dao cleanup up !");
	}

}
