package com.emids.services;

import java.util.Scanner;

import com.emids.Main.OnlineBookShop;
import com.emids.domain.Book;

public class Inventory {
	Scanner scanner = new Scanner(System.in);

	public void searchProduct() {
		System.out.println(" **********\nEnter 1 to search by book name \n Enter 2 to search by author name\n");
		int value = scanner.nextInt();
		if (value == 1) {
			searchByBookName();
		} else {
			searchByAuthorName();
		}
	}

	private void searchByAuthorName() {
		System.out.println("Enter Author Name\n");
		String searchedAuthorName = scanner.next();
		for (int i = 0; i < Product.bookList.size(); i++) {
			Book authorName = Product.bookList.get(i);
			if (searchedAuthorName.equalsIgnoreCase(authorName.getAuthor())) {
				System.out.println(Product.bookList.indexOf(authorName) + 1 + " " + authorName);
				new Customer().userOption();
			}
		}
		System.err.println("Book Not Found\n");
		new OnlineBookShop().userTask();
	}

	private void searchByBookName() {
		System.out.println("Enter book Name\n");
		String searchedBookName = scanner.next();
		{
			for (int i = 0; i < Product.bookList.size(); i++) {
				Book bookName = Product.bookList.get(i);
				if (searchedBookName.equalsIgnoreCase(bookName.getName())) {
					System.out.println(Product.bookList.indexOf(bookName) + 1 + " " + bookName);
					new Customer().userOption();
				}
			}
		}
		System.err.println("Book Not Found\n");
		new OnlineBookShop().userTask();

	}
}
