package day6.queue.priorityqueue;

import util.UserInput;

public class PatientMain {

	public static void main(String[] args) {

		int choice = 1;
		PatientImplementation p = new PatientImplementation();
		while (choice != 5) {
			System.out.println(" 1 Add a new patient \n 2.Cancel a patient by name (if they left before treatment) \n"
					+ " 3. Treat all patients in order \n" + " 4 .Show average waiting time of treated patient"
					+ "\n 5 Exit");
			choice = UserInput.getuserInputInt("choice");

			switch (choice) {
			case 1 -> {
				String name = UserInput.getuserInputString("Patient name");
				int severity = UserInput.getuserInputInt("severity");
				int waitingTime = UserInput.getuserInputInt("Waiting time");
				p.addPatient(new Patient(name, severity, waitingTime));
			}
			case 2 -> {
				String name = UserInput.getuserInputString("Patient name");
				p.canclePatient(name);
			}
			case 3 -> p.allPatients();
			case 4 -> System.out.println(p.getAvgTime());
			case 5 -> System.out.println("Thank You");

			}
		}

	}

}
