package tester;

import java.util.Scanner;

import dao.AccountDaoImpl;

public class TestStroredProc {
	
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			//created Dao Instance
			AccountDaoImpl dao=new AccountDaoImpl();
			System.out.println("Enter src dest a/c nos n ammount ");
			System.out.println(dao.tranferFunds(sc.nextInt(),sc.nextInt(),sc.nextInt()));
			dao.cleanUp();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
