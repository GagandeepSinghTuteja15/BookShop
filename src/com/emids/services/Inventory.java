package com.emids.services;

import java.util.Scanner;

import com.emids.Main.OnlineBookShop;
import com.emids.domain.Book;

public class Inventory {
	Scanner scanner = new Scanner(System.in);

	public void searchProduct() {
		System.out.println(" **********\n Enter 1 to search by book name \n Enter 2 to search by author name\n");
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
		search(searchedAuthorName);
		System.err.println("Book Not Found\n");
		new OnlineBookShop().userTask();
	}

	private void search(String searchData) {
		for (int i = 0; i < Product.bookList.size(); i++) {
			Book Dataname = Product.bookList.get(i);
			if (searchData.equalsIgnoreCase(Dataname.getAuthor())) {
				System.out.println(Product.bookList.indexOf(Dataname) + 1 + " " + Dataname);
				new Customer().userOption();
			}
			else if(searchData.equalsIgnoreCase(Dataname.getName())){
				System.out.println(Product.bookList.indexOf(Dataname) + 1 + " " + Dataname);
				new Customer().userOption();
			}
		}
	}

	private void searchByBookName() {
		System.out.println("Enter book Name\n");
		String searchedBookName = scanner.next();
		search(searchedBookName);
		System.err.println("Book Not Found\n");
		new OnlineBookShop().userTask();

	}
}
