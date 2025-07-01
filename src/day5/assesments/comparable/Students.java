package day5.assesments.comparable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Students implements Comparable<Students>{
	
	private String name;
	private int age;

	public Students(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}


	@Override
	public int compareTo(Students o) {
//		return o.getAge()-this.age;
		return this.age-o.getAge();
	}
	public static void main(String[] args) {
		List< Students> li = new LinkedList<>();
		li.add(new Students("Hema", 22));
		li.add(new Students("manvith", 18));
		li.add(new Students("sandeep", 28));
		
		Collections.sort(li);
		System.out.println("Students after sorting based on their ages");
		for (Students s : li) {
			System.out.println(s.getName() + " " + s.getAge());
		}
	}

}
