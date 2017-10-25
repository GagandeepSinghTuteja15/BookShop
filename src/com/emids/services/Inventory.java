package com.emids.services;

import java.util.Scanner;

import com.emids.Main.OnlineBookShop;
import com.emids.domain.Book;

public class Inventory {
	Scanner scanner = new Scanner(System.in);

	public void searchName() {
		System.out.println("Enter Author Name or Book Name to Search\n");
		String searchName = scanner.next();
		for (int i = 0; i < Product.bookList.size(); i++) {
			Book bookData = Product.bookList.get(i);
			if (searchName.equalsIgnoreCase(bookData.getAuthor()) || searchName.equalsIgnoreCase(bookData.getName())) {
				System.out.println("SrNo "+ (Product.bookList.indexOf(bookData) +1)+ " " + bookData);
				new Customer().userOption();
			}
		}
		System.out.println("Book Not Found\n");
		OnlineBookShop.userTask();
	}

}
