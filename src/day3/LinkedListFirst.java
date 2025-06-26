package day3;

import java.util.LinkedList;

public class LinkedListFirst {
	public static void main(String[] args) {

		LinkedList<String> names = new LinkedList<String>();

		names.add("hema");
		names.add("manvith");
		names.add("sandeep");
		names.add("swamygowda");
		names.add("veena");
		names.add("Rama");
		names.add("soma");
		names.add("soniya");
		System.out.println(names);
		System.out.println("Revesred -" + names.reversed());
//		System.out.println(names.clone());
		System.out.println(names.element());
		System.out.println(names.hashCode());
		System.out.println(names.offer("veena"));

		System.out.println("contains veena -" + names.contains("veena"));
		for (String string : names) {
//			System.out.println(string);
		}

		System.out.println("Size of " + names.size());

	}

}
