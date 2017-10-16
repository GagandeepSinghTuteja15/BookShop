package com.emids.Main;

import java.util.Scanner;
import com.emids.services.Admin;
import com.emids.services.BookShelf;
import com.emids.services.Customer;
import com.emids.services.Inventory;
import com.emids.services.Product;
import com.emids.services.ShoppingCart;

public class BookShop {
	static Scanner scanner = new Scanner(System.in);

	void adminTask() {
		System.out.println("Select appropriate option\n");
		System.out.println(" Enter 1 to add book \n Enter 2 to edit book \n Enter 3 to remove book \n Enter 4 Search a book \n Enter 5 to Exit");
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
			new Inventory().searchProduct();
			break;
		case 5:
			System.exit(0);
		}
	}

	public void userTask() {
		System.out.println(
				" Enter 1 to see all books \n Enter 2 to see your BookShelf \n Enter 3 to go to cart \n Enter 4 to search the book\n");
		int value = scanner.nextInt();

		switch (value) {
		case 1:
			Product.getbook(Product.list);
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
		default:break;
		}
	}

	public static void main(String[] args) {
		Product product = new Product();
		product.setDemoBookData();
		System.out.println("WELCOME TO BOOKSHOP");
		System.out.println("PLease Enter your Name and Password");
		String name = scanner.next();
		String password = scanner.next();
		Admin admin = new Admin();
		String result = admin.checkDetails(name, password);
		BookShop bookshop = new BookShop();
		if (result.equals("adminExist")) {

			bookshop.adminTask();
		} else if (result.equals("CustomerExist")) {

			bookshop.userTask();
		} else
			System.out.println("Incorrect User name or Password\n");

	}
}