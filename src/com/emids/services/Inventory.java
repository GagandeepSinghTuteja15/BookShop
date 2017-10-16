package com.emids.services;

import java.util.Scanner;

import com.emids.domain.Book;

public class Inventory {
	Scanner scanner = new Scanner(System.in);

	public void searchProduct() {
		System.out.println(" Enter 1 to search by book name \n Enter 2 to search by author name\n");
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
		for (int i = 0; i < Product.list.size(); i++) {
			Book authorName = Product.list.get(i);
			if (searchedAuthorName.equalsIgnoreCase(authorName.getAuthor())) {
				System.out.println(authorName);
				new Customer().userOption();
			} else {
				System.out.println("Author Not Found\n");
				new Customer().userOption();
			}
		}
		new Customer().userOption();
	}

	private void searchByBookName() {
		System.out.println("Enter book Name\n");
		String searchedBookName = scanner.next();
		for (int i = 0; i < Product.list.size(); i++) {
			Book bookName = Product.list.get(i);
			if (searchedBookName.equalsIgnoreCase(bookName.getName())) {
				System.out.println(bookName);
				new Customer().userOption();
				break;
			} else {
				System.out.println("Book Not Found\n");
				new Customer().userOption();
			}
		}
		
	}
}
