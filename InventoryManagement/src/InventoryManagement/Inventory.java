package InventoryManagement;
import java.util.*;
import java.io.*;

public class Inventory {
	private Map<Integer, Product>products=new HashMap<>();
	private static final String FILE_NAME="products.txt";
	//Load products from file
	public void loadProducts() {
		products.clear();
		try(BufferedReader br=new BufferedReader(new FileReader(FILE_NAME))){
			String line;
			while((line=br.readLine())!=null) {
				String[]parts=line.split(",");
				int id=Integer.parseInt(parts[0]);
				String name=parts[1];
				int qty=Integer.parseInt(parts[2]);
				double price=Double.parseDouble(parts[3]);
				products.put(id,new Product(id,name,qty,price));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("No products found.Starting with empty inventory.");
		}
	}
	//Save products to file
	public void saveProducts() {
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_NAME))){
			for (Product p:products.values()) {
				bw.write(p.toString());
				bw.newLine();
			}
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error saving products: " + e.getMessage());
		}
	}
	// Add Product
	public void addProduct(Product p) {
		if(products.containsKey(p.getid())) {
			System.out.println("Product with this ID already exists.");
		}
		else {
			products.put(p.getid(),p);
			saveProducts();
			System.out.println("Product added successfully!");
		}
	}
	//Update product
	public void updateProduct(int id, Product updated) {
		if(products.containsKey(id)) {
			products.put(id, updated);
			saveProducts();
			System.out.println("Product updated successfully!");
		}
		else {
			System.out.println("Product not found");
		}
	}
	//Delete product
	public void deleteProduct(int id) {
		if(products.remove(id)!=null) {
			saveProducts();
			System.out.println("Product deleted successfully!");
		}
		else {
			System.out.println("Product not found");
		}
	}
	//Search product
	public void searchProduct(int id) {
		Product p=products.get(id);
		if(p!=null) {
			System.out.println("Product Found: " + p);
		}
		else {
			System.out.println("Product not found");
		}
	}
	//Generate low stock report(quantity<=5)
	public void generateLowStockReport() {
		System.out.println("\n---Low Stock Products---");
		boolean found=false;
		for(Product p:products.values()) {
			if(p.getQuantity()<=5) {
				System.out.println(p);
				found=true;
			}
		}
		if(!found)System.out.println("No low stock products.");
	}
	//Display all products
	public void displayAll() {
		System.out.println("\n---All Products--");
		for(Product p:products.values()) {
			System.out.println(p);
		}
	}
}
