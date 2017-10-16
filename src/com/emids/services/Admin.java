package com.emids.services;

import java.util.Scanner;

import com.emids.Main.OnlineBookShop;
import com.emids.domain.Book;

public class Admin {
	String adminName = "gagan";
	String adminPassword = "gagan";

	Scanner scanner = new Scanner(System.in);
	Product product = new Product();

	public String checkDetails(String name, String password) {
		if (name.equals(this.adminName) && password.equals(this.adminPassword)) {
			return "adminExist";
		} else {
			return new Customer().checkCustomer(name, password);
		}

	}

	public void addbook() {
		System.out.println("Enter Book name");
		String name = scanner.next();
		System.out.println("Enter Author name");
		String author = scanner.next();
		System.out.println("Enter Price");
		int price = scanner.nextInt();
		Book book = new Book(name, author, price);
		product.add(book);
		System.out.println("Book added\n");
		Product.getbook(Product.bookList);
	}

	public void removeBook() {
		Product product = new Product();
		if (Product.bookList.size() == 0) {
			System.out.println("No book to remove");
			new OnlineBookShop().adminTask();
		}
		Product.getbook(Product.bookList);
		System.out.println("Select serial no");
		int number = scanner.nextInt();
		number = number - 1;
		product.removeBook(number);
		System.out.println("Book removed successfully\n");
		Product.getbook(Product.bookList);
	}

	public void editBook() {
		Product.getbook(Product.bookList);
		int number = new Customer().selectSerialNumber();
		System.out.println("Enter Book Name , Book Author Name, Book Price ");
		String updatedBookName = scanner.next();
		String updatedAuthorName = scanner.next();
		int updatedPrice = scanner.nextInt();
		Book book = Product.bookList.get(number - 1);
		book.setAuthor(updatedAuthorName);
		book.setName(updatedBookName);
		book.setPrice(updatedPrice);
		System.out.println("Book details updated\n");
		Product.getbook(Product.bookList);
	}
}
