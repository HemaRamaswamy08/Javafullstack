package day3;

import java.util.ArrayList;

public class FirstArrayList {

	public static void main(String[] args) {

		ArrayList<Object> arr = new ArrayList<>();
		arr.add("java");
		arr.add("Python");
		arr.add("C");
		arr.add("C++");

		// Iterating through the list
		for (Object object : arr) {
			System.out.println(object);
		}
		System.out.println(arr);

		// Accessing elements
		System.out.println("Aceesing element using index :" + arr.get(3));

		// Updating elements
		arr.set(1, "JavaScript");
		System.out.println(arr);
		
		//removing the element 
		arr.remove("C++");
		System.out.println("After remove :" + arr);
		
		System.out.println(arr.listIterator());;

	}

}
