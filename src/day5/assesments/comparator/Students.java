package day5.assesments.comparator;

import java.util.Comparator;

public class Students implements Comparator<Students> {

	private String name;
	private int marks;

	public String getName() {
		return name;
	}

	public int getMarks() {
		return marks;
	}

	public Students(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public Students() {
		
	}
	@Override
	public int compare(Students o1, Students o2) {
		
		if(o1.marks != o2.marks) {
//			return  o2.marks-o1.marks;
			return Integer.compare(o2.marks, o1.marks);
		}
		return o1.name.compareTo(o2.name);
		
	}
	
	

}
