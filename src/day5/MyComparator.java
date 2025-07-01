package day5;


import java.util.Comparator;

import java.util.TreeSet;

public class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
//		if (o1 > o2) {
//			return -1;
//		} else if (o1 < o2) {
//			return +1;
//		} else {
//			return 0;
//		}
		return o2.compareTo(o1);

	}

	public static void main(String[] args) {
		/*
		 * BY default TreeSet has Ascending order but we had given our Own
		 * implementation using comParator where descending order implementation is
		 * given
		 */
//		TreeSet<Integer> customSorting = new TreeSet<Integer>(new MyComparator());
		TreeSet<Integer> customSorting = new TreeSet<>(new MyComparator());
		customSorting.add(10);
		customSorting.add(67);
		customSorting.add(99);
		customSorting.add(21);
		customSorting.add(56);
		System.out.println(customSorting);

	}

}
