package threads;

import java.util.LinkedList;

public class Sharedzbuffer {
	private static final int CAPACITY = 3;
	private final LinkedList<Integer> buffer = new LinkedList<>();
	private int value = 1;

	public synchronized void producer() {
		for (int i = 0; i < 10; i++) {
			while (buffer.size() == CAPACITY) {
				try {
					System.out.println("Buffer full, producer waiting...");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			buffer.add(value);
			System.out.println("Produced: " + value);
			value++;

			notify(); // Wake up waiting consumer

			try {
				Thread.sleep(1000); // simulate time to produce
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void consumer() {
		for (int i = 0; i < 10; i++) {
			while (buffer.isEmpty()) {
				try {
					System.out.println("Buffer empty, consumer waiting...");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			int val = buffer.removeFirst(); // now safe: buffer is LinkedList
			System.out.println("Consumed: " + val);

			notify(); // Wake up producer

			try {
				Thread.sleep(1500); // simulate time to consume
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Sharedzbuffer s = new Sharedzbuffer();
		for (int i = 0; i < 3; i++) {
			Thread t1 = new Thread(() -> s.producer());
			t1.start();
		}
		for (int i = 0; i < 3; i++) {
			Thread t2 = new Thread(() -> s.producer());
			t2.start();
		}
	}
}
