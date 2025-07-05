package threads;

public class RunnableMain {

	public static void main(String[] args) {

		RunnableThreads runnable = new RunnableThreads();

		Thread th = new Thread(runnable);
		th.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("MAin thread");
		}
	}

}
