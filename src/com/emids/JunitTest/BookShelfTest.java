package com.emids.JunitTest;



import org.junit.Assert;
import org.junit.Test;

import com.emids.domain.Book;
import com.emids.services.BookShelf;
import com.emids.services.Product;

public class BookShelfTest {

	 @Test
		public void whenBookAddedToBookShelf()
		{
			Book book=new Book("java", "gagan", 123.3);
			BookShelf.addBookToBookShelf(book);
			Assert.assertEquals(1,BookShelf.bookList.size());
		}

	 @Test
	 	public void whenBookRemoveFromBookShelf()
	 	{
	    	 Book book=new Book("java", "gagan", 123.3);
	    	 BookShelf.bookList.add(book);
	    	boolean result=Product.getbook(BookShelf.bookList);
	 		if(result) {
	 		BookShelf.removeBookFromShelf(0);
	 		Assert.assertEquals(0,BookShelf.bookList.size());
	 		
	 		
	 	}
}
}
