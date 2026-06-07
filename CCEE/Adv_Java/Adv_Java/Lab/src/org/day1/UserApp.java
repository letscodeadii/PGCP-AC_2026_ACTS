package org.day1;

import java.sql.*;
import java.util.Scanner;

public class UserApp {
	private static final String URL = "jdbc:mysql://localhost:3306/dac_feb";
	private static final String USER = "root";
	private static final String PASSWORD = "Adii#@24aug";
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("\n======USER MANAGEMENT=====");
			System.out.println("1.Rgister a User"); 
			System.out.println("2.List all Users based on City ");
			System.out.println("3.Update Password of a user");
			System.out.println("4.Display user information based on User Name");
			System.out.println("5.Exit");
			
			System.out.println("Enter your choice : ");
			choice=scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:registerUser(scanner);
			       break;
			case 2:listUsersCity(scanner);
			       break;
			case 3:updatePassword(scanner);
			       break;
			case 4:displayUserByName(scanner);
			       break;
			case 5:System.out.println("Existing...");
			       scanner.close();
			       return;
			default:System.out.println("Invalid choice! Try again. ");
			}
		}
	}
	//1.Register a user
	public static void registerUser(Scanner scanner) {
		System.out.println("\n===Rgister User====");
		System.out.println("Enter a username ");
		String username=scanner.nextLine();
		System.out.println("Enter a password ");
		String password=scanner.nextLine();
		System.out.println("Enter name ");
		String name=scanner.nextLine();
		System.out.println("Enter a email");
		String email=scanner.nextLine();
		System.out.println("Enter city");
		String city=scanner.nextLine();
		
		String sql="INSERT INTO users VALUES(?,?,?,?,?)";
		
		try(Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement psInsert= connection.prepareStatement(sql)){
			
			psInsert.setString(1,username);
			psInsert.setString(2,password);
			psInsert.setString(3,name);
			psInsert.setString(4,email);
			psInsert.setString(5,city);
			
			int rows=psInsert.executeUpdate();
			if(rows>0) {
				System.out.println("User registered successfully ");	
			}
			
		}catch(SQLException e) {
			System.out.println("Error registering User : "+e.getMessage());
			e.printStackTrace();
			}
		}
	
	//List All Users based on city 
	public static void listUsersCity(Scanner scanner) {
		System.out.println("\n===LIST USERS BY CITY===");
		
		System.out.println("Enter city name");
		String city=scanner.nextLine();
		
		String sql="SELECT * FROM users WHERE city= ?";
		
		try(Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement psSelect=connection.prepareStatement(sql)){
			
			psSelect.setString(1, city);
			ResultSet result=psSelect.executeQuery();
			
			boolean found=false;
			System.out.println("\n Users in "+city+": ");
			System.out.println("========================");
			
			while(result.next()) {
				found=true;
				System.out.println("Username :"+result.getString("username"));
				System.out.println("Name :"+result.getString("name"));
				System.out.println("City :"+result.getString("city"));
				System.out.println("========================================");
			}
			if(!found) {
				System.out.println("No Users found in "+city);
			}
		}catch(SQLException e) {
			System.out.println("Error listing users : "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Update password of a users
	public static void updatePassword(Scanner scanner) {
		System.out.println("\n===UPDATE PASSWORD===");
		System.out.println("Enter Username : ");
		String username=scanner.nextLine();
		System.out.println("Enter Password ");
		String newpassword=scanner.nextLine();
		
		String sql= "UPDATE users SET password =? WHERE username = ?";
		
		try(Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement psUpdate=connection.prepareStatement(sql)){
			
			psUpdate.setString(1,newpassword);
			psUpdate.setString(2, username);
			
			int rows=psUpdate.executeUpdate();
			if(rows>0) {
				System.out.println("Password upated successfully ");
			}else {
				System.out.println("Users not found");
			}
		}catch(SQLException e) {
			System.out.println("Error updateing password "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Display user information based on User Name
	public static void displayUserByName(Scanner scanner) {
		System.out.println("===Display User By Name===");
		System.out.println("Enter username ");
		String username=scanner.nextLine();
		
		String sql="SELECT * FROM users WHERE username = ?";
		
		try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement psSelect=connection.prepareStatement(sql)){
			
			psSelect.setString(1, username);
			ResultSet result=psSelect.executeQuery();
			
			if(result.next()){
				System.out.println("===User Information===");
				System.out.println("Username: "+ result.getString("username"));
				System.out.println("Password: "+result.getString("username"));
				System.out.println("Name: "+result.getString("name"));
				System.out.println("Email: "+result.getString("email"));
				System.out.println("City: "+result.getString("city"));
			}else {
				System.out.println("USer Not Found");
			}
		}catch(SQLException e) {
			System.out.println("Error Displaying user: "+e.getMessage());
			e.printStackTrace();
		}
	}
}


