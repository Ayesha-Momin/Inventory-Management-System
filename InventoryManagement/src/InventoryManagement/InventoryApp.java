package InventoryManagement;
import java.util.*;
import java.util.Scanner;

public class InventoryApp {
	public static void main(String args[]) {
	Inventory inventory=new Inventory();
	inventory.loadProducts();
	Scanner sc=new Scanner(System.in);
	int choice;
	do {
		System.out.println("Inventory Management System");
		System.out.println("1.Add Product");
		System.out.println("2.Update Product");
		System.out.println("3.Delete Product");
		System.out.println("4.Search Product");
		System.out.println("5.Low Stock Product");
		System.out.println("6.Display All Product");
		System.out.println("7.Exit");
		System.out.println("Enter Choice: ");
		choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:{
			System.out.println("Enter ID: ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Name: ");
			String name=sc.nextLine();
			System.out.println("Enter Quantity: ");
			int qty=sc.nextInt();
			System.out.println("Enter Price: ");
			double price=sc.nextDouble();
			inventory.addProduct(new Product(id,name,qty,price));
		}
		
		case 2:{
			System.out.println("Enter ID to update: ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter New Name: ");
			String name=sc.nextLine();
			System.out.println("Enter New Quantity: ");
			int qty=sc.nextInt();
			System.out.println("Enter New Price: ");
			int price=sc.nextInt();
			inventory.updateProduct(id,new Product(id,name,qty,price));
		}
		
		case 3:{
			System.out.println("Enter ID to Delete:");
			int id=sc.nextInt();
			inventory.deleteProduct(id);
		}
		
		case 4:{
			System.out.println("Enter ID to Search: ");
			int id=sc.nextInt();
			inventory.searchProduct(id);
		}
		
		case 5:{
			inventory.generateLowStockReport();
		}
		
		case 6:{
			inventory.displayAll();
		}
		
		case 7:{
			System.out.println("Existing... Thank You");
		}
		
		default:{
			System.out.println("Invalid choice,Try Again");
		}
		}
		}while(choice !=7);
		sc.close();
	}
	}


