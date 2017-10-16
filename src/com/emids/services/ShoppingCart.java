package com.emids.services;

import java.util.ArrayList;
import java.util.Scanner;
import com.emids.domain.Book;

public class ShoppingCart {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Book> bookList = new ArrayList<>();

	static void addBookToCart(Book book) {
		bookList.add(book);
	}

	static void showDetailsOfOrder() {
		double total = 0;
		for (int i = 0; i < bookList.size(); i++) {

			System.out.println(bookList.get(i));
			Book bookName = Product.list.get(i);
			total = bookName.getPrice() + total;
		}
		String GST = "18%";
		System.out.println("\nBill is " + total + "\n" + "Gst is " + GST + "\n" + "Total bill is "
				+ ((total * 0.18) + total) + "\n");
		System.out.println("Shipping address is \n" + Customer.address + "\n");
		changeCustomerAddress();
	}

	static void changeCustomerAddress() {
		System.out.println("\n Press 1 to change Shipping Address \n Press 2 to Confirm");
		int value = scanner.nextInt();
		if (value == 1) {
			System.out.println("Enter Adress Separated by ','(Comma) without Space ");
			Customer.address = scanner.next();
			System.out.println("Upadted address is \n" + Customer.address + "\n");
			changeCustomerAddress();
		} else {
			makePayment();
		}
	}

	private static void makePayment() {
		System.out.println("Slect payment Option \n Press 1 For COD \n Press 2 for Net Banking \n Press 3 to Cancel");
		int value = scanner.nextInt();
		if (value == 1 || value == 2) {
			System.out.println("Thanks for Shopping");
			System.exit(0);
		} else if (value == 3)
			System.exit(0);
		else {
			System.out.println("Wrong Input");
			makePayment();
		}
	}

	public static void showCart() {
		boolean check = bookList.isEmpty();
		if (check) {
			System.out.println("Your Cart is Empty select from list\n");
			Product.getbook(Product.list);
			new Customer().userOption();
		} else {
			System.out.println("****Book Details****");
			Product.getbook(bookList);
	}	
		cartOption();
		}
		
	
	static void cartOption()
	{
		System.out.println(
				" Enter 1 to remove book from cart \n Enter 2 to order book from list \n Enter 3 to exist\n");
		int number = scanner.nextInt();
		Customer customer = new Customer();
		switch(number) {
		case 1:
			int value = customer.selectSerialNumber() - 1;
			removeBookFromCart(value);
				break;
		case 2:
			placeOrder();
				break;
		case 3:
				System.exit(0);
				break;
		default:
			break;
		}
	}
	public static void removeBookFromCart(int value) {
		bookList.remove(value);
		System.out.println("Successfully removed\n");
		showCart();
	}

	static void placeOrder() {
		System.out.println("Confirmation Page");
		showDetailsOfOrder();
	}
}
