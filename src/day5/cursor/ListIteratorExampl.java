package day5.cursor;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorExampl {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> linkl = new LinkedList<Integer>();
		linkl.add(10);
		linkl.add(30);
		linkl.add(20);
		linkl.add(50);
		linkl.add(90);
		
		ListIterator<Integer> litr = linkl.listIterator();
		while(litr.hasNext()) {
			int no = litr.next();
			System.out.println(no);
		}
	}

}
