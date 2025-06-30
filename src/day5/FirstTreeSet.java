package day5;

import java.util.TreeSet;

public class FirstTreeSet {
	
	public static void main(String[] args) {
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(10);
		treeSet.add(25);
		treeSet.add(10);
		treeSet.add(29);
		treeSet.add(9);
		System.out.println(treeSet);
	}

}
