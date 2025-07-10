package logicalquestions;

public class ReverseWithIn32BIt {
	public static void main(String[] args) {
		int num = 1534236469;
		int temp = num;
		int reverse = 0;
		while(temp!=0) {
			reverse = reverse*10+temp %10;
			temp = temp/10;
		}
		System.out.println(Math.pow(2, 31)-1);
		if(reverse >Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
			System.out.println(0);
			return;
		}
		if(num <0) {
			System.out.println(reverse*-1);
		}else {
			System.out.println(reverse);
		}
	}

}
