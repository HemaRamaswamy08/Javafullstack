package day4.markerinterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class RandomAccessInterface {

	public static void accessElements(List<Integer> e) {
		int size = e.size();
		for (int i = 0; i < size; i++) {
			e.get(i);
		}

	}

	public static void main(String[] args) {
		System.out.println("performing");

		ArrayList<Integer> arr = new ArrayList<Integer>();
		LinkedList<Integer> li = new LinkedList<Integer>();

		for (int i = 0; i < 1000; i++) {
			arr.add(i);
			li.add(i);
		}

		// Measure the time taken to perform random access operations
		long startTime = System.nanoTime();
		accessElements(arr);
		long arrayListTime = System.nanoTime() - startTime;

		startTime = System.nanoTime();
		accessElements(li);
		long listTime = System.nanoTime() - startTime;

		// Compare the performance of ArrayList and LinkedList
		System.out.println("ArrayList time: " + arrayListTime + " ns");
		System.out.println("LinkedList time: " + listTime + " ns");
		System.out.println("ArrayList isRandomAccess: " + (arr instanceof RandomAccess));
		System.out.println("LinkedList isRandomAccess: " + (li instanceof RandomAccess));
		System.out.println("ArrayList time is Less than LinkedList because ArrayLIst implented by RandomAcess but Linked is not");

	}

}
