package com.emids.services;

import java.util.Scanner;

import com.emids.Main.OnlineBookShop;
import com.emids.domain.Book;

public class Customer {
	String customerName = "user";
	String customerPassword = "user";
	static String address = "Champak Pragati Tower Bangalore, 560010";
	Scanner scanner = new Scanner(System.in);

	String checkCustomer(String customerName, String customerPassword) {
		if (customerName.equals(this.customerName) && customerPassword.equals(this.customerPassword)) {
			return "CustomerExist";
		} else
			return "NoMatch";
	}

	public int selectSerialNumber() {
		System.out.println("Write serial no to Select book\n");
		int number = scanner.nextInt();
		return number;
	}

	public void userOption() {
		System.out.println(
				" *************\n Enter 1 to add book to cart \n Enter 2 to add to Bookshelf \n Enter 3 to search \n Enter 4 to go back \n");
		int value = scanner.nextInt();
		
		if(value==1||value==2)
		{
			addTo(value);
		}
		else if(value==3) {
			new Inventory().searchName();
		}
		else
			new OnlineBookShop().userTask();

	}

	private void addTo(int value) {
		int numCart = selectSerialNumber() - 1;
		Book book = Product.bookList.get(numCart);
		if(value==1) {
		ShoppingCart.addBookToCart(book);
		System.out.println("Book added to Cart\n*******************\n");
		}
		else {
			BookShelf.addBookToBookShelf(book);
			System.out.println("Book added to Book Shelf\n*******************\n");
		}
		userOption();
	}
}
