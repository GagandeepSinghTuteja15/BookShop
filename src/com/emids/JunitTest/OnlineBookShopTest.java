package com.emids.JunitTest;

import java.io.InputStream;

import org.junit.Test;
import org.mockito.Mockito;

import com.emids.Main.OnlineBookShop;

public class OnlineBookShopTest {

	@Test
	public void whenAdminEnterWrongInput() {
		OnlineBookShop bookShop = new OnlineBookShop();
		InputStream result = bookShop.adminTask();
		Mockito.when(System.in).thenReturn(result);
	}

	@Test
	public void whenUserEnterWrongInput() {
		OnlineBookShop bookShop = new OnlineBookShop();
		InputStream result = bookShop.userTask();
		Mockito.when(System.in).thenReturn(result);
	}
	
}
