package day5.cursor;

import java.util.Enumeration;
import java.util.Vector;

public class EnumVector {
	
	public static void main(String[] args) {
		
		Vector<Integer> vect = new Vector<Integer>();
		for (int i = 0; i <10; i++) {
			vect.add(i);
		
		}
		
		Enumeration<Integer> enums = vect.elements();
		while(enums.hasMoreElements()) {
			Integer no = enums.nextElement();
			if(no %2 ==0) {
				System.out.println(no);
			}
			
		}
	}

}
