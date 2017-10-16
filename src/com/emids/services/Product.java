package com.emids.services;

import java.util.ArrayList;

import com.emids.domain.Book;

public class Product {
	public static ArrayList<Book> bookList = new ArrayList<>();

	public void setDemoBookData() {
		Book book = new Book("Java", "Halbert", 2000);
		Book book1 = new Book("Python", "Steve", 3000);
		Book book2 = new Book("C", "Balaguruswamy", 2200);
		bookList.add(book);
		bookList.add(book1);
		bookList.add(book2);
	}

	void add(Book book) {
		bookList.add(book);
	}

	public static void getbook(ArrayList<Book> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			count++;
			System.out.println(count + " " + list.get(i));
		}

	}

	void removeBook(int num) {
		bookList.remove(num);
	}

}
