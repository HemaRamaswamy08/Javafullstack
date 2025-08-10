package com.dyashin.restaurent;

import com.dyashin.restaurent.controller.FoodController;
import com.dyashin.restauren.util.ScannerUtil;

public class Main {

	public static void main(String[] args) {

		FoodController control = new FoodController();

		System.out.println("Welcome to our Restaurent");
		System.out.println("i.		Press 1 to 'open food menu' ");
		System.out.println("ii.		Press 2 to 'search the food' ");
		System.out.println("iii.	Press 3 to 'show all the food items' ");
		System.out.println("iv.		Press 4 to 'Operate on food Database' ");
		int choice = ScannerUtil.getIntInput("Choice");

		switch (choice) {
		case 1:
			control.displayFoodOptions();
			break;
		case 2:
			control.searchAndDisplay();
			break;
		case 3:
			control.displayTable();
			break;
		case 4:
			control.dbOperatations();
		default:
			break;
		}

	}

}
