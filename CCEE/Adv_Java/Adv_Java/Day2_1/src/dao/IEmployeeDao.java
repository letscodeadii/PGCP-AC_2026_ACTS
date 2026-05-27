package dao;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDao {
	//Display details (id,name,salary,join,date) off all emps from a specific dept,
	//join between start date n end date

	List<Employee> getSelectedEmpDetails(String dept,Date beginDate ,Date endDate) throws SQLException;
	
}
