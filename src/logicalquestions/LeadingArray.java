package logicalquestions;

import java.util.ArrayList;
import java.util.List;

public class LeadingArray {

	public static void leadingElements(int[] arr) {

		List<Integer> leading = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			boolean isLeading = true;
			for (int j = i; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					isLeading = false;
					break;
				}
			}
			if (isLeading) {
				leading.add(arr[i]);
			}
		}
		System.out.println(leading);
	}

	public static void main(String[] args) {
		int[] arr = { 56, 45,48, 23, 10, 20,37};
		LeadingArray.leadingElements(arr);
	}

}
