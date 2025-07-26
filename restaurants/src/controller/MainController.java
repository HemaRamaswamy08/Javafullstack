package controller;

import java.util.Scanner;

import dao.FoodMenuDetailsDAO;
import dao.FoodMenuDetailsImpl;

public class MainController {

	public static void main(String[] args) {

		FoodMenuDetailsDAO foodDetails = new FoodMenuDetailsImpl();

		System.out.println("Press 1. to “ open food menu”");
		System.out.println("Press 2. to “search the food”");
		System.out.println("Press 3 to “show all the food items”");
		System.out.println(" Press 4 Operate on food Database");

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num == 1) {
			foodDetails.menuDetails();
		} else if (num == 2) {
			foodDetails.searchFood();
		} else if (num == 3) {
			foodDetails.showAll();
		} else if (num == 4) {
			foodDetails.menuOperatation();
		}

	}

}
