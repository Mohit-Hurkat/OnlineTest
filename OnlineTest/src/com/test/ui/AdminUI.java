package com.test.ui;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import com.test.bean.Admin;
import com.test.bl.AdminLogic;
import com.test.bl.StudentLogic;


public class AdminUI {
//	
	private AdminLogic adminbl = new AdminLogic();
	private StudentLogic studentbl = new StudentLogic();
	private static final String MENU_OPTIONS = "1.Admin Related Tasks" +
			"\n" + "2. Student Realted Tasks" + "\n" + "3. Question Related Tasks" +
			"\n" + "4. Subject Related Tasks" + "\n" + "5. Exit"; 
	/*private static final String CATALOGUE_DISPLAY_FAILED_MSG =
			"Could not display product catalogue";
	private static final String NONEXISTENT_PRODUCT_MSG = 
			"Product does not exist";
	private static final String PRODUCT_DISPLAY_FAILED_MSG = 
			"Product display failed";
	private static final String CHECKOUT_FAILED_MSG =
			"Checkout failed";
	private static final String PRODUCT_NOT_IN_CART_MSG = 
			"Product is not in cart";
	private static final String EXIT_MSG = "Exit";
	private static final String ERROR_DESC_PREFIX_MSG = "Error";
	private static final String INVALID_CHOICE_MSG = "Invalid Choice";*/
	
	
	/*public CustomerUI(Customer customer) {
		this.customer = customer;
		cbl.assignCartToCustomer(customer);
		shoppingCart = CustomerCartMap.getCartFromCustomer(customer);
	}*/
	
	public void displayMenu(){
		System.out.println(MENU_OPTIONS);
	}
	
	public boolean choice(int choice) {
		Scanner scanner =null;
		String username,pass;
		
		switch(choice){
		case 1:
				int ch;
				System.out.println("1.Insert New Admin");
				System.out.println("2.Update Admin Password");
				System.out.println("3.Delete Admin");
				System.out.println("4.Exit");
				scanner= new Scanner(System.in);
				ch=scanner.nextInt();
				switch(ch)
				{
				case 1:
					System.out.println("Enter UserName:");
					username=scanner.next();
					System.out.println("Enter password:");
					pass=scanner.next();
					Admin admin=new Admin(username,pass);
					adminbl.insert(admin);
					break;
				case 2:
					username=admin.getUsername();
					System.out.println("Update Password");
					pass=scanner.next();
					adminbl.update(username, pass);
					break;
				case 3:
					username=admin.getUsername();
					System.out.println("Enter Username You Want To Delete:");
					pass=scanner.next();
					adminbl.delete(username, pass);
					break;
				case 4:
					displayMenu();
					break;
				default:
						System.out.println("Invalid Choice");
						choice(1);
				}
			break;
		case 2:		
			int cha;
			System.out.println("1.Search Student");
			System.out.println("2.Delete Student");
			System.out.println("3.List All Students");
			System.out.println("4.Exit");
			scanner= new Scanner(System.in);
			cha=scanner.nextInt();
			switch(cha)
			{
			case 1:
				System.out.println("Enter Student's UserName You Want To Search:");
				username=scanner.next();
				studentbl.search(username);
				break;
			case 2:
				System.out.println("Enter Student's UserName You Want To Delete:");
				username=scanner.next();
				studentbl.delete(username);
				break;
			case 3:
				 
				System.out.println("List Of All Students:");
				studentbl.displayAll();
				break;
			case 4:
				displayMenu();
				break;
			default:
					System.out.println("Invalid Choice");
					choice(2);
			}
			 
			break;
		case 3:
			int chaa;
			System.out.println("1.Insert a question");
			System.out.println("2.Update a question");
			System.out.println("3.Delete a Question");
			System.out.println("4.Search a Question");
			System.out.println("5.Display all Questions");
			System.out.println("6.Exit");
			switch(chaa)
			{
			case 1:
				System.out.println("Write the Question"+
						"/n What is 2+2?");
				studentbl.search(username);
				break;
			case 2:
				System.out.println("Enter Student's UserName You Want To Delete:");
				username=scanner.next();
				studentbl.delete(username);
				break;
			case 3:
				 
				System.out.println("List Of All Students:");
				studentbl.displayAll();
				break;
			case 4:
				 
				System.out.println("List Of All Students:");
				studentbl.displayAll();
				break;
			case 5:
				displayMenu();
				break;
			default:
					System.out.println("Invalid Choice");
					choice(2);
			}
			 
			break;
		case 4:
			System.out.println(shoppingCart.getProducts());
			break;
		case 5:
			 
			break;
		 
		default:
			System.out.println("INVALID CHOICE.");
			displayMenu();
		}
		return true;
	}
	
	
	
	
	
}
