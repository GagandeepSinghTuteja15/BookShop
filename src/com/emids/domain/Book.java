package com.emids.domain;

public class Book {
	private String bookName;
	private String author;
	private double price;

	public Book(String bookName, String author, double price2) {
		this.bookName = bookName;
		this.author = author;
		this.price = price2;
	}

	public Book() {
	}

	public String getName() {
		return this.bookName;
	}

	public String getAuthor() {
		return this.author;
	}

	public double getPrice() {
		return this.price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setName(String bookName) {
		this.bookName = bookName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return " name= " + getName() + " author=" + getAuthor() + " Price= " + getPrice() + "\n";
	}
}
