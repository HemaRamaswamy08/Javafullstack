package ullas;

public class EvenOdd extends Thread {
	public static int i = 1;
	public static int count = 0;

	public synchronized void Odd() {

		while (count < 10) {

			while (i % 2 == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Odd :" + i);
			i = i + 1;
			count++;
			notify();
		}
	}

	public synchronized void Even() {

		while (count < 10) {
			while (i % 2 != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Even :" + i);
			i = i + 1;
			notify();
			count++;
		}
	}

	public static void main(String[] args) {
		EvenOdd e = new EvenOdd();
		Thread t1 = new Thread(() -> {
			e.Odd();
		});

		Thread t2 = new Thread(() -> {
			e.Even();
		});

		t1.start();
		t2.start();
	}

}
