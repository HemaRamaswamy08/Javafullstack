package day1.revision;

import util.UserInput;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to our Applicatation");
		System.out.println("What type of calculation do you want");
		System.out.println(" 1. Simple Calculator");
		System.out.println(" 2. Moderate Calculator");
		System.out.println(" 3. Advacnce Calculator");

		int choice = UserInput.getuserInputInt("choice");

		switch (choice) {
		case 1: {
			SimpleApproach simple = new SimpleApproach();
			int add = simple.add(10, 15);
			System.out.println("Addition " + add);

			int sub = simple.sub(10, 15);
			System.out.println("Subtraction :" + sub);

			int mult = simple.mult(10, 15);
			System.out.println("Multiplicatation :" + mult);

			Double div = simple.div(10, 15);
			System.out.println("Division :" + div);

			int rema = simple.remailder(10, 15);
			System.out.println("Remailnder :" + rema);
			break;
		}
		case 2: {
			ModerateApproach moderte = new ModerateApproach();
			int first = moderte.getFirstInput();
			int secone = moderte.getSecondInput();

			int add = moderte.add(first, secone);
			System.out.println("Addition :" + add);

			int sub = moderte.sub(first, secone);
			System.out.println("Subtraction :" + sub);

			int mult = moderte.mult(first, secone);
			System.out.println("Multiplicatation :" + mult);

			double div = moderte.div(first, secone);
			System.out.println("Division :" + div);

			int rema = moderte.remailder(first, secone);
			System.out.println("Addition :" + rema);

			break;

		}
		case 3: {
			AdvanceCalculator advance = new AdvanceCalculator();
			int choose = advance.choiceSElection();
			int result = advance.opearations(choose);
			System.out.println("The result of " + choose + " operation is :" + result);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}

	}

}
