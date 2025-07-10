package day6.queue.priorityqueue.ticketmanagement;

import java.util.ArrayDeque;
import java.util.Deque;

public class TicketCustomer {
	private Deque<String> normal;
	private Deque<String> vips;

	public TicketCustomer() {
		this.normal = new ArrayDeque<String>();
		this.vips = new ArrayDeque<String>();
	}

	public void addVip(String name) {
		vips.addLast(name);
	}

	public void addNormal(String name) {
		normal.addLast(name);
	}

	public void display() {
		if (vips.isEmpty() && normal.isEmpty()) {
			System.out.println("No Customers");
			return;
		}
		int count = 1;
		if (!vips.isEmpty()) {
			System.out.println("VIP Customers");

			for (String string : vips) {
				System.out.println(count + " :" + string + " (VIP)");
				count++;
			}
		}

		if (!normal.isEmpty()) {
			System.out.println("Regular Customers");

			for (String string : normal) {
				System.out.println(count + " :" + string);
				count++;
			}
		}

	}


	public void serveCustomer() {
		String serverCustomer = null;
		if(!vips.isEmpty()) {
			serverCustomer = vips.poll();
			System.out.println("Serving VIP Customer : " +serverCustomer);
		}else if(! normal.isEmpty()) {
			serverCustomer= normal.poll();
			System.out.println("Serving Regular Customer : " +serverCustomer);
		}else {
			System.out.println("NO Customer in the queue to serve");
		}
	}

}
