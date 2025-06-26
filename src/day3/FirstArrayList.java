package day3;

import java.util.ArrayList;

public class FirstArrayList {

	public static void main(String[] args) {
		
		ArrayList<Object> arr =  new ArrayList<>();
		arr.add(10);
		arr.add("hema");
		arr.add(true);
		arr.add("nish");
		arr.addFirst("first");
		arr.addLast("last");
		
		for (Object object : arr) {
			System.out.println(object);
		}
		
		System.out.println("At 2nd position "+ arr.get(2));
		System.out.println("Contains : " + arr.contains("nish"));

	}

}
