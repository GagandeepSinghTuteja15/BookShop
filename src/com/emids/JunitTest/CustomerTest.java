package com.emids.JunitTest;


import org.junit.Assert;
import org.junit.Test;

import com.emids.services.Admin;

public class CustomerTest {
	
		@Test
		public void whenCustomerValidationTrue()
		{
			Admin admin= new Admin();
			
			Assert.assertEquals("CustomerExist", admin.checkDetails("user", "user"));
		}
		@Test
		public void whenCustomerValidationFalse()
		{
			Admin admin= new Admin();
			
			Assert.assertEquals("NoMatch", admin.checkDetails("user", "gagan"));
		}

		
}
