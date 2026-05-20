package LabExam;

import java.util.*;//Import Scanner , Arraylist, Iterator
import java.util.*;//Import date and time classes 
import java.time.format.DateTimeFormatter;//for formatting date(not used here)

class GroceryItem { // Class to represent one grocery item
	String name; // Variable to store item name
	double price; // Variable to store price per unit
	int quantity; // Variable to store quantity in stock
	LocalDateTime lastUpdated; // Variable to store last update date and time

	// Constructor to initialize Object
	GroceryItem(String name, double price int quantity ){
				this.name = name; //Assign name
				this.price = price; //Assign Price
				this.quantity = quantity; //Assign quantity 
				this.lastUpdated =LocalDateTime.now(); //set Current date and time
				
	// Method to update quantity
	void updateQuanity(int newQuantity) {
		this.quantity = newQuantity; // Update quantity
		this.lastUpdated = LocalDateTime.now(); // Update time
	}

	// Method to display item details
	void display() {
		System.out.println("Name : " + name + // Print name
				", Price : " + price + // Print price
				", Quantity : " + quantity + // Print quantity
				", Updated: " + lastUpdated); // print last update time
	}
}

public class GroceryApp { // Main class
	public static void main(String[] args) { // Main method (Program start here)
		Scanner sc=new scanner(System.in); //Create Scanner object for input
		ArrayList<groceryitem> =new ArrayList<>(); //create list to store items
		int choice; //Variable to store user choice 
		//Display menu Options
		do { //Loop starts (runs until user exit)
			//Display menu options
			System.out.println("\n1. Add Items");
			System.out.println("\n2. Update items");
			System.out.println("\n3. Dispaly Items");
			System.out.println("\n4. Remove Empty Stock");
			System.out.println("\n5. Show Recently Updated (Last 3 days)");
			System.out.println("\n6. Exit");
			
			System.out.println("Enter Choice");
			choice =sc.nextInt();
			sc.nextline();
			
			switch(choice) {
			case 1: //Add new item
				
				System.out.println("Enter name ");
				String name=sc.nextLine(); //Read item name
				
				System.out.println("Enter Price ");
				double price=sc.nextDouble();//Read Price
				
				System.out.println("Enter quantity ");
				int qty=sc.nextInt();//Read Quantity 
				
				list.add(new GroceryItem(name,price,qty)); //Add items to list 
				System.out.println("Item added!"); // Confirmation 
				break;
				
			case 2: 
			}
			
			
		}
	}
}}
