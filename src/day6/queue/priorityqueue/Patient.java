package day6.queue.priorityqueue;

import java.util.Comparator;

public class Patient implements Comparator<Patient> {
	private String name;
	private int severity;
	private int waitingTime;

	public Patient() {

	}

	public Patient(String name, int severity, int waiting) {
		this.name = name;
		this.severity = severity;
		this.waitingTime = waiting;
	}

	public String getName() {
		return name;
	}

	public int getSeverity() {
		return severity;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	@Override
	public int compare(Patient o1, Patient o2) {
		if (o1.getSeverity() == o2.getSeverity() ) {
			return o2.getWaitingTime()-o1.getWaitingTime();
		}
		return o2.getSeverity() - o1.getSeverity();
	}

}
