package com.emids.JunitTest;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.emids.domain.Book;
import com.emids.services.Admin;
import com.emids.services.Product;

public class AdminTest {
	@Test
	public void whenAdminValidationTrue() {
		Admin admin = new Admin();

		Assert.assertEquals("adminExist", admin.checkDetails("gagan", "gagan"));
	}

	@Test
	public void whenAdminValidationFalse() {
		Admin admin = new Admin();

		Assert.assertEquals("NoMatch", admin.checkDetails("user", "gagan"));
	}
     @Test
	public void whenAdminAddBookToList()
	{
		Product product=new Product();
		Book book=new Book("java", "gagan", 123.3);
		product.add(book);
		Assert.assertEquals(1,Product.bookList.size());
	}
     @Test
 	public void whenAdminRemoveBook()
 	{
    	 ArrayList<Book> sampleForTest=new ArrayList<>();
    	 Book book=new Book("java", "gagan", 123.3);
    	 sampleForTest.add(book);
    	 
    	boolean result=Product.getbook(sampleForTest);
 		if(result) {
    	Product product=new Product();
 		product.removeBook(0);
 		Assert.assertEquals(0,Product.bookList.size());
 		
 	}
 	}   
}


