package day6.queue.priorityqueue.ticketmanagement;

import util.UserInput;

public class TicketMain {

	public static void main(String[] args) {

		TicketCustomer t = new TicketCustomer();
		System.out.println("Welcome to Ticket Management System");

		int choice = 1;
		while (choice != 4) {
			System.out.println(" 1 . Add Customer \n 2 . Serve Customer:\n" + " 3 . Display Customers \n 4 . EXit");
			choice = UserInput.getuserInputInt("choice");

			switch (choice) {
			case 1 -> {
				String name = UserInput.getuserInputString("Name");
				int choose = 1;
				while (choose !=1 || choose !=2) {
					System.out.println(" 1. VIP Seat \n  2. Norma Seat");
					choose = UserInput.getuserInputInt("Option");
					if (choose == 1) {
						t.addVip(name);
						break;
					} else if (choose == 2) {
						t.addNormal(name);
						break;
					} else {
						System.out.println("Wrong choice");
					}
				}
			}
			case 2 -> t.serveCustomer();
			case 3 -> t.display();
			case 4 -> System.out.println("Thank You");
			default ->System.out.println("Wrong input");
				
			

			}
		}
	}

}
