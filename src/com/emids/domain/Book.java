package com.emids.domain;

public class Book {
	private String bookName;
	private String author;
	private int price;

	public Book(String bookName, String author, int price) {
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public Book() {
	}

	public String getName() {
		return this.bookName;
	}

	public String getAuthor() {
		return this.author;
	}

	public int getPrice() {
		return this.price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setName(String bookName) {
		this.bookName = bookName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return " name= " + getName() + " author=" + getAuthor() + " Price= " + getPrice() + "\n";
	}
}
