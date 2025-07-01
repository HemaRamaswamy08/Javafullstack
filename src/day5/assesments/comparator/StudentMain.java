package day5.assesments.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudentMain {
	public static void main(String[] args) {
		List <Students> students = new ArrayList<Students>();
		students.add(new Students("hema",98));
		students.add(new Students("nisha",95));
		students.add(new Students("reshma",98));
		
		Collections.sort(students, new Students());
		
		Iterator<Students> itr = students.iterator();
		while (itr.hasNext()) {
			Students students2 = (Students) itr.next();
			System.out.println(students2.getName() + " " + students2.getMarks());
		}
		
	}

}
