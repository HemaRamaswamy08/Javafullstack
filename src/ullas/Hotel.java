package ullas;

public class Hotel extends Thread {
	boolean isPrepared = false;

	public synchronized void Producer() {
		for (int i = 0; i < 3; i++) {

			while ( isPrepared) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Food Prepared");
			isPrepared = true;
			notify();
		}
	}

	public synchronized void Consumer() {
		for (int i = 0; i < 3; i++) {

			while (! isPrepared) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Food Received");
			isPrepared = false;
			notify();
		}
	}

	public static void main(String[] args) {

		Hotel h1 = new Hotel();
		Thread t = new Thread(()->{
			h1.Producer();
		});
		
		Thread r = new Thread(()->{
			h1.Consumer();
		});
		t.start();
		r.start();
		

	}

}
