package com.emids.services;

import java.util.Scanner;

import com.emids.Main.OnlineBookShop;
import com.emids.domain.Book;
import com.emids.utilities.UserInput;

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

	

	public boolean userOption() {
		System.out.println(
				" *************\n Enter 1 to add book to cart \n Enter 2 to add to Bookshelf \n Enter 3 to search \n Enter 4 to go back \n");
		int value = UserInput.getInput();		
		if(value==1||value==2)
		{
			addTo(value);
			return true;
		}
		else if(value==3) {
			new Inventory().searchName();
			return true;
		}
		else
			OnlineBookShop.userTask();
		return true;

	}

	private boolean addTo(int value) {
		int numCart = UserInput.selectSerialNumber() - 1;
		Book book = Product.bookList.get(numCart);
		if(value==1) {
		ShoppingCart.addBookToCart(book);
		System.out.println("Book added to Cart\n*******************\n");
		return true;
		}
		else {
			BookShelf.addBookToBookShelf(book);
			System.out.println("Book added to Book Shelf\n*******************\n");
			
		}
		userOption();
		return false;
	}
}
