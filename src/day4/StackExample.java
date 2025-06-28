package day4;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {

		/*
		 * Generics are used for type safety 
		 * <Integer> -> generic of Integer , <Float> ->float type generic ,
		 *  <String> ->String type generic
		 */
		
		Stack<Integer> srci = new Stack<>();
		Stack <String> str = new Stack<String>();
		srci.add(10);
		srci.add(25);
		srci.add(99);
		srci.add(66);
		System.out.println(srci);
		srci.pop();
		System.out.println(srci);
		System.out.println(srci.peek());
		System.out.println(srci.search(25));
		
		

	}

}
