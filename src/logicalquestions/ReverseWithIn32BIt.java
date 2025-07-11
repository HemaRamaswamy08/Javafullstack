package logicalquestions;

public class ReverseWithIn32BIt {
	public static void main(String[] args) {
		// 1534236469
		int num = 1534236469;
		int temp = num;
		long reverse = 0;
		while (temp != 0) {
			reverse = reverse * 10 + temp % 10;
			if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
				return;
			}
			temp = temp / 10;

		}
		System.out.println((int) reverse);
	}

}
