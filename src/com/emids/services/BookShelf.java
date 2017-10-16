package com.emids.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.emids.Main.BookShop;
import com.emids.domain.Book;

public class BookShelf {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Book> bookList = new ArrayList<>();

	public static void addBookToBookShelf(Book book) {
		bookList.add(book);
	}

	public static void removeBookFromShelf(int value) {
		bookList.remove(value);
		System.out.println("Removed Succesfully\n");
		showBookShelf();
	}

	public static void showBookShelf() {

		boolean check = bookList.isEmpty();
		if (check) {
			System.out.println("Your Cart is Empty select from list\n");
			Product.getbook(Product.list);
			new Customer().userOption();
		} else {
			Product.getbook(bookList);
			}
			bookShelfOption();
		}
		static void bookShelfOption()
		{
			System.out.println(" Enter 1 to to add book to cart \n Enter 2 to remove book from list \n Enter 3 to exist\n");
			int number = scanner.nextInt();
			Customer customer = new Customer();
			switch(number) {
			case 1:
					int value = customer.selectSerialNumber() - 1;
					Book bookToCart = bookList.get(value);
					ShoppingCart.addBookToCart(bookToCart);
					System.out.println("Book added to Cart");
					new BookShop().userTask();
					break;
			case 2:
					int value1 = customer.selectSerialNumber() - 1;
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
