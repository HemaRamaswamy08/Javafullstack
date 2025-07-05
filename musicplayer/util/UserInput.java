package musicplayer.util;

import java.util.Scanner;

public class UserInput {

	private UserInput() {

	}

	public static final Scanner SCANNER = new Scanner(System.in);

	public static String getUserInputString(String values) {
		System.out.println("Enter a " + values);
		return SCANNER.next();

	}
	
	public static int getUserInputInt(String string) {
		System.out.println("Enter a " + string);
		return SCANNER.nextInt();

	}

}
