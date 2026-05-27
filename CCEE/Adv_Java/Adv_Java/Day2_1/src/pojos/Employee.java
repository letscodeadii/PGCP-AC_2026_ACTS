package pojos;
//empid | name    | addr   | salary | deptid | join_date

import java.sql.Date;

public class Employee {
	private int empId;
	private String name;
	private String address;
	private double salary;
	private String deprId;
	private Date joinDate;
	//POJO specs: required in hibernate : def arr-less ctor
	public Employee() {
		//not required in JDBC
	}
	//construct
	public Employee(int empId, String address, double salary, Date joinDate) {
		super();
		this.empId = empId;
		this.address = address;
		this.salary = salary;
		this.joinDate = joinDate;
	}
	
	//getter n setter
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDeprId() {
		return deprId;
	}
	public void setDeprId(String deprId) {
		this.deprId = deprId;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	//toString for debugging purpose;
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", deprId=" + deprId + ", joinDate=" + joinDate + "]";
	}
	

}
