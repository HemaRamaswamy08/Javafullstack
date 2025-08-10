package com.dyashin.restauren.util;

import java.util.Scanner;

public class ScannerUtil {

	private ScannerUtil() {

	}

	public static final Scanner SCANNER = new Scanner(System.in);

	public static String getStringInput(String name) {
		System.out.println("Enter " + name + " value : ");
		return SCANNER.nextLine();
	}

	public static int getIntInput(String name) {
		System.out.println("Enter " + name + " value : ");
		return Integer.parseInt(SCANNER.nextLine()) ;
	}
}
