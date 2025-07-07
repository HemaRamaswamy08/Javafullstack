package collections.set.tree;

import java.util.TreeSet;

public class StringBufferTreeSet {
	public static void main(String[] args) {

		/*
		 * Classes which implements Comparable Interface can store in TreeSet effortlessly
		 * 
		 * But if we are creating TreeSet of user defined classes or any Java classes which does not
		 *  implements comparable interface we will get ClassCastException.
		 *  In order to solve this either we have to Implement that class By Comparable for default ordering
		 *  or Comparator for custom ordering b/w objects (compare method) is override
		 */
		 
		

		TreeSet<StringBuffer> alphabets = new TreeSet<>();

		alphabets.add(new StringBuffer("A"));
		alphabets.add(new StringBuffer("b"));
		alphabets.add(new StringBuffer("C"));
		alphabets.add(new StringBuffer("d"));
		alphabets.add(new StringBuffer("1"));

		System.out.println(alphabets);
	}

}
