package ullas;

public class ProducerBuffer extends Thread {

	boolean bufferFull = true;

	public synchronized void Producer() {
		for (int i = 1; i < 5; i++) {
			while (!bufferFull) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("Producer :" + i);
			bufferFull = false;
			notify();
		}
	}

	public synchronized void Consumer() {

		for (int i = 1; i < 5; i++) {

			while (bufferFull) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("Consumer " + i);
			bufferFull = true;
			notify();
		}
	}

	public static void main(String[] args) {

		ProducerBuffer b = new ProducerBuffer();
		Thread t1 = new Thread(() -> {
			b.Producer();
		});

		Thread t2 = new Thread(() -> {
			b.Consumer();
		});
		t1.start();
		t2.start();
	}

}
