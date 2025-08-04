package hackerrank;

public class DivideTwoIntegers {

	public int divide(int num1, int num2) {
		int count = 0;
		if (num2 > 0) {
			num1 = num2 - num1;
			count++;
		} else {
			num1 = num2 - (-1 * num2);
			count++;
		}
		return count;

	}

	public static void main(String[] args) {

		DivideTwoIntegers div = new DivideTwoIntegers();
		System.out.println(div.divide(10, -3));

	}

}
