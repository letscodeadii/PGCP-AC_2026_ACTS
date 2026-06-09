package tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class TestEmpCRUD {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			
			//created emp dao instance: init phase of app
			EmployeeDaoImpl dao=new EmployeeDaoImpl();
			boolean exit=false;
			while(!exit) {
				System.out.println("1. Get Emp Details 2. Insert Emp Details 10.Exit");
				try {
					switch(sc.nextInt()) {
					case 1://get emp details 
						System.out.println("Enter dept begin date n end date(yy-mm-dd)");
						List<Employee> empList = dao.getSelectedEmpDetails(sc.next(), Date.valueOf(sc.next()), Date.valueOf(sc.next()));
						empList.forEach(System.out::println);
						break;
						
					case 2:
						System.out.println("Enter employee details : Name | Addr | Salary | DeptId | Join_Date(yy-mm-dd) ");
					    System.out.println(dao.insertEmpDetails(new Employee(sc.next(),sc.next(),sc.nextDouble(),sc.next(),Date.valueOf(sc.next()))));   
						
					case 10://destroy(shut down):clean up d resources 
						exit=true;
						dao.cleanUp();
						break;
					}
				}catch(Exception e) {
					
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
