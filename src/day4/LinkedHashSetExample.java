package day4;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
	
	public static void main(String[] args) {
		
		LinkedHashSet <Integer> num =  new LinkedHashSet<>();
		num.add(10);
		num.add(20);
		num.add(null);
		num.add(10);
		num.add(30);
		System.out.println(num);
	}

}
