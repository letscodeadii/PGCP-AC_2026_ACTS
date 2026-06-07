package org.day1;

import java.util.*;

import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

public class TableCreator {
	private static final String URL="jdbc:mysql://localhost:3306/dac_feb";
	private static final String USER="root";
	private static final String PASSWORD="Adii#@24aug";
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("\n===TABLE MANAGMENT===");
			System.out.println("1.Create Table");
			System.out.println("2.Dsiplay Column of a Table ");
			System.out.println("3.Exit");
			System.out.println("Enter a choice ");
			scanner.nextLine();//Consume new line
			
			switch(choice) {
			case 1:
				createTable(scanner);
				break;
			case 2:
				DisplayTable(scanner);
				break;
			case 3:
				System.out.println("Existing...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid Choice ! Try Again ");
			}
		}
	}
	
	//1.Create Table
	public static void createTable(Scanner scanner) {
		System.out.println("\n===CREATE TABLE===");
		System.out.println("Enter table name ");
		String tableName=scanner.nextLine();
		
		ArrayList<Column> columns=new ArrayList<>();
		
		String primaryKeyColumn=null;
		
		while(true) {
			System.out.println("\n===MENU===");
			System.out.println("a. Add Column");
			System.out.println("b. Set Primary Key");
			System.out.println("c. Save ");
			System.out.println("Choose Option (a/b/c): ");
			String option=scanner.nextLine();
			
			if(option.equalsIgnoreCase("a")) {
				//Add Column
				System.out.println("Enter Column Name ");
				String colName=scanner.nextLine();
				
				System.out.println("Select Datatype ");
				System.out.println("1. VARCHAR ");
				System.out.println("2. INT ");
				System.out.println("3. FLOAT ");
				System.out.println("Enter your choice (1/2/3): ");
				
				int typeChoice=scanner.nextInt();
				scanner.nextLine();
				
				String dataType="";
				switch(typeChoice) {
				case 1:
					dataType="VARCHAR(100)";
					break;
				case 2:
					dataType="INT";
					break;
				case 3:
					dataType="FLOAT";
					break;
				default:
					System.out.println("Invalid choice ! Using VARCHAR(100)");
					dataType="VARCHAR(100)";
				}
				
				columns.add(new Column(colName,dataType));
				System.out.println("Column ' "+colName+"' added successfully!");
			}else if(option.equalsIgnoreCase("b")) {
				//set Primary Key
				if(columns.isEmpty()) {
					System.out.println("No columns added yet ! Add Columns first : ");
					continue;
				}
				
				System.out.println("\n Available Columns ");
				for(int i=0;i< columns.size();i++) {
					System.out.println(i+1)+", "+columns.get(i).name);
				}
				
			}
		}
	}
	
	

}
