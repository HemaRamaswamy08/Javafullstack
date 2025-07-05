package java8features.lambdaexpresexample;

public class Main {

	public static void main(String[] args) {
		Runnable method = () -> System.out.println("my method");
		Thread th = new Thread(method);
		th.start();

	}

}
