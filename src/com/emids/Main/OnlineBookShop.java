package com.emids.Main;

import java.util.Scanner;
import com.emids.services.Admin;
import com.emids.services.BookShelf;
import com.emids.services.Customer;
import com.emids.services.Inventory;
import com.emids.services.Product;
import com.emids.services.ShoppingCart;

public class OnlineBookShop {
	static Scanner scanner = new Scanner(System.in);

	public void adminTask() {
		System.out.println("Select appropriate option\n");
		System.out.println(
				" Enter 1 to add book \n Enter 2 to edit book \n Enter 3 to remove book \n Enter 4 See all the books \n Enter 5 to Exit");
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
	}

	public void userTask() {
		System.out.println(
				" Enter 1 to see all books \n Enter 2 to see your BookShelf \n Enter 3 to go to cart \n Enter 4 to search the book\n");
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
			new Inventory().searchProduct();
			break;
		default:
			break;
		}
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
			System.out.println("Incorrect User Name or Password\n");

	}
}
