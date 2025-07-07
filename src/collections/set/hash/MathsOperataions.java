package collections.set.hash;

import java.util.HashSet;

public class MathsOperataions {

	public static void main(String[] args) {

		HashSet<Integer> setA = new HashSet<Integer>();
		setA.add(10);
		setA.add(14);
		setA.add(67);
		setA.add(null);
		setA.add(15);
		System.out.println(setA);

		HashSet<Integer> setB = new HashSet<Integer>();
		setB.add(10);
		setB.add(86);
		setB.add(14);
		setB.add(15);
		setB.add(null);
		System.out.println(setB);
		/*
		 * union of 2 set setA.addAll(setB);
		 */

		/*
		 * Intersection of 2 set setA.retainAll(setB);
		 */

		/*
		 * to find symmetric difference setA.removeAll(setB);
		 */
		System.out.println(setA);

	}

}
