package day1.revision;

import util.UserInput;

public class AdvanceCalculator implements Calculator {

	public int choiceSElection() {
		System.out.println("Enter a choice to perform below operations");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplicatation");
		System.out.println("4. Division");
		System.out.println("5. Modular Divison");
		int choice = UserInput.getuserInputInt("choice");
		return choice;
	}

	public int opearations(int choice) {

		int a = UserInput.getuserInputInt("Number 1");
		int b = UserInput.getuserInputInt("number 2");
		int result = 0;
		switch (choice) {
		case 1:
			result = add(a, b);
			break;
		case 2:
			result = sub(a, b);
			break;
		case 3:
			result = mult(a, b);
			break;
		case 4:
			result = (int) div(a, b);
			break;
		case 5:
			result = remailder(a, b);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}

		return result;

	}

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mult(int a, int b) {
		return a * b;
	}

	@Override
	public double div(double a, int b) {
		return a / b;
	}

	@Override
	public int remailder(int a, int b) {
		return a % b;
	}

}
