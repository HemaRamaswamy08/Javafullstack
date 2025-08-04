package hackerrank;

public class TrappingRainWater {
	int result = 0;

	public static void main(String[] args) {

		int base = 1;
		int result = 0;
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i]==0) {
				continue;
			}
			int max = Math.max(arr[i], arr[i + 1]);
			if (base < Math.max(arr[i], arr[i + 1])) {
				base = max;
			}
			result = base-arr[i];
			System.out.println(i + " "+base);
		}
	}
}
