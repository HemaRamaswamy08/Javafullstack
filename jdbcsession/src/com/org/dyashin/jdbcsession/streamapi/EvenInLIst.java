package com.org.dyashin.jdbcsession.streamapi;

import java.util.ArrayList;
import java.util.Iterator;

public class EvenInLIst {
	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(2);
		arr.add(26);
		arr.add(21);
		arr.add(24);
		arr.add(9);
		arr.add(5);
		
		Iterator<Integer> evenArr = arr.iterator();
		while (evenArr.hasNext()) {
			Integer integer = (Integer) evenArr.next();
			if(integer % 2==0) {
				System.out.println(integer);
			}
			
		}
		
		
	}
}
