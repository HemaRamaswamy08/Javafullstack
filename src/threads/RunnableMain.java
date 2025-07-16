package threads;

public class RunnableMain {

	public static void main(String[] args) {

		RunnableThreads runnable = new RunnableThreads();

		Thread th = new Thread(runnable);

		// using lambda expression
		Thread t = new Thread(() -> System.out.println("hello"));
		th.start();
		t.start(); // No need to call for run method
		for (int i = 0; i < 10; i++) {
			System.out.println("MAin thread");
		}

	}

}
