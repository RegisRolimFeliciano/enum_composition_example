package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStaus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("E-mail: ");
		String email = sc.nextLine();
		System.out.println("Birth Date (DD/MM/YYYY):");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		OrderStaus status = OrderStaus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for (int i =0; i<n; i++ ) {
			System.out.println("Enter the #" + (i+1) + " item data");
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product Price: ");
			double price = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();	
			
			Product product = new Product(productName, price);
			OrderItem it = new OrderItem(quantity, price, product);
			
			order.addItem(it);
		}

		System.out.println();
		System.out.println(order);
		
		sc.close();

	}

}
