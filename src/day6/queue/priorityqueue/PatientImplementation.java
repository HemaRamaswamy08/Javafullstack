package day6.queue.priorityqueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PatientImplementation {

	int noOfPatients;
	int time;
	int avgTime;

	PriorityQueue<Patient> patientsPriority = new PriorityQueue<Patient>(new Patient());
	ArrayList<Patient> treatedPatients = new ArrayList<Patient>();

	public void addPatient(Patient p) {
		patientsPriority.add(p);
		System.out.println("added sucessfully");
	}

	public void allPatients() {
		/*
		 * It is a shallow copy means refer to the same queue PriorityQueue<Patient>
		 * duplicate = patientsPriority;
		 */
		PriorityQueue<Patient> duplicate = new PriorityQueue<Patient>(patientsPriority.size(), new Patient());
		duplicate.addAll(patientsPriority);
		while (!duplicate.isEmpty()) {
			Patient p = duplicate.poll();
			noOfPatients++;
			time += p.getWaitingTime();
			System.out.println(p.getName() + " with Sevirity " + p.getSeverity() + " waiting from " + p.getWaitingTime()
					+ "minutes");
		}
	}

	public void canclePatient(String name) {
		Iterator<Patient> patientsIterator = patientsPriority.iterator();
		while (patientsIterator.hasNext()) {
			Patient p = patientsIterator.next();

			if (p.getName().equalsIgnoreCase(name)) {
				patientsIterator.remove();
				System.out.println(name + " Patient removed successfully");

				return;
			}
		}
		System.out.println("Not found");
	}

	public int getAvgTime() {
		return time / noOfPatients;
	}

}
