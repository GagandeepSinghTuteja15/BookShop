package com.emids.utilities;

import java.util.Scanner;

public class UserInput {
	static Scanner scanner =new Scanner(System.in);
	
	public static int getInput()
	{	
	int value = scanner.nextInt();
	return value;
	}
	
	public static int selectSerialNumber() {
		System.out.println("Write serial no to Select book\n");
		int number = scanner.nextInt();
		return number;
	}
}
