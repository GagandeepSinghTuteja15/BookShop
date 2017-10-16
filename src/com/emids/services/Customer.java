package com.emids.services;

import java.util.Scanner;

import com.emids.Main.BookShop;
import com.emids.domain.Book;

public class Customer {
	String customerName = "user";
	String customerPassword = "user";
	static String address = "Champak Pragati Tower Bangalore";
	Scanner scanner = new Scanner(System.in);

	String checkCustomer(String customerName, String customerPassword) {
		if (customerName.equals(this.customerName) && customerPassword.equals(this.customerPassword)) {
			return "CustomerExist";
		} else
			return "NoMatch";
	}

	public int selectSerialNumber() {
		System.out.println("Write serial no to Select book\n");
		int num = scanner.nextInt();
		return num;
	}

	public void userOption() {
		System.out.println(
				" Enter 1 to add book to cart \n Enter 2 to add to Bookshelf \n Enter 3 to search \n Enter 4 to go back\n");
		int value = scanner.nextInt();
		switch (value) {
		case 1:
			int numCart = selectSerialNumber() - 1;
			Book bookToCart = Product.bookList.get(numCart);
			ShoppingCart.addBookToCart(bookToCart);
			System.out.println("Book added to Cart\n");
			userOption();
			break;
		case 2:
			int numShelf = selectSerialNumber() - 1;
			Book bookToShelf = Product.bookList.get(numShelf);
			BookShelf.addBookToBookShelf(bookToShelf);
			System.out.println("Book added to Book Shelf\n");
			userOption();
			break;
		case 3:
			new Inventory().searchProduct();
			break;
		case 4:
			new BookShop().userTask();
			break;
		}

	}
}
