package day1.revision;

public class SimpleApproach implements Calculator {
	public int a;
	public int b;

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mult(int a, int b) {
		return a * b;
	}

	@Override
	public double div(double a, int b) {
		return a / b;
	}

	@Override
	public int remailder(int a, int b) {
		return a % b;
	}

}
