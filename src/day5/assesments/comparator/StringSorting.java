package day5.assesments.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class StringSorting implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() != o2.length()) {
			return Integer.compare(o1.length(), o2.length());
		}
		return o1.compareTo(o2);
	}
	
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("Watermelon");
		fruits.add("Apple");
		fruits.add("Kivi");
		fruits.add("mango");
		fruits.add("orange");
		
		Collections.sort(fruits, new StringSorting());
		Iterator<String> itr = fruits.iterator();
		
		while(itr.hasNext()) {
			String elem = itr.next();
			System.out.println(elem);
		}
		
	}

}
