package com.emids.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.emids.Main.OnlineBookShop;
import com.emids.domain.Book;
import com.emids.utilities.UserInput;

public class ShoppingCart {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Book> bookList = new ArrayList<>();

	static void addBookToCart(Book book) {
		bookList.add(book);
	}

	static void addBookToCartFromBookShelf(Book book) {
		bookList.add(book);
	}

	static void showDetailsOfOrder() {
		System.out.println("Enter the quantity");
		int quantity = scanner.nextInt();
		double total = 0;
		for (int i = 0; i < bookList.size(); i++) {

			Book bookName = Product.bookList.get(i);
			total = bookName.getPrice() + total;
		}
		String GST = "18%";
		System.out.println("\nBill = " + total + "\n" + "Gst = " + GST + "\n" + "Quantity= " + quantity
				+ "\nTotal bill = " + (((total * 0.18) + total) * quantity) + "\n");
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
		System.out.println("Select payment Option \n Press 1 For COD \n Press 2 for Net Banking \n Press 3 to Cancel");
		int value = UserInput.getInput();
		if (value == 1 || value == 2) {
			System.out.println(" Thanks for Shopping\n Refresh the page");
			System.exit(0);
		} else if (value == 3) {
			System.out.println(" Thank you \n Refresh the page");
			System.exit(0);
		} else {
			System.err.println("Wrong Input");
			makePayment();
		}
	}

	public static void showCart() {
		boolean check = bookList.isEmpty();
		if (check) {
			System.out.println("Your Cart is Empty select from list\n******************\n");
			Product.getbook(Product.bookList);
			new Customer().userOption();
		} else {
			System.out.println("****Book Details****");
			Product.getbook(bookList);
		}
		cartOption();
	}

	static void cartOption() {
		System.out
				.println(" Enter 1 to remove book from cart \n Enter 2 to order book from list \n Enter 3 to exit\n");
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			int value = UserInput.selectSerialNumber() - 1;
			removeBookFromCart(value);
			break;
		case 2:
			placeOrder();
			break;
		case 3:
			OnlineBookShop.userTask();
			break;
		default:
			break;
		}
	}

	public static void removeBookFromCart(int value) {
		bookList.remove(value);
		System.out.println("Successfully removed\n*****************\n");
		showCart();
	}

	static void placeOrder() {
		System.out.println("Confirmation Page");
		showDetailsOfOrder();
	}
}
