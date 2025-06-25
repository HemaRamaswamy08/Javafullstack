package util;

import java.util.Scanner;

public class UserInput {

	private UserInput() {
		
	}
	
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public static int getuserInputInt(String num) {
		System.out.println("Enter a "+ num);
		return SCANNER.nextInt();
	}

}
