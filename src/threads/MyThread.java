package threads;

public class MyThread extends Thread {
	/*
	 * we don't know which thread will executing first , Thread scheduler handle
	 * which method to call first
	 * 
	 * start method - > it is used to create thread & invoke the run method
	 */

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread inside run");
		}
	}

	public void run(int a) {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread inside run");

		}
	}

	public static void main(String[] args) {

		MyThread myThread = new MyThread();
		System.out.println(myThread.getState());
		myThread.start();

		System.out.println(myThread.getName());
		myThread.setName("Nisha");
		System.out.println(myThread.getName());

		System.out.println("My Thread priority :" + myThread.getPriority());

		myThread.setPriority(1);
		System.out.println("My Thread priority after set :" + myThread.getPriority());

		System.out.println("Get state :" + myThread.getState());
		for (int i = 0; i < 10; i++) {
			System.out.println("Main thread");
		}
//		myThread.start(); -->java.lang.IllegalThreadStateException

	}

}
