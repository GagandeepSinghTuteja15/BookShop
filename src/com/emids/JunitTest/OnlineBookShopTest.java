package com.emids.JunitTest;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import com.emids.utilities.UserInput;



public class OnlineBookShopTest {
	@Mock
	static Scanner scanner = new Scanner(System.in);


	/*@Test
	public void whenAdminEnterWrongInput() {
		  
	}*/

	@Test
	public void whenUserEnterWrongInput() {
//	    Mockito.when(UserInput.getInput()).thenReturn(6);
//	    OnlineBookShop.adminTask();
	Assert.assertEquals(6,UserInput.getInput());
	}
	
	
	
}
