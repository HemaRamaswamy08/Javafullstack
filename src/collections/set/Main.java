package collections.set;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		HashSet<Integer> ha = new HashSet<Integer>();
		ha.add(10);
		ha.add(5);
		ha.add(18);
		ha.add(null);
		System.out.println("Unique elemets, No insertion order , null at first"+ha);
		
		LinkedHashSet<Integer> li = new LinkedHashSet<Integer>();
		li.add(5);
		li.add(10);
		li.add(null);
		li.add(18);
		li.add(6);
		

		System.out.println("Unique elements ,Insertion order preserved , null value accepted, not sorted "+li);

		TreeSet<Integer> tr = new TreeSet<Integer>();
		tr.add(5);
		tr.add(10);
		tr.add(18);
		tr.add(6);
//		tr.add(null); --> .NullPointerException
		System.out.println("Ordered , No Null , No Insertion ordered"+tr);
		
	}

}
