package day5.cursor;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorArray {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=1; i<15; i++) {
			arr.add(i);
		}
		
		Iterator<Integer> itr = arr.iterator();
		while(itr.hasNext()) {
			int num = itr.next();
			
			if(num%2 ==0) {
				System.out.println(num);
			}else {
				itr.remove();
			}
		}
		
		
	}
}
