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
				System.out.println("1. Get Emp Details 10.Exit");
				try {
					switch(sc.nextInt()) {
					case 1://get emp details 
						System.out.println("Enter dept begin date n end date(yy-mm-dd)");
						List<Employee> empList = dao.getSelectedEmpDetails(sc.next(), Date.valueOf(sc.next()), Date.valueOf(sc.next()));
						empList.forEach(System.out::println);
						break;
						
					case 2://destroy(shut down):clean up d resources 
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
