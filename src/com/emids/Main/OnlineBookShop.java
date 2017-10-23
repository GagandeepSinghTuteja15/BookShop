package com.emids.Main;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


import com.emids.services.Admin;
import com.emids.services.BookShelf;
import com.emids.services.Customer;
import com.emids.services.Inventory;
import com.emids.services.Product;
import com.emids.services.ShoppingCart;

public class OnlineBookShop {
	static Scanner scanner = new Scanner(System.in);

	public InputStream adminTask() {
		System.out.println("Select appropriate option\n");
		System.out.println(" Enter 1 to add book \n Enter 2 to edit book \n Enter 3 to remove book \n Enter 4 See all the books \n Enter 5 to Exit");
		int value = scanner.nextInt();
		 Admin admin = new Admin();
		 
		switch (value) {
		case 1:
			admin.addbook();
			adminTask();
			break;
		case 2:
			admin.editBook();
			adminTask();
			break;
		case 3:
			admin.removeBook();
			adminTask();
			break;
		case 4:
			Product.getbook(Product.bookList);
			adminTask();
			break;
		case 5:
			System.out.println("Thank You \n Refresh the page");
		}
		if(value>5||value<1)
		return error(1);
		else
		return null;
	}

	private InputStream error(int value) {
		String value1=" "+value;
		System.out.println("Please Enter Correct Input\n");
		InputStream stream = new ByteArrayInputStream(value1.getBytes()); 
		if(value==1)
		adminTask();
		else
			userTask();
		return stream;

		
	}

	public InputStream userTask() {
		System.out.println(
				"********\n Enter 1 to see all books \n Enter 2 to see your BookShelf \n Enter 3 to go to cart \n Enter 4 to search the book\n");
		int value = scanner.nextInt();

		switch (value) {
		case 1:
			Product.getbook(Product.bookList);
			new Customer().userOption();
			break;

		case 2:
			BookShelf.showBookShelf();
			break;
		case 3:
			ShoppingCart.showCart();
			break;
		case 4:
			new Inventory().searchName();
			break;
		default:
			break;
		}

if(value>4||value<1)
	return error(2);
return null;
	}
	public static void main(String[] args) {
		Product product = new Product();
		product.setDemoBookData();
		System.out.println("WELCOME TO ONLINE BOOKSHOP");
		System.out.println("Please Enter your Name and Password");
		String name = scanner.next();
		String password = scanner.next();
		Admin admin = new Admin();
		String result = admin.checkDetails(name, password);
		OnlineBookShop bookshop = new OnlineBookShop();
		if (result.equals("adminExist")) {

			bookshop.adminTask();
		} else if (result.equals("CustomerExist")) {

			bookshop.userTask();
		} else 
			System.err.println("Incorrect User Name or Password\n");

	}
}
