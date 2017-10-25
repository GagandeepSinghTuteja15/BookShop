package com.emids.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.emids.Main.OnlineBookShop;
import com.emids.domain.Book;
import com.emids.utilities.UserInput;

public class BookShelf {
	static Scanner scanner = new Scanner(System.in);
	public static ArrayList<Book> bookList = new ArrayList<>();

	public static void addBookToBookShelf(Book book) {
		bookList.add(book);
	}

	public static void removeBookFromShelf(int value) {
		bookList.remove(value);
		System.out.println("Removed from Book Shelf Succesfully\n********************************\n");
		showBookShelf();
	}

	public static boolean showBookShelf() {

		boolean check = bookList.isEmpty();
		if (check) {
			System.out.println("Your Book Shelf is Empty select from list\n*************************\n");
			Product.getbook(Product.bookList);
			new Customer().userOption();
			return true;
		} else 
			Product.getbook(bookList);
		return true;
	}

	static void bookShelfOption() {
		System.out.println(" Enter 1 to to add book to cart \n Enter 2 to remove book from list \n Enter 3 to exist\n");
		int number = UserInput.getInput();
		switch (number) {
		case 1:
			int value = UserInput.selectSerialNumber() - 1;
			Book bookToCart = bookList.get(value);
			ShoppingCart.addBookToCart(bookToCart);
			System.out.println("Book added to Cart\n**********************\n");
			removeBookFromShelf(value);
			OnlineBookShop.userTask();

			break;
		case 2:
			int value1 = UserInput.selectSerialNumber() - 1;
			removeBookFromShelf(value1);
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}
	}

}
